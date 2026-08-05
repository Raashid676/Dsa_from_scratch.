
class Solution {
public:
    unordered_map<TreeNode*, TreeNode*> parent;

    void addParent(TreeNode* root) {
        if (!root) return;
        if (root->left != NULL) {
            parent[root->left] = root;
            addParent(root->left);
        }
        if (root->right != NULL) {
            parent[root->right] = root;
            addParent(root->right);
        }
    }

    void BFS(TreeNode* target, int k, vector<int>& result) {
        queue<TreeNode*> que;
        que.push(target);

        unordered_set<TreeNode*> visited;
        visited.insert(target);

        while (!que.empty()) {
            int n = que.size();

            if (k == 0) break;

            while (n--) {
                TreeNode* curr = que.front();
                que.pop();

                // right
                if (curr->right != NULL && !visited.count(curr->right)) {
                    que.push(curr->right);
                    visited.insert(curr->right);
                }

                // left
                if (curr->left != NULL && !visited.count(curr->left)) {
                    que.push(curr->left);
                    visited.insert(curr->left);
                }

                // parent
                if (parent.count(curr) && !visited.count(parent[curr])) {
                    que.push(parent[curr]);
                    visited.insert(parent[curr]);
                }
            }
            k--;
        }

        while (!que.empty()) {
            TreeNode* temp = que.front();
            que.pop();
            result.push_back(temp->val);
        }
    }

    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        vector<int> result;
        addParent(root);
        BFS(target, k, result);
        return result;
    }
};