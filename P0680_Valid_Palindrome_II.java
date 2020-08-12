class Solution {
	public boolean validPalindrome(String s) {
       	int lo = 0;
       	int hi = s.length() - 1;

       	while(lo < hi) {
       		if (s.charAt(lo) == s.charAt(hi)) {
       			lo++;
       			hi--;
       		} else {
       			return validPalindrome(s, lo + 1, hi) 
       			|| validPalindrome(s, lo, hi - 1);
       		}
       	}

       	return true;
    }

    private boolean validPalindrome(String s, int lo, int hi) {
    	while(lo < hi) {
    		if (s.charAt(lo) != s.charAt(hi)) {
    			return false;
    		}
    		lo++;
    		hi--;
    	}

    	return true;
    }
}