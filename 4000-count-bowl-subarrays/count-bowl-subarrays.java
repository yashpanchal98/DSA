class Solution {

    public int[] nextGreater(int nums[]){

        int n = nums.length;
        int nxtGrtr[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if(st.isEmpty())  nxtGrtr[i] = -1;
            else  nxtGrtr[i] = st.peek();
            st.push(i);
        }
        return nxtGrtr;

    }

    public int[] prevGreater(int nums[]){

        int n = nums.length;
        int prevGrtr[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if(st.isEmpty())  prevGrtr[i] = -1;
            else  prevGrtr[i] = st.peek();
            st.push(i);
        }
        return prevGrtr;

    }

    public long bowlSubarrays(int[] nums) {
        
        int n = nums.length;
        int nxtGrtr[] = nextGreater(nums);
        int prevGrtr[] = prevGreater(nums);

        long ans = 0;

        for(int i=1; i<n; i++){

            int val1 = -1,val2=-1;
            if(nxtGrtr[i] != -1) val1 = nums[nxtGrtr[i]];
            if(prevGrtr[i] != -1) val2 = nums[prevGrtr[i]];
            if(val1 > nums[i] && val2 > nums[i]) ans++;
            
        }
        return ans;
    }
}