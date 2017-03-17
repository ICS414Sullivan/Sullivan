import java.awt.Color;

public class Main {

	public static void main(String[] args){
		EZ.initialize(800, 600);
		EZ.addImage("tofrom.png", 400, 292);
		EZImage angles = EZ.addImage("angles.png", 400, 300);
		EZImage plane = EZ.addImage("plane_transparent.png", 300, 300);
		EZCircle station = EZ.addCircle(400, 300, 50, 50, Color.black, false);
		EZCircle dot = EZ.addCircle(400, 300, 7, 7, Color.black, true);
		int clickX = EZInteraction.getXMouse();
		int clickY = EZInteraction.getYMouse();	
		EZText display = EZ.addText(400, 310, "", Color.RED);
		EZText good = EZ.addText(20, 20, "", Color.BLACK);
		EZLine line = EZ.addLine(400, 300, 300, 300, Color.RED);
		EZLine lattitude = EZ.addLine(400, 600, 400, 800, Color.WHITE);
		//EZLine longitude = EZ.addLine(800, 300, x2, y2, c);
		
		while(true){
			if(EZInteraction.isMouseLeftButtonDown()){
				clickX = EZInteraction.getXMouse();
				clickY = EZInteraction.getYMouse();	
			}
			boolean signal = goodBadSignal(clickX, clickY);
			if (signal == true)
				{
					display.show();
					good.color = Color.BLACK;
					good.msg = "GOOD!";
				} else {
					good.color = Color.red;
					good.msg = "BAD!";
					display.hide();
				}
			if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isMouseLeftButtonDown()){
				//display.hide();
				plane.translateTo(clickX, clickY);
				line.setPoint2(clickX, clickY);
				double angle = Math.floor(calculateAngle(clickX, clickY));
				String displayangle = String.valueOf(angle);
				display.msg = displayangle;
			}
			EZ.refreshScreen();
		}
	}
	
	static double calculateAngle(int x, int y){
		double cos = x-400;
		double sin = 300-y;
		double angle = (Math.atan2(cos,sin)*360/3.14159265)/2;
		if(angle < 0){
			return 360+angle;
		} else {
			return angle;
		}
	}
	
	static boolean goodBadSignal(int x, int y){
		if(x > 750 || y > 550){
			return false;
		} else {
			return true;
		}
	}
}
