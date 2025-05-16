class Solution {
    public int countCollisions(String directions) {

        int collision = 0;

        Stack<Character> st = new Stack<>();

        for(int i=0; i<directions.length(); i++){

            char ch = directions.charAt(i);

            if(st.isEmpty()){
                st.push(ch);
            } else if(st.peek()=='R' && ch=='L'){ // R-L collision
                st.pop();
                st.push('S');
                collision+=2;
            } else if(st.peek()=='R' && ch=='S'){ // R-S collision
                st.pop();
                st.push(ch);
                collision+=1;
            } else if(st.peek()=='S' && ch=='L') { // S-L collision
                collision+=1;
            } else {
                // no collison
                st.push(ch);
            }
        }

        while(st.size()>1){
            char top = st.pop();
            if(st.peek()=='R' && top =='S'){
                collision+=1;
                st.pop();
                st.push('S');
            }   
        }
        return collision;
    }
}