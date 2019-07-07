/* O(n^2) solution*/
public class Solution {

  public List<List<Integer>> threeSum(int[] num) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    Set<String> set = new HashSet<String>();
    Arrays.sort(num);
    int n = num.length;
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1, k = n - 1;
      while (j < k) {
        int sum = num[i] + num[j] + num[k];
        if (sum == 0) {
          String key = String.format("%d,%d,%d", num[i], num[j], num[k]);
          if (!set.contains(key)) {
            set.add(key);
            List<Integer> sol = new ArrayList<Integer>();
            sol.add(num[i]);
            sol.add(num[j]);
            sol.add(num[k]);
            res.add(sol);
          }
          j++;
          k--;
        } else if (sum < 0) {
          j++;
        } else {
          k--;
        }
      }
    }
    return res;
  }

}
