//This is a part of  the simulation task to find the probablity of each repo as a past of markov chain between all the events in the a repo/tag/branch.


package markov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class distribution {

	public static void main(String[] args) {
		try {
			int[][] counts = new int[200][2];
			

			// build the event , index map as we want them
			
			// File file = new File("/Synchronicity/SyncIO/results.txt");
			File file = new File(distribution.class.getResource("testerSequence.txt").getFile());

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(file));
			//calling time lag function
			
			int counter=0;
			String st;
			while ((st = br.readLine()) != null && counter < 200) {
				String[] sequence = st.split(",");

				counts[counter][0] = Integer.parseInt(sequence[0]);
				counts[counter][1] = Integer.parseInt(sequence[1]);
				counter++;

			
			}
			float count=0;
			for (int i = 0; i < 200; i++) {

				// Print probability for column j.
				//for (int j = 0; j < 5; j++) {
					
						count	=count + counts[i][1];
				
				float p =0;
					for (int j = 0; j < 200; j++) {
					 p = p+counts[i][1]/count;
						System.out.println(counts[i][0],p);
						System.out.println();
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
