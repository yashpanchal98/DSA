class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[2], a[2])   
        );

        for (int[] c : classes) {
            double pass = c[0];
            double total = c[1];
            double gain = maximum(pass, total);
            pq.add(new double[]{pass, total, gain});
        }

        while (extraStudents > 0) {
            double[] info = pq.poll();      
            info[0]++;                      
            info[1]++;                      
            info[2] = maximum(info[0], info[1]); 
            pq.add(info);                   
            extraStudents--;
        }


        double sum = 0.0;
        for (double[] info : pq) {
            sum += info[0] / info[1];
        }

        return sum / classes.length;
    }

    public double maximum(double pass, double total) {
        double curr = pass / total;
        double next = (pass + 1) / (total + 1);
        return next - curr;
    }
}