class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap();
        for (String str: strs) {
            //System.out.println(str);
            char[] cha = str.toCharArray();
            Arrays.sort(cha);
            String str2 = new String(cha);
            List lis = anagrams.get(str2) !=  null ? anagrams.get(str2) : new ArrayList();
            //System.out.println(lis);
            lis.add(str);
            anagrams.put(str2, lis);
        }
        
        
        Set<String> keys = anagrams.keySet();
        List<List<String>> ret = new ArrayList();
        for (String key : keys) {
            ret.add(anagrams.get(key));
        }
        return ret;
    }
}
