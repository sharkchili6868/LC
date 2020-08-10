class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for(int i = 0; i < order.length(); i++) {
        	map[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1; i < words.length; i++) {
        	if (compare(words[i - 1], words[i], map)) return false;
        }

        return true;
    }

    private boolean compare(String s1, String s2, int[] map) {
    	int m = s1.length();
    	int n = s2.length();

    	for(int i = 0; i < m && i < n; i++) {
    		if (s1.charAt(i) != s2.charAt(i)) {
    			return map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a'];
    		}
    	}

    	return m > n;
    }
}