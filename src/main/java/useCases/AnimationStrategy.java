package useCases;

import java.util.Timer;

public class AnimationStrategy {
    int curr;
    int numFrames;
    int startFrame;
    long lastTime;
    public AnimationStrategy(int startFrame, int numFrames){
        this.startFrame = startFrame;
        curr = startFrame;
        this.numFrames = numFrames;
        lastTime = System.currentTimeMillis();


    }
    public int getNextFrame(){
        if (System.currentTimeMillis() - lastTime < 150){
            return curr;
        }
        if (curr < startFrame + numFrames - 1){
            curr++;
        }
        else {
            curr = startFrame;
        }
        lastTime = System.currentTimeMillis();
        return curr;
    }
}