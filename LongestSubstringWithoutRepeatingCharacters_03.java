class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        
        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.get(ch) > 1) {
                while(map.get(ch) > 1) {
                    char c = s.charAt(left);
                    map.put(c, map.get(c) - 1);

                    if(map.get(c) == 0) {
                        map.remove(c);
                    }
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}