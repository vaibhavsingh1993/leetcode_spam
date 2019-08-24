// class StringIterator {
//     char[] key;
//     int[] val;
//     int pointer;
//     String curr;
//     public StringIterator(String compressedString) {
//         curr = compressedString;
//         key = new char[compressedString.length() / 2];
//         val = new int[compressedString.length() / 2];
//         pointer = 0;
        
//         for (int i = 0; i < compressedString.length() / 2; i++) {
//             key[i] = compressedString.charAt(2 * i);
//             val[i] = Character.getNumericValue(compressedString.charAt(2 * i + 1));
//         }
//     }
    
//     public char next() {
//         if (hasNext()) {
//             if(val[pointer] == 0) {
//                 pointer++;
//             }
//             val[pointer] = val[pointer] - 1;
//             System.out.println(pointer);
//             return key[pointer];            
//         }
//         return ' ';
//     }
    
//     public boolean hasNext() {
//         if (pointer > curr.length() / 2 - 1) {
//             return false;
//         }
//         return true;
//     }
// }

// /**
//  * Your StringIterator object will be instantiated and called as such:
//  * StringIterator obj = new StringIterator(compressedString);
//  * char param_1 = obj.next();
//  * boolean param_2 = obj.hasNext();
//  */


public class StringIterator {
    private int i;
    private long rep;
    private char ch;
    private char[] cs;
    public StringIterator(String compressedString) {
        cs = compressedString.toCharArray();
    }
    
    public char next() {
        if (rep > 0) {
            rep--;
            return ch;
        }
        else if (i < cs.length) {
            ch = cs[i];
            int j = i + 1;
            while (j < cs.length && Character.isDigit(cs[j])) {
                rep = rep * 10 + cs[j] - '0';
                j++;
            }
            rep--;
            i = j;
            return ch;
        }
        else {
            return ' ';
        }        
    }
    
    public boolean hasNext() {
        return rep > 0 || i < cs.length;
    }
}
