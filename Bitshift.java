public class Bitshift{
	public static int countOnes(int x){
		int numOnes = 0;
		while (x != 0){
			numOnes += x & 1;

			x >>>= 1;

		}
		return numOnes;
	}



	public static void main(String[] args){
		System.out.println(countOnes(-64));

	}



}