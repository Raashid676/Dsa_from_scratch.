

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        int firstIdx = -1, prevIdx = -1;
        int minDist = INT_MAX, maxDist = -1;
        
        ListNode* prev = head;
        ListNode* curr = head->next;
        int idx = 1;
        
        while (curr->next != nullptr) {
            bool isMax = curr->val > prev->val && curr->val > curr->next->val;
            bool isMin = curr->val < prev->val && curr->val < curr->next->val;
            
            if (isMax || isMin) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = min(minDist, idx - prevIdx);
                }
                maxDist = idx - firstIdx; // updates as we go; final value is first-to-last
                prevIdx = idx;
            }
            
            prev = curr;
            curr = curr->next;
            idx++;
        }
        
        if (minDist == INT_MAX) return {-1, -1};
        return {minDist, maxDist};
    }
};