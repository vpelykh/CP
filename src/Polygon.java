import java.awt.*;
import java.applet.*;


public class Polygon extends Applet implements Runnable {
    private Thread thread = null;
    private int starx[] =
            { 112, 87, 6, 71, 47, 112, 176, 151, 215, 136 };
    private int stary[] =
            { 0, 76, 76, 124, 200, 152, 200, 124, 76, 76 };
    private boolean isRunning = false;
    private Color c = Color.GREEN;

    public void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public void stop() {
        isRunning = false;
        thread = null;
    }

    public void run() {
        while (isRunning) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.fillPolygon(starx, stary, starx.length);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(starx, stary, starx.length);
        g2d.rotate(Math.toRadians(5), 112, 0);
    }

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "true");

        Frame f = new Frame("Rotating Polygon Applet");
        f.setSize(600, 600);
        f.setVisible(true);

        Polygon applet = new Polygon();
        applet.start();

        f.add(applet);
    }

}
