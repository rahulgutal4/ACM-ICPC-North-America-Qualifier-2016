package practiceQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Robotopia {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder output = new StringBuilder();
		
		while (test-- > 0) {

			String[] tokens = br.readLine().split(" ");

			int l1 = Integer.parseInt(tokens[0]);
			int a1 = Integer.parseInt(tokens[1]);
			int l2 = Integer.parseInt(tokens[2]);
			int a2 = Integer.parseInt(tokens[3]);
			int lt = Integer.parseInt(tokens[4]);
			int at = Integer.parseInt(tokens[5]);

			int x = 1;
			int y = 0;
			boolean found = false;
			int fx = 0, fy = 0;
			while ((lt - l1 * x) > 0) {

				if ((lt - l1 * x) % l2 == 0) {
				
					y = (lt - l1 * x) / l2;

					if ((a1 * x + a2 * y) == at) {
						if (!found){
							found = true;
							fx = x;
							fy = y;
						}	
						else {
							found = false;
							break;
						}

					}
					
				}

				x++;
			}

			if (found)
				output.append(fx + " " + fy + "\n");
			else
				output.append("?\n");

		}
		
		System.out.println(output);
	}

}
