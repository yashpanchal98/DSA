class Solution {

    public void helper(int idx, int nums[], int n,List<Integer> curr, HashSet<List<Integer>> hs) {

        // Base case
        if(idx == n){
            hs.add(new ArrayList<Integer>(curr));
            return;
        }

        curr.add(nums[idx]);
        helper(idx+1,nums,n,curr,hs);
        curr.remove(curr.size() - 1);

        helper(idx+1,nums,n,curr,hs);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        int n = nums.length;


        helper(0, nums, n, curr, hs);

        list.addAll(hs);
        return list;
    }
}