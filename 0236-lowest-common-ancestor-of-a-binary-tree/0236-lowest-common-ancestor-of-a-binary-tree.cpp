
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if(root == NULL){
            return NULL;
        }

        if(root->val == p->val || root->val == q->val){
            return root;
        }


        TreeNode* leftLca = lowestCommonAncestor(root->left, p,q);
        TreeNode* rightLca = lowestCommonAncestor(root->right, p,q);

        if(leftLca && rightLca){
            return root;
        }

        else if(leftLca != NULL){
            return leftLca;
        }
        else{

            return rightLca;
        }
    }
};