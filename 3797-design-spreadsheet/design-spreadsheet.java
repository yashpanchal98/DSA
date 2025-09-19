class Spreadsheet {
        
        public Map<String,Integer> cells;
        public int rows;
    
    public Spreadsheet(int rows) {
        
        this.rows = rows;
        this.cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell,value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        if(!formula.startsWith("=")){
            return parseValue(formula);
        }
        String parts[] = formula.substring(1).split("\\+");
        int sum=0;
        for(String part : parts) {
            sum+= parseValue(part.trim());
        }
        return sum;
    }
    
    private int parseValue(String term) {
        if (Character.isDigit(term.charAt(0))) {
            return Integer.parseInt(term);
        }
        return cells.getOrDefault(term, 0);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */