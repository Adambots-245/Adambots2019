package frc.robot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Recorder {
    //
    // VARIABLES
    // 

    private static long startTime = System.nanoTime();
	private static double indexArray [][] = new double[Constants.MAX_INDEX][Constants.RECORDED_VALUES_AMOUNT];
    private static int index;
	private static boolean writing = false;
    private static boolean recording = true;
    private static String name;
    private static Scanner in = new Scanner(System.in);
    
    //
    // METHODS
    //

    // turns booleans into doubles (I swear its useful)
	private static double boolToDouble(boolean condition) {
        if (condition) return 1.0;
        return 0.0;
	}
    
    // records movements to indexArray
	public static void recording() {
		if (index <= 0) {
			index = 0;
			startTime = System.nanoTime();
        }
        
        // sets the last input to all zero to stop everything and then stops recording, starts writing
		if (index >= Constants.MAX_INDEX - 1) {
            double timeStamp = (double)(System.nanoTime() - startTime);
            double[] myDoubleArray = {timeStamp, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            indexArray[Constants.MAX_INDEX] = myDoubleArray;

			writing = true;
			recording = false;
        }
        
        // if actually recording, records actual values
		if (recording) {
            // p: primary
            // s: secondary
            
            // lx/ly: left joy x/y
            // rx/ry: right joy x/y
            // lt/rt: left/right trigger
            // ls/rs: left/right stick button 
            // ba/bb/bx/by: a/b/x/y button
            // st/bk: start/back button
            // lb/rb: left/right shoulder button
            // dn/de/ds/dw: d-pad north/east/south/west
            
            // none of these variables are really useful but they make the array look (slightly) less bad
            double plx = Gamepad.primary.getLeftX().get();
            double ply = Gamepad.primary.getLeftY().get();
            double prx = Gamepad.primary.getRightX().get();
            double pry = Gamepad.primary.getRightY().get();
            double plt = Gamepad.primary.getLeftTrigger().get();
            double prt = Gamepad.primary.getRightTrigger().get();
            double pba = boolToDouble(Gamepad.primary.getA().get());
            double pbb = boolToDouble(Gamepad.primary.getB().get());
            double pbx = boolToDouble(Gamepad.primary.getX().get());
            double pby = boolToDouble(Gamepad.primary.getY().get());
            double pst = boolToDouble(Gamepad.primary.getStart().get());
            double pbk = boolToDouble(Gamepad.primary.getBack().get());
            double plb = boolToDouble(Gamepad.primary.getLB().get());
            double prb = boolToDouble(Gamepad.primary.getRB().get());
            double pdn = boolToDouble(Gamepad.primary.getDPadN().get());
            double pdne = boolToDouble(Gamepad.primary.getDPadNE().get());
            double pde = boolToDouble(Gamepad.primary.getDPadE().get());
            double pdse = boolToDouble(Gamepad.primary.getDPadSE().get());
            double pds = boolToDouble(Gamepad.primary.getDPadS().get());
            double pdsw = boolToDouble(Gamepad.primary.getDPadSW().get());
            double pdw = boolToDouble(Gamepad.primary.getDPadW().get());
            double pdnw = boolToDouble(Gamepad.primary.getDPadNW().get());
           
            double slx = Gamepad.secondary.getLeftX().get();
            double sly = Gamepad.secondary.getLeftY().get();
            double srx = Gamepad.secondary.getRightX().get();
            double sry = Gamepad.secondary.getRightY().get();
            double slt = Gamepad.secondary.getLeftTrigger().get();
            double srt = Gamepad.secondary.getRightTrigger().get();
            double sba = boolToDouble(Gamepad.secondary.getA().get());
            double sbb = boolToDouble(Gamepad.secondary.getB().get());
            double sbx = boolToDouble(Gamepad.secondary.getX().get());
            double sby = boolToDouble(Gamepad.secondary.getY().get());
            double sst = boolToDouble(Gamepad.secondary.getStart().get());
            double sbk = boolToDouble(Gamepad.secondary.getBack().get());
            double slb = boolToDouble(Gamepad.secondary.getLB().get());
            double srb = boolToDouble(Gamepad.secondary.getRB().get());
            double sdn = boolToDouble(Gamepad.secondary.getDPadN().get());
            double sdne = boolToDouble(Gamepad.secondary.getDPadNE().get());
            double sde = boolToDouble(Gamepad.secondary.getDPadE().get());
            double sdse = boolToDouble(Gamepad.secondary.getDPadSE().get());
            double sds = boolToDouble(Gamepad.secondary.getDPadS().get());
            double sdsw = boolToDouble(Gamepad.secondary.getDPadSW().get());
            double sdw = boolToDouble(Gamepad.secondary.getDPadW().get());
            double sdnw = boolToDouble(Gamepad.secondary.getDPadNW().get());

            double timeStamp = (double)(System.nanoTime() - startTime);
            double [] myDoubleArray = {timeStamp, plx, ply, prx, pry, plt, prt, pba, pbb, pbx, pby, pst, pbk, plb, prb, pdn, pdne, pde, pdse, pds, pdsw, pdw, pdnw,
                slx, sly, srx, sry, slt, srt, sba, sbb, sbx, sby, sst, sbk, slb, srb, sdn, sdne, sde, sdse, sds, sdsw, sdw, sdnw};
            indexArray[index] = myDoubleArray;

            index++;

        }
        
	}
    
    // writes array to file
	public static void writing() {
		System.out.println("Starting to write");
			try {
                PrintWriter writer = new PrintWriter("/Documents/" + name, "UTF-8");
                for (index = 0; index < Constants.MAX_INDEX; index++) {
                    writer.print(index);
                    for (int i = 0; i < Constants.RECORDED_VALUES_AMOUNT; i++) {
                        writer.print(" ");
                        writer.print(indexArray[index][i]);
                    }
                }

                writer.close();
                writing = false;
                    
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
			
		}
    
    // inits the recorder (what did you want it to do?)
	public static void initRecorder() {
		startTime = System.nanoTime();
		index = 0;
        indexArray = new double[Constants.MAX_INDEX][Constants.RECORDED_VALUES_AMOUNT];
    }
    
    public static void setName() {
        System.out.print("Name: ");
        name = in.nextLine() + ".txt";
        System.out.println("Saving to " + name);
    }

    // waits until the controller sends an input so that there aren't wasted frames at the beginnning
    public static void waitForStart() {
        System.out.println("Press the start button on the primary controller to start");
        while (!Gamepad.virtualPrimary.getStart().get()) {
            // do nothing
        }
    }

    //
    // MAIN
    //

	public static void main(String Args[]) throws InterruptedException{
        initRecorder();
        setName();
        waitForStart();
		while (!writing) {
            recording(); 
            while ((System.nanoTime() - startTime) < Constants.RECORDER_SLEEP_TIME * index) {
                // do nothing; wait
            }
		}
        writing();
	}

}
