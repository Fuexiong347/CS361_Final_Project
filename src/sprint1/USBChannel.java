package sprint1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.google.gson.Gson;

public class USBChannel extends channel{
	
	public USBChannel(chronotimer timer, int channelNumber, sensor s){
		super(timer, channelNumber, null);
	}
	
	public void writeToUSB(Run r, int runNumber){
		Gson g = new Gson();

		
		String out = g.toJson(r.getRun());
//		System.out.println(out);
		
//		ArrayList<pairs> list = (g.fromJson(out, new TypeToken<Collection<pairs>>(){}.getType()));
//		for(pairs str : list){
//			System.out.println(str.getCompetitor(0).toString());
//			System.out.println(str.getCompetitor(1).toString());
//
//		}
//		File file = new File("f.txt");
//		try {
//			FileWriter writer = new FileWriter(file);
//			writer.write(out);
//			writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
try (PrintWriter writer = new PrintWriter("RUN " + runNumber + ".txt")) {
        	

        		writer.println(out);

            
            }
         catch (FileNotFoundException e) {
            throw new RuntimeException("Problem writing file.");
        }

		
	}
	
}
