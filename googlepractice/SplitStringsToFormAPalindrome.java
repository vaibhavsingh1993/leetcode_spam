package googlepractice;

public class SplitStringsToFormAPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcbbbb", "xxxbcba"));

        System.out.println(isPalindrome("abcd", "efgh"));

        System.out.println(isPalindrome("abcbbbb", "xxxbcba", true));

        System.out.println(isPalindrome("xxxbcba", "abcbbbb", true));
    }

    public static int isPalindrome(String str1, String str2, boolean followup) {
        if (followup) {
            int ans1 = isPalindrome(str1, str2);
            if (ans1 > 0) {
                return ans1;
            }
            else {
                return isPalindrome(str2, str1);
            }
        } else {
            return isPalindrome(str1, str2);
        }
    }

    public static int isPalindrome(String str1, String str2) {
        int index1 = 0;
        int index2 = str1.length() - 1;

        StringBuilder strBuilder1 = new StringBuilder();
        StringBuilder strBuilder2 = new StringBuilder();

        while(index1 < str1.length() - 1) {
            strBuilder1.append(str1.charAt(index1));
            strBuilder2.append(str2.charAt(index2));

            if (!strBuilder1.toString().equals(strBuilder2.toString())) {
                return index1;
            }

            index1++;
            index2--;
        }

        return -1;
    }
}
