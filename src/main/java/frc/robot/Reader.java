package frc.robot;

import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
	//
	// VARIABLES
	//

	static double time;
	static String[][] recording = new String [Constants.MAX_INDEX][Constants.RECORDED_VALUES_AMOUNT];
	static double[][] recordingDoubles = new double[Constants.MAX_INDEX][Constants.RECORDED_VALUES_AMOUNT];
	static int snapshotNum = 0;
	static double startTime;
	static int index = 0;

	// NOTE: recording is of Strings, read directly from the file
	// recordingDoubles is that translated to doubles for sending as inputs
	
	//
	// METHODS
	// 

	// reads whole file and saves to recording array
	public static void read (String autonmode) {
		BufferedReader buffer;
		String line;
		
		try {
			buffer = new BufferedReader(new FileReader(autonmode));
			while ((line = buffer.readLine()) != null) {
				String[] snapshot = line.split(" ");
				recording[index] = snapshot;
				System.out.println(snapshot.length);
				index++;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	// sets start time
	public static void initTime() {
		startTime = System.nanoTime();
	}
	
	// sends values to ghostDrive in real time
	public static void play() {
		try {
			initTime();
			time = System.nanoTime() - startTime;
			System.out.println(recording.length);
			System.out.println(recording[snapshotNum][Constants.TIME_INDEX]);
			
			// Reads line for inputs
            for (int i = 0; i < Constants.RECORDED_VALUES_AMOUNT; i++) {
                recordingDoubles[snapshotNum][i] = Double.parseDouble(recording[snapshotNum][i]);
			}
			
			// Waits until it is time to act on inputs
			do {
				time = System.nanoTime() - startTime;
			} while (time < recordingDoubles[snapshotNum][Constants.TIME_INDEX]);

			Robot.ghostDrive(recordingDoubles[snapshotNum]);
            snapshotNum++;
            
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}
	
	// tests if still playing
	public static boolean playing() {
		return snapshotNum < Constants.MAX_INDEX;
	}

	//
	// MAIN (idk do we need this?)
	//

	public static void main(String Args[]) {
		///TODO: Make sure that this is the right filename for the robot when the time comes
        read("/Documents/ghostMode.txt");
            while (playing()) {
                play();
			}
			
	}

}