package vor;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Color;
import java.awt.Graphics2D;

public class Images {

    Graphics2D g2d;

    private Images(Graphics g) {
        this.g2d = (Graphics2D) g.create();
    }

    public static Images create(Graphics g) {
        return new Images(g);
    }

    public Images render(ImageObserver context, String key, int x, int y) {
        BufferedImage image = Resources.image(key);
        if (image != null) {
            g2d.drawImage(image, x, y, context);
        }
        return this;
    }

    //rotate image based on input received
    public Images renderRotated(ImageObserver context, String key, int x, int y, double degrees) {
        BufferedImage image = Resources.image(key);
        if (image != null) {
            double rad = Math.toRadians(degrees);
            double w = image.getWidth() / 2;
            double h = image.getHeight() / 2;
            AffineTransform at = AffineTransform.getRotateInstance(rad, w, h);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(image, null), x, y, context);
        }
        return this;
    }

    //renders stick used for VOR
    public Images renderStick(int x, int y, int length, double degrees, int thickness, Color color) {
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(color);
        double rad = Math.toRadians(degrees);
        int a = x + (int) (length * Math.cos(rad));
        int b = y + (int) (length * Math.sin(rad));
        g2d.drawLine(x, y, a, b);
        return this;
    }

    //used font from libgdx
    public Images renderChar(ImageObserver context, String font, int x, int y, String text) {
        BufferedImage f = Resources.image(font);
        if (f != null) {
            String fontmap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            text = text.toUpperCase();
            for (int i = 0; i < text.length(); i++) {
                int token = fontmap.indexOf(text.charAt(i));
                if (token != -1) {
                    g2d.drawImage(f.getSubimage(token * 25, 0, 25, 41), x, y, context);
                }
                x += 31;
            }
        }
        return this;
    }

    public Images render(ImageObserver context, String key, int x, int y, int sx, int sy, int w, int h) {
        BufferedImage image = Resources.image(key);
        if (image != null) {
            g2d.drawImage(image.getSubimage(sx, sy, w, h), x, y, context);
        }
        return this;
    }

    public void clean() {
        g2d.dispose();
    }
}
