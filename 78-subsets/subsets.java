class Solution {

    public void helper(int idx, int nums[], int n,List<List<Integer>> list,  List<Integer> curr) {

        // Base case
        if(idx == n){
            list.add(new ArrayList<Integer>(curr));
            return;
        }

        curr.add(nums[idx]);
        helper(idx+1,nums,n,list,curr);
        curr.remove(curr.size() - 1);
        helper(idx+1,nums,n,list,curr);

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int n = nums.length;
        helper(0, nums, n, list, curr);

        return list;
    }
}