public class Clouds{
	/* Emma is playing a new mobile game that starts with consecutively numbered clouds. 
	Some of the clouds are thunderheads and others are cumulus. 
	She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. 
	She must avoid the thunderheads. 
	Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. 
	It is always possible to win the game.
	*/
	public static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;
        
        for (i = 0; i < c.length - 2; i++){
            if (c[i+2] == 0){
                
                i++;
            }

            jumps++;
        }
        if (i < c.length-1){
            if (c[c.length-1] == 0){
                jumps++;
            }
        }
        return jumps;

    }

    public static void main(String[] args){
		int[] c1 = {1,5, 10, 25};
		System.out.println(coins(90,c1));
	}

}