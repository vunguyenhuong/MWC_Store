package utilities;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class ImageUltil {

    public static Image resize(Image orignalImage, int width, int height) {
        Image result = orignalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return result;
    }
    
    public static ImageIcon resizeIcon(ImageIcon icon,int width,int height){
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}
