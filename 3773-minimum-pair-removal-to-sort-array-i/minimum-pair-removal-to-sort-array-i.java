class Solution {

    public boolean isSorted(List<Integer> list){

        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1)) return false;
        }
        return true;
    }

    public void findMinPair(List<Integer> list){
        int idx = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<list.size()-1; i++){
            int sum = list.get(i) + list.get(i+1);
            if(sum < min){
                idx = i;
                min = sum;
            }
        }
        list.set(idx,min);
        list.remove(idx+1);
    }

    public int minimumPairRemoval(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        int cnt = 0;

        while(!isSorted(list)){
            findMinPair(list);
            cnt++;
        }
        return cnt;
    }
}