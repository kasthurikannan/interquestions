/*We define the following:
    String s consists of lowercase letters in the range ascii[a-z].
    String x consists of lowercase letters and may also contain a single wild-card character *, that represents any one character.
Given s and x, we want to know the zero-based index of the first occurrence of x in s. For example, if s = xabcdey and x = ab*de, the index is 1.
Function Description: Complete the function firstOccurence in the editor below.
The function must return an integer denoting the zero-based index of the first occurrence of string x in s.
If x is not in s return -1 instead.
firstOccurence has the following parameter(s):
s: a string of lowercase letters. x: a string of lowercase letter which may contain 1 instance of wild-card character */


public class FindSubstringInString {
	

    public static void main(String[] args) {
        String s = "kasthuri";
        String x = "as*hu";
        System.out.print(firstOccurence(s,x));
    }
	
	public static int firstOccurence (String s, String x){
        if(x.indexOf('*')>-1){
            String[] frag = x.split("\\*");
            if(s.contains(frag[0]) && s.contains(frag[1])){
                int firIndex = s.indexOf(frag[0]);
                int firSecIndex = firIndex + frag[0].length();
                if(firSecIndex+1 == s.indexOf(frag[1], firSecIndex)){
                    return firIndex;
                }
            }
        }else{
            return s.indexOf(x);
        }
        return -1;
    }

}
