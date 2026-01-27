class Solution {

    class Info implements Comparable<Info> {
        int st;
        int end;

        public Info(int st, int end){
            this.st = st;
            this.end = end;
        }

        public int compareTo(Info i){
            return this.st - i.st;
        }
    }

    public int[][] merge(int[][] intervals) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int interval[] : intervals) pq.add(new Info(interval[0],interval[1]));

        Info curr = pq.remove();
        int laststart = curr.st;
        int lastend = curr.end;

        while(!pq.isEmpty()){
            Info temp = pq.remove();
            if(temp.st <= lastend){
                lastend = Math.max(lastend, temp.end);
            } else {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(laststart);
                ans.add(lastend);
                list.add(ans);
                laststart = temp.st;
                lastend = temp.end;
            }
        }
        list.add(new ArrayList<>(Arrays.asList(laststart, lastend)));

        int mat[][] = new int[list.size()][2];

        for(int i=0; i<list.size(); i++){
            mat[i][0] = list.get(i).get(0);
            mat[i][1] = list.get(i).get(1);
        }
        return mat;
    }
}