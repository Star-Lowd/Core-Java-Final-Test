package utill;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

	public static int computMatrix (int[][] input){
		List<Integer> computedOutput = new ArrayList<>();
		
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				for (int j2 = 0; j2 < input.length; j2++) {
					System.out.print(input[i][j]);
				}
			}
			System.out.println();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int inputs[][] = {{1,0,1,1,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,1,1,1},{1,0,0,1,0}};
		computMatrix(inputs);
	}

}
