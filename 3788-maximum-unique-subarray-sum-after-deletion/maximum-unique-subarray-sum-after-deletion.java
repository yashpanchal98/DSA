class Solution {
    public int maxSum(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums){
            max = Math.max(num,max);
            if(!hs.contains(num) && num > 0){
                hs.add(num);
                sum+=num;
            }
        }   

        if(max <= 0) return max;
        return sum;
    }
}