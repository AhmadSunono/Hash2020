import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("e_also_big.in"));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out5.txt"));

		String []firstLine = bufferedReader.readLine().split(" ");
		int maxNumberOfSlices = Integer.valueOf(firstLine[0]);
		int numberOfTypes = Integer.valueOf(firstLine[1]);
		String []tmp = bufferedReader.readLine().split(" ");
		ArrayList<Integer> typesSizes = new ArrayList<Integer>();
		
		
		for(int i = 0; i < tmp.length ; i++) {
			typesSizes.add(Integer.valueOf(tmp[i]));
		}
		
		
		ArrayList<Integer> result = Solve(maxNumberOfSlices, typesSizes);
		
		for (Integer element : result) {
			System.out.println(element);
		}
		
		
//		knapsackDP(typesSizes, typesSizes, numberOfTypes, maxNumberOfSlices,result);
//		
		
		bufferedWriter.write(String.valueOf(result.size()));
		bufferedWriter.newLine();
		for(int i = result.size()-1; i>=0 ; i--) {
			bufferedWriter.write(String.valueOf(result.get(i))+" ");
		}
		
		System.out.println("DONE!");
		
		bufferedReader.close();
		bufferedWriter.close();

		
		
	}	


	    static int MAX;
	    static ArrayList<Integer> Input, Output;
	    static int Num;
	    static int score = 0;

	    static ArrayList<Integer> Solve(int Max, ArrayList<Integer> input) {
	        ArrayList<Integer> BestSolution = new ArrayList<Integer>();
	        score = 0;
	        int j, i = input.size() - 1;
	        boolean test1 = true, test2 = true;
	        while (i >= 0 && test1) {
	            ArrayList<Integer> TempBestSolution = new ArrayList<Integer>();
	            j = i;
	            int sum = 0;
	            while (j >= 0 && test2) {

	                int temp = input.get(j);
	                if (sum + temp < Max) {
	                    sum = sum + temp;
	                    TempBestSolution.add(j);
	                } else if (sum + temp == Max) {
	                    sum = sum + temp;
	                    TempBestSolution.add(j);
	                    test2 = false;
	                    test1 = false;
	                }
	                j--;
	            }
	            if (score < sum) {
	                score = sum;
	                BestSolution = TempBestSolution;
	            }
	            if (BestSolution.size() == input.size()) {
	                test1 = false;

	            }

	            i--;
	        }

	        return BestSolution;
	    }
	
	public static int knapsackDP(int[] w, int[] v, int n, int W, ArrayList result) {
	    if (n <= 0 || W <= 0) {
	        return 0;
	    }
	 
	    int[][] m = new int[n + 1][W + 1];
	    for (int j = 0; j <= W; j++) {
	        m[0][j] = 0;
	    }
	 
	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= W; j++) { 
	            if (w[i - 1] > j) {
	                m[i][j] = m[i - 1][j];
	            } else {
	                m[i][j] = Math.max(
	                  m[i - 1][j], 
	                  m[i - 1][j - w[i - 1]] + v[i - 1]);
	            }
	        }
	    }
	    
	    int res =  m[n][W];
	    
	    for (int i = n; i > 0 && m[n][W] > 0; i--) { 
	    	  
            // either the result comes from the top 
            // (K[i-1][w]) or from (val[i-1] + K[i-1] 
            // [w-wt[i-1]]) as in Knapsack table. If 
            // it comes from the latter one/ it means 
            // the item is included. 
            if (m[n][W] == m[i - 1][W]) 
                continue; 
            else { 
  
                // This item is included. 
//                System.out.print(w[i - 1] + " "); 
//                System.out.println(i-1); 
                result.add(i-1);
                // Since this weight is included its 
                // value is deducted 
                m[n][W] = m[n][W] - v[i - 1]; 
                W = W - w[i - 1]; 
            } 
        } 
	    
	    return res;
	}
	
}


