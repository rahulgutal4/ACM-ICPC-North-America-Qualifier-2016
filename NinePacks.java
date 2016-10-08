package practiceQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NinePacks {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		int H = Integer.parseInt(tokens[0]);
		int[] h = new int[tokens.length+1];
		for (int i = 1; i < tokens.length; i++) {
			h[i] = Integer.parseInt(tokens[i]);
		}

		tokens = br.readLine().split(" ");
		int B = Integer.parseInt(tokens[0]);
		int[] b = new int[tokens.length+1];
		for (int i = 1; i < tokens.length; i++) {
			b[i] = Integer.parseInt(tokens[i]);
		}

		int[][] ks = new int[H + 1][100005];
		
		for (int i = 0; i < 100005; i++) {
			ks[0][i] = H+1;
		}
		
		for (int i = 0; i <= H; i++) {
			ks[i][0] = 0;
		}

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < 100005; j++) {
				if (j >= h[i]) {
					ks[i][j] = Math.min(ks[i-1][j - h[i]] + 1, ks[i - 1][j]);
				} else {
					ks[i][j] = ks[i - 1][j];
			 	}
			}
		}
		
		int[] minH = new int[100005];
		for(int i=1;i<100005;i++){
			int minVal = H+1;
			for(int j=1;j<=H;j++){
				minVal = Math.min(minVal, ks[j][i]);
			}
			minH[i] = minVal;
		}

		int[][] ks1 = new int[B + 1][100005];
		
		for (int i = 0; i < 100005; i++) {
			ks1[0][i] = B+1;
		}
		
		for (int i = 0; i <= B; i++) {
			ks1[i][0] = 0;
		}

		for (int i = 1; i <= B; i++) {
			for (int j = 1; j < 100005; j++) {
				if (j >= b[i]) {
					ks1[i][j] = Math.min(ks1[i-1][j - b[i]] + 1, ks1[i - 1][j]);
				} else {
					ks1[i][j] = ks1[i - 1][j];
			 	}
			}
		}
		
		int[] minB = new int[100005];
		for(int i=1;i<100005;i++){
			int minVal = B+1;
			for(int j=1;j<=B;j++){
				minVal = Math.min(minVal, ks1[j][i]);
			}
			minB[i] = minVal;
		}

		int ans = H+B+1;
		for(int i=1;i<100005;i++){
			if(minH[i] != (H+1) && minB[i] != (B+1)){
				ans = Math.min(ans, minH[i] + minB[i]);
			}
		}
		
		if(ans != (H+B+1))
			System.out.println(ans);
		else
			System.out.println("impossible");
		
	}

}
