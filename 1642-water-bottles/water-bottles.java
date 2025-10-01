class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int total = numBottles;
        int Empty = numBottles;

        while(Empty >= numExchange){

            int refill = Empty/numExchange;
            total += refill;
            Empty = refill + Empty%numExchange;
        }
        return total;
    }
}