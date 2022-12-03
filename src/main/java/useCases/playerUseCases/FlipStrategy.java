package useCases.playerUseCases;

import entities.character.Character;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class FlipStrategy {
    /**
     * For simple animation purposes. Not sure if we should stick to this animation strategy, so I will put it in
     * its own strategy class.
     *
     * Flips the character image in the view model if and only if the character is facing right (left by default).
     * @param character - Determines which direction the character is facing
     * @param characterImage - the image to flip
     * @return
     */
    public static BufferedImage getAnimationFrame(Character character, BufferedImage characterImage){
        if (character.isFacing_right()){
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-characterImage.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            BufferedImage flipped = op.filter((BufferedImage) characterImage, null);
            return flipped;
        }
        else {
            return characterImage;
        }
    }
}
