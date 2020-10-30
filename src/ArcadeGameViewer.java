import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArcadeGameViewer implements ActionListener {
    JFrame gameFrame;

    ArcadeGameViewer(){
        GameFSM g_fsm = new GameFSM();

        this.gameFrame = new JFrame();
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameFrame.setSize(640, 480);
        this.gameFrame.setResizable(false);

        this.gameFrame.setVisible(true);
        this.gameFrame.getContentPane().setBackground(Color.BLACK);


        this.gameFrame.add(new BackgroundViewer(g_fsm), BorderLayout.CENTER);
        this.gameFrame.add(new HeroViewer(g_fsm), BorderLayout.CENTER);


        this.gameFrame.validate();
        this.gameFrame.repaint();

        this.gameFrame.addKeyListener(g_fsm);

        new javax.swing.Timer(2, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameFrame.validate();
        this.gameFrame.repaint();
    }
}
