
class Solution {
public:
    vector<int> validSequence(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();

        // suf[i] = maximum number of characters of word2
        // that can be matched exactly using word1[i...n-1].
        vector<int> suf(n + 1, 0);

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];

            if (j >= 0 && word1[i] == word2[j]) {
                suf[i]++;
                j--;
            }
        }

        vector<int> ans;

        int p = 0;
        bool changed = false;

        for (int i = 0; i < m; i++) {

            while (p < n) {

                // Case 1: exact match
                if (word1[p] == word2[i]) {
                    ans.push_back(p);
                    p++;
                    break;
                }

                // Case 2: use the one modification
                if (!changed) {
                    int need = m - i - 1;

                    // After taking p, can the rest be matched exactly?
                    if (suf[p + 1] >= need) {
                        ans.push_back(p);
                        p++;
                        changed = true;
                        break;
                    }
                }

                p++;
            }

            if (ans.size() != i + 1)
                return {};
        }

        return ans;
    }
};