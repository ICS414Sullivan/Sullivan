import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Main {

	static int toFromY = 270;
	static int toFromX = 90;
	static double angle = 0;
	static int scanned = 0;
	static int radialX = 0;
	static int radialY = 180;
	
	public static void main(String[] args){
		EZ.initialize(800, 600);
		EZImage background = EZ.addImage("tofrom.png", 340, 292);
		EZImage angles = EZ.addImage("angles.png", 400, 300);
		angles.scaleTo(.5);
		//EZImage radial = EZ.addImage("radial.png", 680, 500);
		//EZImage toTri = EZ.addImage("tofrotri.png", 725, 484);
		//EZImage froTri = EZ.addImage("tofrotri.png", 725, 513);
		//froTri.rotateBy(180);
		//radial.scaleTo(.45);
		EZImage plane = EZ.addImage("plane_transparent.png", 300, 300);
		EZCircle station = EZ.addCircle(400, 300, 50, 50, Color.black, false);
		EZCircle dot = EZ.addCircle(400, 300, 7, 7, Color.black, true);
		int clickX = EZInteraction.getXMouse();
		int clickY = EZInteraction.getYMouse();	
		EZText display = EZ.addText(415, 310, "", Color.RED);
		EZText good = EZ.addText(20, 20, "", Color.BLACK);
		EZLine line = EZ.addLine(400, 300, 300, 300, Color.RED);
		EZLine lattitude = EZ.addLine(800, 300, 0, 300, Color.WHITE);
		lattitude.rotateBy(90);
		EZLine longitude = EZ.addLine(800, 300, 0, 300, Color.GRAY);
		EZText follow = EZ.addText(clickX-5, clickY-5, "", Color.RED);
		//EZRectangle toFr = EZ.addRectangle(400, 450, 800, 300, Color.GRAY, false);
		//EZRectangle voRadial = EZ.addRectangle(0, 0, 500, 1200, Color.WHITE, false);
		EZImage radial = EZ.addImage("radial.png", 680, 500);
		EZLine radialLine = EZ.addLine(685, 448, 685, 543, Color.RED);
		EZRectangle hideGS = EZ.addRectangle(662, 482, 30, 26, Color.BLACK, true);
		EZImage toTri = EZ.addImage("tofrotri.png", 725, 484);
		EZImage froTri = EZ.addImage("tofrotri.png", 725, 513);
		froTri.rotateBy(180);
		EZRectangle hideNAV = EZ.addRectangle(684, 556, 40, 20, Color.BLACK, true);
		EZCircle detectOBS = EZ.addCircle(592, 577, 33, 33, Color.WHITE, false);
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
		while(true){
			if(EZInteraction.isMouseLeftButtonDown()){
				clickX = EZInteraction.getXMouse();
				clickY = EZInteraction.getYMouse();	
				System.out.println(clickX+"~~~~~X");
				System.out.println(clickY);
			}
			boolean signal = goodBadSignal(clickX, clickY);
			if (signal == true)
				{
					hideGS.hide();
					display.show();
				} else {
					hideGS.show();
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
					//System.out.println(scanned+"~~~~~");
					lattitude.rotateBy(scanned);
					longitude.rotateBy(scanned);
					//background.rotateBy(scanned);
					toFromY += scanned;
					toFromX += scanned;
					toFromX = toFromX%360;
					toFromY = toFromY%360;
				  }
				plane.translateTo(clickX, clickY);
				line.setPoint2(clickX, clickY);
				double angle = Math.floor(calculateAngle(clickX, clickY));
				String displayangle = String.valueOf(angle);
				display.msg = displayangle;
				if(angle > toFromY || angle < toFromX){
					//System.out.println(toFromY+"~~Y");
					//System.out.println(toFromX+"~~X");
					toTri.show();
					froTri.hide();
				} else if(angle < toFromY || angle > toFromX) {
					froTri.show();
					toTri.hide();
				}
				if(dot.isPointInElement(clickX, clickY) == true){
					toTri.hide();
					froTri.hide();
					hideNAV.hide();
				} else {
					hideNAV.show();
				}
				if(angle-radialX == 0){
					radialLine.setPoint2(685, 543);
				}
				if(angle-radialX == 1 ){
					radialLine.setPoint2(692, 539);
				}
				if(angle-radialX == 2 ){
					radialLine.setPoint2(705,531);
				}
				if(angle-radialX == 3){
					radialLine.setPoint2(714,536);
				}
				if(angle-radialX == 4){
					radialLine.setPoint2(720,529);
				}
				if(angle-radialX == 5 ){
					radialLine.setPoint2(724,530);
				}
				if(angle-radialX == 6 ){
					radialLine.setPoint2(728,526);
				}
				if(angle-radialX == 7 ){
					radialLine.setPoint2(732,522);
				}
				if(angle-radialX == 8 ){
					radialLine.setPoint2(736,518);
				}
				if(angle-radialX == 9 ){
					radialLine.setPoint2(740,514);
				}
				if(angle-radialX >= 10 ){
					radialLine.setPoint2(744,510);
				}
				if(angle-radialY == 0){
					radialLine.setPoint2(685, 543);
				}
				if(angle-radialY == -1 ){
					radialLine.setPoint2(692, 539);
				}
				if(angle-radialY == -2 ){
					radialLine.setPoint2(705,531);
				}
				if(angle-radialY == -3){
					radialLine.setPoint2(714,536);
				}
				if(angle-radialY == -4){
					radialLine.setPoint2(720,529);
				}
				if(angle-radialY == -5 ){
					radialLine.setPoint2(724,530);
				}
				if(angle-radialY == -6 ){
					radialLine.setPoint2(728,526);
				}
				if(angle-radialY == -7 ){
					radialLine.setPoint2(732,522);
				}
				if(angle-radialY == -8 ){
					radialLine.setPoint2(736,518);
				}
				if(angle-radialY == -9 ){
					radialLine.setPoint2(740,514);
				}
				
			}
			EZ.refreshScreen();
	}
}
	
	static double calculateAngle(int x, int y){
		double cos = x-400;
		double sin = 300-y;
		angle = (Math.atan2(cos,sin)*360/3.14159265)/2;
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
	
	static int toFrom(int planeangle){
		if(planeangle > toFromY){
			return 2;
		}
		return 5;
	}
}
