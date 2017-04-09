import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Resources {
	private static HashMap<String, BufferedImage> images = new HashMap<>();

	//Method taken from ICS 432 with Professor Casanova.  This reads in images from the directory of the project.
        public static boolean loadImage(String key) {
		try {
			BufferedImage img = ImageIO.read(Resources.class.getResource(key + ".png"));
			images.put(key, img);
			return true;
		} catch (IOException | IllegalArgumentException ex) {
			return false;
		}
	}
	
	//receive string array as input and attempt to load each image specified
        public static boolean[] loadImages(String[] keys) {
		boolean[] success = new boolean[keys.length];
		for (int i = 0; i < keys.length; i++) {
			success[i] = loadImage(keys[i]);
		}
		return success;
	}

	//map image to key.  return key
        public static BufferedImage image(String key) {
		if (!images.containsKey(key)) {
			return null;
		}
		return images.get(key);
	}
}
