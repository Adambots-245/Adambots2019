package frc.robot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Recorder {

    private static long startTime = System.nanoTime();
	private static double indexArray [][] = new double[Constants.MAX_INDEX][Constants.RECORDED_VALUES_AMOUNT];
	private static int index;
	private static boolean writing = false;
	private static boolean recording = true;
	
	private static double boolToDouble(boolean condition){
        if(condition) return 1.0;
        return 0.0;
	}
	
	public static void recording(){
		if(index <= 0){
			index = 0;
			startTime = System.nanoTime();
		}
		if (index >= Constants.MAX_INDEX){
			writing = true;
			recording = false;
		}
		if (recording){
            // p: primary
            // s: secondary

            // lx/ly: left joy x/y
            // rx/ry: right joy x/y
            // lt/rt: left/right trigger
            // ba/bb/bx/by: a/b/x/y button
            // st/bk: start/back button
            // lb/rb: left/right shoulder button
            // du/dd/dl/dr: d-pad up/down/left/right
            
            double plx = Gamepad.primary.getLeftX(); 	
            double ply = Gamepad.primary.getLeftY();	
            double prx = Gamepad.primary.getRightX();
            double pry = Gamepad.primary.getRightY();
            double plt = Gamepad.primary.getLeftTrigger();
            double prt = Gamepad.primary.getRightTrigger();
            double pba = boolToDouble(Gamepad.primary.getA());
            double pbb = boolToDouble(Gamepad.primary.getB());
            double pbx = boolToDouble(Gamepad.primary.getX());
            double pby = boolToDouble(Gamepad.primary.getY());
            double pst = boolToDouble(Gamepad.primary.getStart());
            double pbk = boolToDouble(Gamepad.primary.getBack());
            double plb = boolToDouble(Gamepad.primary.getLB());
            double prb = boolToDouble(Gamepad.primary.getRB());
            double pdu = boolToDouble(Gamepad.primary.getDPadUp());
            double pdd = boolToDouble(Gamepad.primary.getDPadDown());
            double pdl = boolToDouble(Gamepad.primary.getDPadLeft());
            double pdr = boolToDouble(Gamepad.primary.getDPadRight());

            double slx = Gamepad.secondary.getLeftX(); 	
            double sly = Gamepad.secondary.getLeftY();	
            double srx = Gamepad.secondary.getRightX();
            double sry = Gamepad.secondary.getRightY();
            double slt = Gamepad.secondary.getLeftTrigger();
            double srt = Gamepad.secondary.getRightTrigger();
            double sba = boolToDouble(Gamepad.secondary.getA());
            double sbb = boolToDouble(Gamepad.secondary.getB());
            double sbx = boolToDouble(Gamepad.secondary.getX());
            double sby = boolToDouble(Gamepad.secondary.getY());
            double sst = boolToDouble(Gamepad.secondary.getStart());
            double sbk = boolToDouble(Gamepad.secondary.getBack());
            double slb = boolToDouble(Gamepad.secondary.getLB());
            double srb = boolToDouble(Gamepad.secondary.getRB());
            double sdu = boolToDouble(Gamepad.secondary.getDPadUp());
            double sdd = boolToDouble(Gamepad.secondary.getDPadDown());
            double sdl = boolToDouble(Gamepad.secondary.getDPadLeft());
            double sdr = boolToDouble(Gamepad.secondary.getDPadRight());

            double timeStamp = (double)(System.nanoTime() - startTime);
            double [] myDoubleArray = {timeStamp, plx, ply, prx, pry, plt, prt, pba, pbb, pbx, pby, pst, pbk, plb, prb, pdu, pdd, pdl, pdr, slx, sly, srx, sry, slt, srt, sba, sbb, sbx, sby, sst, sbk, slb, srb, sdu, sdd, sdl, sdr};
            indexArray[index] = myDoubleArray;
            index++;
		}
	}
	
	public static void writing(){
		if(writing){
			return;
		}
		System.out.println("Starting to write");
			try{
                PrintWriter writer = new PrintWriter("/Documents/ghostMode.txt", "UTF-8");
                    if (recording && indexArray.length >= Constants.MAX_INDEX - 1) {
                        for(index = 0; index <= Constants.MAX_INDEX - 1; index++) {
                        writer.print(index);
                            for(int i = 0; i < Constants.RECORDED_VALUES_AMOUNT; i++){
                                writer.print(" ");
                                writer.print(indexArray[index][i]);
                            }
                        }
                        Arrays.toString(indexArray);
                        writer.close();
                        writing = true;
                    }
                    
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
			
			}
	
	public static void initRecorder(){
		startTime = System.nanoTime();
		index = 0;
		indexArray = new double[Constants.MAX_INDEX][Constants.RECORDED_VALUES_AMOUNT];
	}

	public static void main(String Args[]) throws InterruptedException{
		initRecorder();
		while(!writing){
			recording();
			Thread.sleep(Constants.RECORDER_SLEEP_TIME);
		}
	
	}

}
