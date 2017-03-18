import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args){
		EZ.initialize(800, 600);
		EZ.addImage("tofrom.png", 340, 292);
		EZImage angles = EZ.addImage("angles.png", 400, 300);
		angles.scaleTo(.5);
		EZImage radial = EZ.addImage("radial.png", 680, 500);
		//radial.scaleTo(.45);
		EZImage plane = EZ.addImage("plane_transparent.png", 300, 300);
		EZCircle station = EZ.addCircle(400, 300, 50, 50, Color.black, false);
		EZCircle dot = EZ.addCircle(400, 300, 7, 7, Color.black, true);
		int clickX = EZInteraction.getXMouse();
		int clickY = EZInteraction.getYMouse();	
		EZText display = EZ.addText(415, 310, "", Color.RED);
		EZText good = EZ.addText(20, 20, "", Color.BLACK);
		EZLine line = EZ.addLine(400, 300, 300, 300, Color.RED);
		//EZLine lattitude = EZ.addLine(400, 0, 400, 800, Color.WHITE);
		//EZLine longitude = EZ.addLine(800, 300, 0, 300, Color.GRAY);
		EZText follow = EZ.addText(clickX-5, clickY-5, "", Color.RED);
		EZRectangle toFr = EZ.addRectangle(400, 0, 800, 600, Color.GRAY, false);
		EZRectangle voRadial = EZ.addRectangle(0, 0, 800, 1200, Color.WHITE, false);
		EZRectangle hideGS = EZ.addRectangle(662, 482, 30, 26, Color.BLACK, true);
		EZRectangle hideNAV = EZ.addRectangle(684, 556, 40, 20, Color.BLACK, true);
		EZCircle detectOBS = EZ.addCircle(592, 577, 33, 33, Color.WHITE, false);
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int scanned = 0;
		
		while(true){
			if(EZInteraction.isMouseLeftButtonDown()){
				clickX = EZInteraction.getXMouse();
				clickY = EZInteraction.getYMouse();	
				//System.out.println(clickX+"~~~~~X");
				//System.out.println(clickY);
			}
			boolean signal = goodBadSignal(clickX, clickY);
			if (signal == true)
				{
					hideGS.hide();
					display.show();
				//	good.color = Color.BLACK;
				//	good.msg = "GOOD!";
				} else {
					hideGS.show();
				//	good.color = Color.red;
				//	good.msg = "BAD!";
					display.hide();
				}
			if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isMouseLeftButtonDown()){
				//display.hide();
				if(detectOBS.isPointInElement(clickX, clickY)){
					System.out.println("Please enter an angle to change the OBS by");
					try {
					scanned = scanner.nextInt();
					}
					 catch (InputMismatchException e)
			            {
			                System.out.println("Invalid input, please input an integer greater than 0");
			                String trash = scanner.nextLine();
			            }
					}
				if(dot.isPointInElement(clickX, clickY) == true){
					hideNAV.hide();
				} else {
					hideNAV.show();
				}
				plane.translateTo(clickX, clickY);
				line.setPoint2(clickX, clickY);
				double angle = Math.floor(calculateAngle(clickX, clickY));
				String displayangle = String.valueOf(angle);
				display.msg = displayangle;
				//display.xCenter = clickX;
				//display.yCenter = clickY;
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

/*	static boolean overStation(int x, int y){
		if(dot.isPointInElement) {
			return true;
		} else {
			return false;
		}
	} */
	
	static void calculateOBS(){
		System.out.println();
	}
	
	//static int toFrom(){
}
