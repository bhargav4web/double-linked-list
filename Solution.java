import java.io.*; 
import java.util.*; 

class Solution {
    
    static boolean isOperator(char input) { 
        switch (input) { 
            case '+': 
            case '-': 
            case '*': 
            case '^': 
            case '%': 
            case '/': 
            case '(': 
                return true; 
        } 
        return false; 
    } 
    
    static int getPrecedence(char s)
    {
        if(s == '^')
            return 3;
        else if(s == '*' || s == '/')
            return 2;
        else if(s == '+' || s == '-')       
            return 1;
        else
            return 0;
    }
    
    static String convertToPostFix(String s)
    {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        stack.push('(');
        
        char arr[] = s.toCharArray();
        for(char c : arr)
        {
            // System.out.println(c);
            if(Solution.isOperator(c))
            {
                if(!stack.isEmpty())
                	if(getPrecedence(c)<getPrecedence(stack.peek()))
                		postfix.append(c);
                if(stack.isEmpty())
            		postfix.append(c);
                else
                    stack.push(c);   
            }
            else if(c==')')
            {
                while(!stack.isEmpty())
                {
                	if(stack.peek()==')')
                	{
                		postfix.append(c);  
                	}
                	stack.pop();
                }
            }
            else
                postfix.append(c);
        }
        System.out.println(Arrays.toString(stack.toArray()));
        stack.push(')');
        return postfix.toString();
    }
    
	public static void main(String[] args) {
        String postFix = convertToPostFix("(1+(4+5+2)-3)+(6+8)");
        System.out.println(postFix);
    }
}