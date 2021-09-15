import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
Problem Statement
Consider a string, S, that is a series of characters, each followed by its frequency as an integer. The string is not compressed correctly, so there may be many occurrences of the same character. A properly compressed string will consist of one instance of each character in alphabetical order followed by the total count of that character within the string.

For example, the string a3c9b2c1 has two instances where ‘c’ is followed by a count: once with 9 occurrences, and again with 1. It should be compressed to a3b2c10.
**/
class Result {

	/*
	 * Complete the 'betterCompression' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING s as parameter.
	 */

	public static String betterCompression(String s) {
		// Write your code here
		if(s==null || s.isEmpty())
			return "";
		char[]  charArr = s.toCharArray();
		Map<Character, Integer> charMap = new TreeMap<Character, Integer>();
		char current='x';
		for(int i=0;i<charArr.length;i++){

			if(Character.isAlphabetic(charArr[i])){
				Integer count = charMap.get(charArr[i]);
				if(count==null){
					charMap.put(charArr[i], 0);
					current = charArr[i];
				}else{
					String occurr="";
					for(int j=i+1;j<charArr.length;j++){
						if(Character.isDigit(charArr[j])){
							occurr = occurr + charArr[j];
						}else{
							count = count+Integer.parseInt(occurr);
							charMap.put(charArr[i],count);
							i=j-1;
							break;
						}
					}
				}
			}else{
				String occurr="";
				int j;
				for(j=i;j<charArr.length;j++){
					if(Character.isDigit(charArr[j])){
						System.out.println(charArr[i]+"occurr:"+charArr[j]);
						occurr = occurr + charArr[j];
						System.out.println(occurr);
					}else{
						i=j-1;
						charMap.put(current,Integer.parseInt(occurr.trim()));
						break;
					}
				}
				i=j-1;
				charMap.put(current,Integer.parseInt(occurr.trim()));

			}
		}
		String result ="";
		for(Character c : charMap.keySet()){
			result = result+c+charMap.get(c);
		}

		return result;
	}

}

public class BetterCompression {
	public static void main(String[] args) throws IOException {
		String result = Result.betterCompression("a13b2a12c10b45f45");
		System.out.println(result);
	}
}
