import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

//radio method that handles everything specified by instructor
public class Radio {
	
	private ArrayList<RadList> heyListen;
	
	protected int radial;
	protected String stationID;
	protected boolean overStation;
	
	public Radio() {
		this(false);
	}

	public Radio(boolean timed) {
		heyListen = new ArrayList<>();
		reset();
		if (timed) {
			new Timer().scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					if (Functions.randomInt(0, 3) == 0) {
						radial = Functions.normalizeAngle(radial + Functions.randomInt(-2, 2));
					}
					overStation();
					
					notifyListeners();
				}
			}, 0, 1000);
		}
	}
	
	public void addListener(RadList listener) {
        heyListen.add(listener);
    }
	
	public void reset() {
		radial();
		overStation();
		
		notifyListeners();
	}
	
	private void notifyListeners() {
		for (RadList listener : heyListen) {
        	listener.incomingData();
        }
	}
	
	private void radial() {
		this.radial = Functions.randomInt(0, 359);
	}
	
	private void overStation() {
		this.overStation = (Functions.randomInt(0, 19) == 0);
	}
	
	public int getRadial() {
		return radial;
	}
	
	public boolean isOverStation() {
		return overStation;
	}
}
