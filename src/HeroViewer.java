import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.round;

public class HeroViewer extends JPanel {
    BufferedImage img;
    GameFSM g_fsm;

    float heroPos[]; // X, Y
    float heroVelocity[];

    HeroViewer(GameFSM _g_fsm){
        setOpaque(false);

        this.g_fsm = _g_fsm;
        this.heroPos = new float[]{320, 240};
        this.heroVelocity = new float[]{0, 1f};

        try {
            this.img = ImageIO.read(new File("resources/hero.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        float[] heroSpeed = this.g_fsm.getMovingVector();
        this.heroPos[0] += this.heroVelocity[0];
        this.heroPos[1] += this.heroVelocity[1];

        this.heroVelocity[0] += (heroSpeed[0] - this.heroVelocity[0]) * 0.4;
        this.heroVelocity[1] += (heroSpeed[1] - this.heroVelocity[1]) * 1 + 0.5;

        System.out.printf("Vol:%.02f,%.02f \tPos:%.02f,%.02f\n", this.heroVelocity[0], this.heroVelocity[1], this.heroPos[0], this.heroPos[1]);
        if(heroPos[1] > 290){
            heroPos[1] = 290;
        }

        AffineTransform t = new AffineTransform();
        t.translate(this.heroPos[0], this.heroPos[1]);
        t.scale(0.1, 0.1); // scale = 1
        g2d.drawImage(this.img, t, null);

        g2d.dispose();
    }
}
