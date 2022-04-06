package compulsoryAndHomework;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class is used to take a screenshot of the frame
 */

public class SayCheese {
    static final String HELP =
            "Type Ctrl-0 to get a screenshot of the current GUI.\n" +
                    "The screenshot will be saved to the current " +
                    "directory as 'screenshot.png'.";

    public static BufferedImage getScreenShot(
            Component component) {

        BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        // call the Component's paint method, using
        // the Graphics object of the image.
        component.paint(image.getGraphics()); // alternately use .printAll(..)
        return image;
    }
}
