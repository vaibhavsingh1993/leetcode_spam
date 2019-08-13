/*
Our choice - At every step, do I open '(' or close ')'?
Our constraint - At each step no of closing brackets <= no of opening brackets
Our goal - n*2 characters 

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList();
        
        // 1st character has to be opening bracket, last has to be closing
        // c[0] = ()
        // c[1] = ( + () + ) or ( + )( + )
        //c[2] = ((())) or (()()) or (())() or ()(()) or ()()()
        // Maintain no of open lefts and no of open rights
        
        generateParens(out, n, n, "");
        return out;
    }
    
    private void generateParens(List<String> out, int lefts, int rights, String strInProgress) {
        if (lefts == 0 && rights == 0) {
            out.add(strInProgress);
            return;
        }
        if (lefts > 0) {
            generateParens(out, lefts - 1, rights, strInProgress + '(');
        }
        
        if (rights > lefts) {
            generateParens(out, lefts, rights - 1, strInProgress + ')');
        }
    }
}
