class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        Map<Integer, ArrayList<Character>> rowTable= new HashMap();
        Map<Integer, ArrayList<Character>> colTable= new HashMap();
        Map<Integer, ArrayList<Character>> boxTable= new HashMap();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = board[i][j];
                int boxNo = (i / 3) * 3 + (j / 3);
                
                if (c != '.') {
                    // check if duplicate c exists in the same row.
                    ArrayList rowList = rowTable.getOrDefault(i, new ArrayList<Character>());
                    ArrayList colList = colTable.getOrDefault(j, new ArrayList<Character>());
                    ArrayList boxList = boxTable.getOrDefault(boxNo, new ArrayList<Character>());
                    
                    if (rowList.contains(c) || colList.contains(c) || boxList.contains(c)) {
                        return false;
                    } else {
                        rowList.add(c);
                        rowTable.put(i, rowList);

                        colList.add(c);
                        colTable.put(j, colList);
                        
                        boxList.add(c);
                        boxTable.put(boxNo, boxList);
                        
                        //System.out.println("for " + i + " rowList is" + rowList);
                        //System.out.println("for " + j +" colList is" + colList);
                        //System.out.println("for " + boxNo +" boxList is" + boxList);
                    }              
                }
            }
        }
        return true;
    }
}
