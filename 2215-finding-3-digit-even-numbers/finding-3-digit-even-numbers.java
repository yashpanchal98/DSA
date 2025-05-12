class Solution {
    public int[] findEvenNumbers(int[] digits) {

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0)
                continue;
            for (int j = 0; j < digits.length; j++) {
                if(i==j) continue;
                int number = digits[i] * 10 + digits[j]; 
                for (int k = 0; k < digits.length; k++) {
                    if(i==k || j==k) continue;
                    if (digits[k] % 2 != 0)
                        continue; 
                    int finalNumber = number * 10 + digits[k]; 
                   hs.add(finalNumber);
                }
            }
        }
        int arr[] = new int[hs.size()];
        int index = 0;
        for (int val : hs) {
            arr[index++] = val;
        }

        Arrays.sort(arr);  
        return arr;
    }
}