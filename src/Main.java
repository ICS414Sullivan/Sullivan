import java.awt.Color;

public class Main {

	public static void main(String[] args){
		EZ.initialize(800, 600);
		EZ.addImage("tofrom.png", 400, 292);
		EZImage plane = EZ.addImage("plane.png", 300, 300);
		EZCircle station = EZ.addCircle(400, 300, 50, 50, Color.black, false);
		EZCircle dot = EZ.addCircle(400, 300, 7, 7, Color.black, true);
		int clickX = EZInteraction.getXMouse();
		int clickY = EZInteraction.getYMouse();	
		EZLine line = EZ.addLine(400, 300, 300, 300, Color.RED);
		while(true){
			clickX = EZInteraction.getXMouse();
			clickY = EZInteraction.getYMouse();	
			if(EZInteraction.wasMouseLeftButtonPressed()){
				plane.translateTo(clickX, clickY);
				line.setPoint2(clickX, clickY);
				calculateAngle(clickX, clickY);
			}
			EZ.refreshScreen();
		}
	}
	
	static void calculateAngle(int x, int y){
		double cos = x-400;
		double sin = 300-y;
		double angle = sin/cos;
		Math.atan(angle);
		System.out.println(angle);
		
	}
}
