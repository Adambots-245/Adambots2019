package frc.robot;

import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
	static double time;
	static String[][] recording = new String [Constants.MAX_INDEX][Constants.RECORDED_VALUES_AMOUNT];
	static int snapshotNum = 0;
	static double startTime;
	static int index = 0;
	
	public static void read(String autonmode) {
		BufferedReader buffer;
		String line;
		
		try {
			buffer = new BufferedReader(new FileReader(autonmode));
			while ((line = buffer.readLine()) != null){
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
	
	public static void init() {
		startTime = System.nanoTime();
	}
	
	public static void play() {
		try {
            
            int snapshotBoundNum = Math.max(1, (Math.min(snapshotNum, index-1)));
            double[] recordingDoubles = new double[Constants.RECORDED_VALUES_AMOUNT];
			time = System.nanoTime()- startTime;
			System.out.println(recording.length);
			System.out.println(recording[snapshotNum - 1][Constants.TIME_INDEX]);
			
            for (int i = 0; i < Constants.RECORDED_VALUES_AMOUNT; i++) {
                recordingDoubles[i] = Double.parseDouble(recording[snapshotBoundNum][i]);
            }
			Drive.autonDrive(recordingDoubles);
		
            snapshotNum++;
            
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String Args[]) {
        ///TODO: Make sure that this is the right filename for the robot when the time comes
        read("/Documents/ghostMode.txt");
            while (true) {
                play();
            }
	}
}