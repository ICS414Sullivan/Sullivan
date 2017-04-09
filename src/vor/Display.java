package vor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

//places our images onto the window we created in the app method
public class Display extends JPanel implements KeyListener, RadioListener {

    private VOR vor;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(512, 576);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            onRotateOBS(-1);
        } else if (key == KeyEvent.VK_RIGHT) {
            onRotateOBS(1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double wheelDegrees = 360 - vor.getOBS();
        double obsDegrees = (3 * wheelDegrees) % 360;
        boolean signalGood = vor.signalGood();

        Images images = Images.create(g)
                .render(this, "base", 0, 0)
                .renderRotated(this, "obs", 7, 470, obsDegrees)
                .renderRotated(this, "wheel", 0, 64, wheelDegrees);
        if (signalGood) {
            images.render(this, vor.goingTo() ? "to" : "from", 305, 299);
        }
        images.render(this, signalGood ? "good" : "bad", 160, 309)
                .renderStick(256, 192, 257, 90 + (5 * vor.getCDI() / 2), 6, Color.WHITE)
                .renderChar(this, "font", 33, 25, String.format("%03d", vor.getOBS()))
                .clean();
    }

    public void onRotateOBS(int delta) {
        vor.rotateOBS(delta);
        this.repaint();
    }
    
    public Display() {
        vor = new VOR();
        vor.radioListener(this);
        Resources.loadImages(new String[]{"base", "obs", "wheel", "to", "from", "good", "bad", "font"});
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void incomingData() {
        this.repaint();
    }

    //These methods are not used, but after much research and some trial and error, I discovered you needed them in order to run the program
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
