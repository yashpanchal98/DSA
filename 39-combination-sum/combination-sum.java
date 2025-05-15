class Solution {

    public void helper(int[] candidates, int sum, int target, int idx, int N, ArrayList<Integer> ans, HashSet<List<Integer>> hs) {
        
        if (sum == target) {
            hs.add(new ArrayList<>(ans)); 
            return;
        }
        
        if (idx == N || sum > target) return;

        ans.add(candidates[idx]);
        helper(candidates, sum + candidates[idx], target, idx, N, ans, hs); 
        ans.remove(ans.size() - 1); 
        helper(candidates, sum, target, idx + 1, N, ans, hs);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int N = candidates.length;
        HashSet<List<Integer>> hs = new HashSet<>();

        helper(candidates, 0, target, 0, N, ans, hs);

        result.addAll(hs);
        return result;
    }
}