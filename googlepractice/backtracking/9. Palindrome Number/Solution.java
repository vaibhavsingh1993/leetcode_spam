class Solution {
//     public boolean isPalindrome(int x) {
//         char[] arr = String.valueOf(x).toCharArray();
        
//         Stack<Character> s = new Stack();
        
//         for (char c: arr) {
//             s.push(c);
//         }
        
//         char[] newchar = new char[arr.length];
        
//         for (int i = 0; i < newchar.length; i++) {
//             newchar[i] = s.pop();
//         }
        
//         int ne = 0;
        
//         try {
//             ne = Integer.parseInt(new String(newchar));
//         } catch (Exception ex) {
//             return false;
//         }
        
        
//         if (x == ne) return true;
//         return false;
//     }
    
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        if (arr[0] == '-') return false;
        
        int size = arr.length;
        int first = 0, last = arr.length - 1;
        
        while(first <= last) {
            if (arr[first] != arr[last]) return false;
            else {
                first++;
                last--;
            }
        }
        return true;
        
    }
    
    
    
}
