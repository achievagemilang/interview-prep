package leetcode.companies.traveloka;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
    public static boolean validBrackets(String s){
        if(s.length() == 1) return false;

        Deque<Character> st = new ArrayDeque<>();
        Map<Character, Character> openBrackets = new HashMap<>();
        openBrackets.put('(', ')');
        openBrackets.put('[', ']');
        openBrackets.put('{', '}');

        for(Character c: s.toCharArray()){
            if(openBrackets.containsKey(c)){
                st.push(c);
            } else {
                if (st.isEmpty()){
                    return false;
                }
                Character popped = st.pop();
                if(openBrackets.get(popped) != c){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        System.out.println(validBrackets("()[]{}")); 
        System.out.println(validBrackets("()[]{})"));
        System.out.println(validBrackets("()[]{})("));
        System.out.println(validBrackets("()[]{}}"));
	}
}
/*
T(n) = O(n)
S(n) = O(n)
*/




