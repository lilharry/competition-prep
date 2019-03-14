import java.util.Map;
import java.util.HashMap;
public class Problem1{


	public static char firstUniqueCharacter(String s){
		Map<Character, Integer> chars = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++){
			if (!chars.keySet().contains(s.charAt(i))){
				chars.put(s.charAt(i), 1);
			}else{
				chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < s.length(); i++){
			if (chars.get(s.charAt(i)) == 1){
				return s.charAt(i);
			}
		}
		 	
		return 0;	
	}


	public static void main(String[] args){
		System.out.println(firstUniqueCharacter("adbcyabde"));



	}
}