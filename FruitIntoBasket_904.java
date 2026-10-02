class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        int left = 0; 
        
        for(int right = 0; right < fruits.length; right++) {
            int tree = fruits[right];
            map.put(tree, map.getOrDefault(tree, 0) + 1);

            while(map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);

                if(map.get(leftFruit) == 0) {
                    map.remove(leftFruit);

                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


}