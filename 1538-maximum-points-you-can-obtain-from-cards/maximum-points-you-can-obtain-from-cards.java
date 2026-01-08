class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int sum =0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            sum+=cardPoints[i];
        }
        maxSum = Math.max(sum,maxSum);

        int left = k-1;
        int right = cardPoints.length-1;

        while(left >=0){

            sum= sum-cardPoints[left]+cardPoints[right];
            left--;
            right--;
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}