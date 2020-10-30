import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundViewer extends JPanel {
    GameFSM g_fsm;
    BackgroundLoader bg_loader;

    BackgroundViewer(GameFSM _g_fsm){
        setOpaque(false);

        this.g_fsm = _g_fsm;
        this.bg_loader = new BackgroundLoader();
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bg_loader.floorColor);
        Rectangle2D.Double rect = new Rectangle2D.Double(0,
                420, 650, 30);
        g2d.fill(rect);

        g2d.setColor(bg_loader.stepColor);
        for(int i=0; i<bg_loader.stepPositionsX.length; i++){
            rect = new Rectangle2D.Double(bg_loader.stepPositionsX[i],
                    bg_loader.stepPositionsY[i], bg_loader.stepLength[i], 10);
            g2d.fill(rect);
        }

        g2d.dispose();
    }
}
