class Solution {
    public int totalMoney(int n) {
        int monday = 1; 
        int bank = 0;   
        int day = 0;

        for (int i = 0; i < n; i++) {
            bank = bank + monday + day; 
            day++;

            if (day % 7 == 0) {
                monday++; 
                day = 0;  
            }
        }
        return bank;
    }
}