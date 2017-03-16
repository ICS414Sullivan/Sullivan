/*
 * VOR program for Assignment 2
 */

package vor;

public class VOR {
	private Radio radio;
	
	private int desired;

	public VOR() {
		//To be implemented in future assignments
	}
	
	public VOR(Radio radio) {
      //To be implemented in future assignments
	}
	
	/**
	 * return OBI (desired radial on display)
	 */
	public int getOBS() {
		return desired;
	}
	
	/**
	 * return CDI (needle angle)
	 */
	public int getCDI() {
		int interceptS = radio.getRadial();
		int arc = Utils.arc(desired, interceptS);
		if (arc > 90) {
			arc = 180 - arc;
		} else if (arc < -90) {
			arc = -180 - arc;
		}
		return Utils.clamp(arc, -10, 10);
	}
	
	/**
	 * Identify if signal is abeam or over station.
	 * If not, return true and the signal is deteremined to be good.
	 */
	public boolean isSignalGood() {
		int intercepted = radio.getRadial();
		int arc = Utils.arc(desired, intercepted);
		return (Math.abs(Math.abs(arc) - 90) > 1) && !radio.isOverStation();
	}
	
	/**
    * From: our radial is within 90 degrees of the intercepted signal
	 * To: if we do not satisfy the aforementioned paramters
	 * return true if we are heading towards the station
	 */
	public boolean isGoingTo() {
		int intercepted = radio.getRadial();
		return Math.abs(Utils.arc(desired, intercepted)) > 90;
	}
	
	public String getStationID() {
		return radio.getStationID();
	}
   
	/**
	 * Normalizes our current readings between the angles of +180 and -180
	 */
	public static int normalizeAngle(int angle, int center) {
		return angle - 360 * (int)Math.floor((angle + 180 - center) / 360.0);
	}
	
	/**
	 * Normalizes current angle to the interval 0 and 360.
	 */
	public static int normalizeAngle(int angle) {
		return normalizeAngle(angle, 180);
	}
	
	/**
	 * Clamps code between two given values, low and high.
	 */
	public static int clamp(int val, int low, int high) {
		return Math.max(low, Math.min(high, val));
	}
	
   /**
    * return the amount between current x and y values
    */
	public static int arc(int x, int y) {
		return normalizeAngle(y - x, 0);
	}
	
	/**
	 * Returns a random integer
	 */
	public static int randomInt(int min, int max) {
		return min + (int)(Math.random() * (max - min + 1));
	}   
}
