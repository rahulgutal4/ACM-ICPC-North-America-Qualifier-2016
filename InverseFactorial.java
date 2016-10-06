package practiceQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InverseFactorial {

	public static void main(String[] args) throws Exception {
		
		double[] logVal = new double[1000000];
		logVal[0] = 0.0;
		for(int i=1;i<1000000;i++){
			logVal[i] = logVal[i-1] + Math.log10(i);
		}
		
		int[] digits = new int[1000000];
		for(int i=0;i<1000000;i++){
			digits[i] = (int) (Math.floor(logVal[i]) + 1);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		
		if(len == 1){
			int val = Integer.parseInt(s);
			if(val == 1){
				System.out.println("1");
			}else if(val == 2){
				System.out.println("2");
			}else{
				System.out.println("3");
			}
		}else if(len == 3){
			int val = Integer.parseInt(s);
			if(val == 120){
				System.out.println("5");
			}else{
				System.out.println("6");
			}
		}else{
			
			for(int i=0;i<1000000;i++){
				if(digits[i] == len){
					System.out.println(i);
					break;
				}
			}
			
		}
		
	}

}
