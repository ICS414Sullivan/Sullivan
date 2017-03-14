import java.awt.Color;

public class Main {

	public static void main(String[] args){
		EZ.initialize(800, 600);
		EZImage plane = EZ.addImage("plane.png", 300, 300);
		EZCircle station = EZ.addCircle(400, 300, 50, 50, Color.black, false);
		while(true){
			int clickX = EZInteraction.getXMouse();
			int clickY = EZInteraction.getYMouse();	
			if(EZInteraction.wasMouseLeftButtonPressed()){
				plane.translateTo(clickX, clickY);
			}
			EZ.refreshScreen();
		}
	}
}
