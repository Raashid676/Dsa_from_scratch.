package BIT_MANUPULATION;

import java.util.*;

public class Main2 {

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Build pair -> list of possible top characters
        Map<String, List<Character>> map = new HashMap<>();

        for (String pattern : allowed) {
            String pair = pattern.substring(0, 2);
            char top = pattern.charAt(2);

            map.computeIfAbsent(pair, k -> new ArrayList<>()).add(top);
        }

        return solve(bottom, map, 0, new StringBuilder());
    }

    private boolean solve(String curr,
                          Map<String, List<Character>> map,
                          int idx,
                          StringBuilder above) {

        // Pyramid completed
        if (curr.length() == 1) {
            return true;
        }

        String key = curr + "_" + idx + "_" + above.toString();

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Finished constructing the current upper row
        if (idx == curr.length() - 1) {
            boolean result = solve(above.toString(), map, 0, new StringBuilder());
            memo.put(key, result);
            return result;
        }

        String pair = curr.substring(idx, idx + 2);

        if (!map.containsKey(pair)) {
            memo.put(key, false);
            return false;
        }

        for (char ch : map.get(pair)) {
            above.append(ch); // DO

            if (solve(curr, map, idx + 1, above)) {
                memo.put(key, true);
                return true;
            }

            above.deleteCharAt(above.length() - 1); // UNDO
        }

        memo.put(key, false);
        return false;
    }
}