public class Coins{

	/* Problem:  Given an input X and a coin system C, 
	write a function to determine the minimum number of 
	coins required to make that exact amount of change.
	*/


	public static int min(int[] arr){
		int minimum = arr[0];
		for (int i = 1; i < arr.length; i++){
			if (arr[i] < minimum){
				minimum = arr[i];
			}
		}
		return minimum;
	}

	
	public static int coins(int x, int[] coins){
		
		if (coins == null || x < 0 || coins.length == 0){
			throw new IllegalArgumentException("Invalid input");
		}

		int[] cache = new int[x + 1];
		for (int i = 0; i < x + 1; i++){
			cache[i] = -1;
		}

		return coinsHelper(x,coins,cache);

	}

	/*
	public static int coinsHelper(int x, int[] coins, int[] cache){

		if (x == 0){
			return 0;
		}

		int min = x;
		for (int coin : coins){
			if (x - coin >= 0){
				int c;
				if (cache[x-coin] != -1){
					c = cache[x-coin];
				}else{
					c = coinsHelper(x - coin, coins, cache);
					cache[x-coin] = c;
				}

				if (min > c + 1){
					min = c + 1;
				}
				
				if (cache[x] == -1){
					cache[x] = 1 + coinsHelper(x-coin,coins,cache);
				}else{
					return cache[x];
				}
				
			}
		}

		return cache[x];
	}

	*/


	
	public static int coinsHelper(int x, int[] coins, int[] cache){
		if (x == 0){
			return 0;
		}
		int min = x;
		for (int coin : coins){
			if (x - coin >= 0){
				int c;
				if (cache[x-coin] == -1){
					cache[x-coin] = coinsHelper(x - coin, coins, cache);
				}
				
				c = cache[x-coin] + 1;

				if (c < min){
					min = c;
				}

			}

		}

		return min;

	}



	public static void main(String[] args){
		int[] c1 = {1,5, 10, 25};
		System.out.println(coins(90,c1));
	}
}