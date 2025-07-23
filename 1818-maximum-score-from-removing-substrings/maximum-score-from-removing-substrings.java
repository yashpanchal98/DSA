class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        Stack<Character> stk = new Stack<>();
        StringBuilder str = new StringBuilder();
        if(x > y){
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) == 'b'){
                    if(!stk.isEmpty() && stk.peek() == 'a'){
                        stk.pop();
                        res+=x;
                    }
                    else
                        stk.push(s.charAt(i));
                }
                else
                    stk.push(s.charAt(i));
            }
            while(!stk.isEmpty())
                str.append(stk.pop());
            String s1 = str.reverse().toString();
            for(int i = 0; i<s1.length(); i++){
                if(s1.charAt(i) == 'a'){
                    if(!stk.isEmpty() && stk.peek() == 'b'){
                        stk.pop();
                        res+=y;
                    }
                    else
                        stk.push(s1.charAt(i));
                }
                else
                    stk.push(s1.charAt(i));
            }
        }
        else{
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) == 'a'){
                    if(!stk.isEmpty() && stk.peek() == 'b'){
                        stk.pop();
                        res+=y;
                    }
                    else
                        stk.push(s.charAt(i));
                }
                else
                    stk.push(s.charAt(i));
            }
                while(!stk.isEmpty())
                    str.append(stk.pop());
                String s2 = str.reverse().toString();
                for(int j = 0; j<s2.length(); j++){
                if(s2.charAt(j) == 'b'){
                    if(!stk.isEmpty() && stk.peek() == 'a'){
                        stk.pop();
                        res+=x;
                    }
                    else
                        stk.push(s2.charAt(j));
                }
                else
                    stk.push(s2.charAt(j));
            }
        }
        return res;
    }
}