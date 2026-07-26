class Solution {
    private final int[] charToRow;
    
    public Solution() {
        charToRow = new int[26];
        
        for (char c : "qwertyuiop".toCharArray()) charToRow[c - 'a'] = 0;
        for (char c : "asdfghjkl".toCharArray()) charToRow[c - 'a'] = 1;
        for (char c : "zxcvbnm".toCharArray()) charToRow[c - 'a'] = 2;
    }
    
    public String[] findWords(String[] words) {
        return Arrays.stream(words)
            .filter(this::canTypeInOneRow)
            .toArray(String[]::new);
    }
    
    private boolean canTypeInOneRow(String word) {
        if (word.isEmpty()) return false;
        
        int row = charToRow[Character.toLowerCase(word.charAt(0)) - 'a'];
        
        for (int i = 1; i < word.length(); i++) {
            if (charToRow[Character.toLowerCase(word.charAt(i)) - 'a'] != row) {
                return false;
            }
        }
        
        return true;
    }
}