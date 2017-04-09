/*
 * VOR program for Assignment 2
 */
public class VOR {
	private Radio radio;
	
	private int desired;

	public VOR() {
		this(new Radio(true));
	}
	
	public VOR(Radio radio) {
		this.radio = radio;
		desired = 0;
	}
	
	public void radioListener(RadList listener) {
		radio.addListener(listener);
	}
	
	public void rotateOBS(int delta) {
		desired = Functions.normalizeAngle(desired + delta);
	}
	
	public int getOBS() {
		return desired;
	}
	
	public int getCDI() {
		int intercepted = radio.getRadial();
		int arc = Functions.arc(desired, intercepted);
		if (arc > 90) {
			arc = 180 - arc;
		} else if (arc < -90) {
			arc = -180 - arc;
		}
		return Functions.clamp(arc, -10, 10);
	}
	
	public boolean signalGood() {
		int intercepted = radio.getRadial();
		int arc = Functions.arc(desired, intercepted);
		return (Math.abs(Math.abs(arc) - 90) > 1) && !radio.isOverStation();
	}
	
	public boolean goingTo() {
		int intercepted = radio.getRadial();
		return Math.abs(Functions.arc(desired, intercepted)) > 90;
	}
}
