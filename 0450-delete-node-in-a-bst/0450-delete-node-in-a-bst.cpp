class Solution {
public:

    TreeNode* deleteNode(TreeNode* root, int key) {

        if(root == NULL) {
            return NULL;
        }

        // If root itself is the node to delete
        if(root->val == key) {
            return helper(root);
        }

        TreeNode* dummy = root;

        while(root != NULL) {

            if(root->val > key) {

                // Key is in left subtree
                if(root->left != NULL && root->left->val == key) {
                    root->left = helper(root->left);
                    break;
                }
                else {
                    root = root->left;
                }

            }
            else {

                // Key is in right subtree
                if(root->right != NULL && root->right->val == key) {
                    root->right = helper(root->right);
                    break;
                }
                else {
                    root = root->right;
                }
            }
        }

        return dummy;
    }


    TreeNode* helper(TreeNode* root) {

        // No left child
        if(root->left == NULL) {
            return root->right;
        }

        // No right child
        else if(root->right == NULL) {
            return root->left;
        }

        // Both left and right children exist
        TreeNode* rightChild = root->right;

        TreeNode* lastRight = FindLastRight(root->left);

        lastRight->right = rightChild;

        return root->left;
    }


    TreeNode* FindLastRight(TreeNode* root) {

        if(root->right == NULL) {
            return root;
        }

        return FindLastRight(root->right);
    }
};