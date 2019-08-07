class Solution {
    public boolean isArmstrong(int N) {
        int temp = N;
        int digits = 0;
        while (temp >= 1) {
            digits++;
            temp /= 10;
        }
        
        int sumPower = 0;
        temp = N;
        while(temp >= 1) {
            //System.out.println(temp % 10);
            sumPower += Math.pow(temp % 10, digits);
            //System.out.println(sumPower);
            temp /= 10;
        }
        
        return (sumPower == N);
    }
}


// class Solution {
//     public boolean isArmstrong(int N) {
//         String str = String.valueOf(N);
//         int n = str.length();
//         int curr = 0;
//         for(char c : str.toCharArray()) {
//             curr += (int) Math.pow(c-'0', n);
//         }
//         return curr == N;
//     }
// }
