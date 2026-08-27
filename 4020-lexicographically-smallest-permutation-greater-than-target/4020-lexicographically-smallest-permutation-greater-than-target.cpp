class Solution {
public:
    string lexGreaterPermutation(string s, string target) {
        int n = s.size();
        vector<int> cnt(26, 0);
        for (char c : s) cnt[c - 'a']++;

        // Pass 1: find the largest index at which we can diverge
        int best_i = -1;
        vector<int> cur = cnt;
        for (int i = 0; i < n; i++) {
            int t = target[i] - 'a';

            // is there some letter > target[i] still available?
            bool found = false;
            for (int c = t + 1; c < 26; c++) {
                if (cur[c] > 0) { found = true; break; }
            }
            if (found) best_i = i;

            // try to extend the exact-match prefix
            if (cur[t] == 0) break;   // can't match target[i], stop extending
            cur[t]--;
        }

        if (best_i == -1) return "";  // no permutation works

        // Pass 2: construct the answer
        vector<int> cnt2 = cnt;
        string result(n, '?');

        // positions 0..best_i-1 match target exactly
        for (int j = 0; j < best_i; j++) {
            result[j] = target[j];
            cnt2[target[j] - 'a']--;
        }

        // position best_i: smallest available letter > target[best_i]
        int t = target[best_i] - 'a';
        int chosen = -1;
        for (int c = t + 1; c < 26; c++) {
            if (cnt2[c] > 0) { chosen = c; break; }
        }
        result[best_i] = 'a' + chosen;
        cnt2[chosen]--;

        // remaining positions: fill with leftover letters in ascending order
        int idx = best_i + 1;
        for (int c = 0; c < 26; c++) {
            while (cnt2[c] > 0) {
                result[idx++] = 'a' + c;
                cnt2[c]--;
            }
        }

        return result;
    }
};