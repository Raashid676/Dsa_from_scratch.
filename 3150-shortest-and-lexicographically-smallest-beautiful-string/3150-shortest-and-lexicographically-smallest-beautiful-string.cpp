
class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.size();
        string ans = "";
        int minLen = INT_MAX;

        int left = 0, ones = 0;

        for (int right = 0; right < n; right++) {
            if (s[right] == '1') ones++;

            // shrink from left while window has more than k ones,
            // or while left character is '0' and we still have exactly k ones
            while (ones > k || (left < right && s[left] == '0' && ones == k)) {
                if (s[left] == '1') ones--;
                left++;
            }

            if (ones == k) {
                int len = right - left + 1;
                string candidate = s.substr(left, len);

                if (len < minLen) {
                    minLen = len;
                    ans = candidate;
                } else if (len == minLen && candidate < ans) {
                    ans = candidate;
                }
            }
        }

        return ans;
    }
};