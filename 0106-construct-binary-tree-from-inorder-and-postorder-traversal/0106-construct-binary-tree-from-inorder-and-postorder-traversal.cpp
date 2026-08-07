
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size() != postorder.size()) return NULL;

        unordered_map<int, int> hm;
        for(int i = 0; i < inorder.size(); i++){
            hm[inorder[i]] = i;
        }

        return build(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1, hm);
    }

    TreeNode* build(vector<int>& inorder, int inOst, int inOend,
                     vector<int>& postorder, int pSt, int pEnd,
                     unordered_map<int, int>& hm) {
        if(pSt > pEnd || inOst > inOend) return NULL;

        TreeNode* root = new TreeNode(postorder[pEnd]);

        int inRoot = hm[postorder[pEnd]];
        int numsLeft = inRoot - inOst;

        root->left  = build(inorder, inOst, inRoot - 1, postorder, pSt, pSt + numsLeft - 1, hm);
        root->right = build(inorder, inRoot + 1, inOend, postorder, pSt + numsLeft, pEnd - 1, hm);

        return root;
    }
};