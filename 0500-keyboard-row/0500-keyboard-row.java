class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (canBeTypedInOneRow(word, rows)) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    private boolean canBeTypedInOneRow(String word, String[] rows) {
        String lowerWord = word.toLowerCase();
        
        for (String row : rows) {
            HashSet<Character> rowSet = new HashSet<>();
            for (char c : row.toCharArray()) {
                rowSet.add(c);
            }
            
            boolean allInRow = true;
            for (char c : lowerWord.toCharArray()) {
                if (!rowSet.contains(c)) {
                    allInRow = false;
                    break;
                }
            }
            
            if (allInRow) {
                return true;
            }
        }
        
        return false;
    }
}