class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> frequencyMap = new HashMap();
        Set<String> bannedSet = new HashSet<String>(Arrays.asList(banned)); 
        
        String[] words = paragraph.split("\\W+");
        
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            int freq = frequencyMap.getOrDefault(word, 0);
            if (!bannedSet.contains(word)) {
                //System.out.println(word);
                frequencyMap.put(word, ++freq);
            }
        }
        int maxCount = 0;
        
        for (int s : frequencyMap.values()) {
            //System.out.println(s);
            if (maxCount < s) maxCount = s;
        }
        
        
        String ans = "";
        for (Map.Entry<String,Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue().equals(maxCount)) ans = entry.getKey();            
        }
        
        return ans;
    }
    
    // public String mostCommonWord(String p, String[] banned) {
    //     Set<String> ban = new HashSet<>(Arrays.asList(banned));
    //     Map<String, Integer> count = new HashMap<>();
    //     String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
    //     for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
    //     return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    // }
}
