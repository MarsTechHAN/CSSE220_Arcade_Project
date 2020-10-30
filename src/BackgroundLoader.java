import java.awt.*;
import java.util.ArrayList;

public class BackgroundLoader {
    Color floorColor;
    Color stepColor;
    float[] stepPositionsX;
    float[] stepPositionsY;
    float[] stepLength;

    BackgroundLoader(){
        loadLevel1();
    }

    void loadLevel1(){
        this.floorColor = Color.YELLOW;
        this.stepColor = Color.GREEN;
        this.stepPositionsX = new float[]{62, 260, 440};
        this.stepPositionsY = new float[]{160, 338, 177};
        this.stepLength = new float[]{120, 170, 130};
    }
}
