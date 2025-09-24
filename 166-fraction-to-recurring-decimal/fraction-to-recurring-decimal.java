class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        StringBuilder sb = new StringBuilder();

        if(numerator == 0) return "0";

        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);

        sb.append(dividend / divisor);
        long remainder = dividend % divisor;

        if(numerator > 0 && denominator < 0) sb.insert(0,"-");
        if(numerator < 0 && denominator > 0) sb.insert(0,"-");
        if(remainder == 0) return sb.toString();
        sb.append(".");

        Map<Long,Integer> map = new HashMap<>();

        while(remainder > 0){

            if(map.containsKey(remainder)){

                sb.insert(map.get(remainder),"(");
                sb.append(")");
                break;
            } else {
                map.put(remainder,sb.length());
                remainder *= 10;
                sb.append(remainder/divisor);
                remainder = remainder%divisor;

            }
        }

        return sb.toString();
    }
}