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
    
    int getPrecedence(char s)
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
    
    public String convertToPostFix(String s)
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
                if(getPrecedence(c)<getPrecedence(stack.peek()))
                    postfix.append(c);
                else
                    stack.push(c);   
            }
            else if(c==')')
            {
                while(stack.peek()!='(')
                {
                     postfix.append(e);
                     stack.pop();
                }
                stack.pop();
            }
            else
                postfix.append(c);
        }
        System.out.println(Arrays.toString(stack.toArray()));
        // stack.forEach((e) -> {
        //     postfix.append(e);
        //     stack.pop();
        // });
        stack.push(')');
        return postfix.toString();
    }
    
    public int calculate(String s) {
        String postFix = convertToPostFix(s);
        System.out.println(postFix);
        return 0;
    }
}
