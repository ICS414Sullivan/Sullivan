public class Functions {
	
	//keep angle between -180 and +180
	public static int normalizeAngle(int angle, int center) {
		return angle - 360 * (int)Math.floor((angle + 180 - center) / 360.0);
	}
	
	//keep angle between 0, inclusive, and 360
	public static int normalizeAngle(int angle) {
		return normalizeAngle(angle, 180);
	}
	
	//constrict value parameter between low and high
	public static int clamp(int val, int low, int high) {
		return Math.max(low, Math.min(high, val));
	}

	public static int arc(int x, int y) {
		return normalizeAngle(y - x, 0);
	}
	
	public static int randomInt(int min, int max) {
		return min + (int)(Math.random() * (max - min + 1));
	}
}
