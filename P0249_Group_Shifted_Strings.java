class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strings) {
            String hashcode = hash(s);
            if (!map.containsKey(hashcode)) {
                map.put(hashcode, new ArrayList<>());
            }
            
            map.get(hashcode).add(s);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(List<String> group : map.values()) result.add(group);
        
        return result;
    }
    
    private String hash(String s) {
        int[] hashcode = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            hashcode[i] = s.charAt(i) - 'a';
        }
        
        int normalizer = hashcode[0];
        
        StringBuilder sb = new StringBuilder();
        if (normalizer == 0) {
            for(int num : hashcode) sb.append(num).append('.');
            return sb.toString();
        } 
        
        for(int i = 0; i < hashcode.length; i++) {
            hashcode[i] = hashcode[i] - normalizer;
            if (hashcode[i] < 0) {
                hashcode[i] += 26;
            }
        }
        
        for(int num : hashcode) sb.append(num).append('.');
        return sb.toString();
    }
}