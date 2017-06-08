package utill;

public class ArraySubset {

	public static boolean subSet(int[] inputs){
		boolean containsSubset = false;
		
		for (int i = 0; i < inputs.length; i++) {
			int sum = 0;
			for (int j = 0; j < inputs.length; j++) {
				if (i != j){
					sum += inputs[j];
				}
			}
			if (sum == 16){
				containsSubset = true;
				break;
			}
		}
		
		return containsSubset;
	}

	
}
