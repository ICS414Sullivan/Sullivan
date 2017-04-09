import javax.swing.AbstractAction;
import java.awt.event.WindowEvent;
import javax.swing.Action;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.KeyStroke;

//create window for application
public class Window {

    public static final String APP = "VOR";
    private JFrame frame;
    private PlacePics placePics;

    public Window() {
        placePics = new PlacePics();
        frame();
    }

    private void frame() {
        frame = new JFrame(APP);
        frame.add(placePics);
        menuBar();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                quit();
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void menuBar() {
        JMenu file = new JMenu("File");

        file.add(new JMenuItem(exit));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);
        frame.setJMenuBar(menuBar);
    }

    Action exit = new AbstractAction("Exit") {
        {
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                    KeyEvent.VK_Q, Toolkit.getDefaultToolkit()
                            .getMenuShortcutKeyMask()));
        }

        public void actionPerformed(ActionEvent e) {
            quit();
        }
    };

    public void quit() {
        Runtime.getRuntime().exit(0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window();
            }
        });
    }
}
