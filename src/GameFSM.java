import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFSM implements KeyListener{

    enum GAME_STATE {
        BEGIN_ANIME,
        MAIN_MENU,
        HELP_MENU,
        PLAY,
        PAUSE,
        THS_ANIME,
        DEAD,
        WIN
    }

    int currHurdles;
    GAME_STATE currGameState;

    // X, Y Motion Vector
    float[] movingVector;

    GameFSM() {
        this.currGameState = GAME_STATE.MAIN_MENU;
        this.movingVector = new float[]{0, 0};

        this.currHurdles = 0;
    }

    public float[] getMovingVector(){
        return this.movingVector;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print("Pressed: ");
        System.out.println(e.getKeyChar());
        switch (e.getKeyChar()){
            case 'w': this.movingVector[1] = -1;break;
            case 'a': this.movingVector[0] = -1;break;
            case 'd': this.movingVector[0] = 1;break;
            case 's': this.movingVector[1] = 1;break;
            case 'i': this.currHurdles += 1;break;
            case 'k': this.currHurdles -= 1;break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.print("Released: ");
        System.out.println(e.getKeyChar());
        switch (e.getKeyChar()){
            case 'w': this.movingVector[1] = 0;break;
            case 'a': this.movingVector[0] = 0;break;
            case 'd': this.movingVector[0] = 0;break;
            case 's': this.movingVector[1] = 0;break;
        }
    }

}
