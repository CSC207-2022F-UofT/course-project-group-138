package useCases;

import java.util.Timer;

public class AnimationStrategy {
    static int curr;
    static int numFrames;
    static int startFrame;
    static long lastTime;
    public AnimationStrategy(int startFrames, int totalFrames){
        startFrame = startFrames;
        curr = startFrame;
        numFrames = totalFrames;
        lastTime = System.currentTimeMillis();


    }
    public int getNextFrame(){
        if (System.currentTimeMillis() - lastTime < 200){
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
    public int getNextFrameHalf(){
        if (System.currentTimeMillis() - lastTime < 400){
            return curr;
        }
        if (curr < startFrame + numFrames / 2 - 1){
            curr++;
        }
        else {
            curr = startFrame;
        }
        lastTime = System.currentTimeMillis();
        return curr;
    }
}
