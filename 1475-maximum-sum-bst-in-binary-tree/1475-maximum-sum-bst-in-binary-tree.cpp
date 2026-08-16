
class Solution {
public:

    struct Info {
        int min;
        int max;
        int sum;

        Info(int mi, int ma, int s) {
            min = mi;
            max = ma;
            sum = s;
        }
    };

    int ans = 0;

    Info helper(TreeNode* root) {

        // Empty tree
        if (root == NULL) {
            return Info(INT_MAX, INT_MIN, 0);
        }

        Info left = helper(root->left);
        Info right = helper(root->right);

        // Current subtree is BST
        if (root->val > left.max &&
            root->val < right.min) {

            int currMin = min(root->val, left.min);
            int currMax = max(root->val, right.max);

            int currSum = left.sum + right.sum + root->val;

            ans = max(ans, currSum);

            return Info(currMin, currMax, currSum);
        }

        // Current subtree is NOT a BST
        return Info(INT_MIN, INT_MAX, 0);
    }

    int maxSumBST(TreeNode* root) {
        helper(root);
        return ans;
    }
};