class Solution {
public:
    vector<int> remainingMethods(int n, int k, vector<vector<int>>& invocations) {
        vector<vector<int>> adj(n);
        for (auto& e : invocations) {
            adj[e[0]].push_back(e[1]);
        }

        // Step 1: find all suspicious methods (reachable from k)
        vector<bool> suspicious(n, false);
        suspicious[k] = true;
        queue<int> q;
        q.push(k);
        while (!q.empty()) {
            int u = q.front(); q.pop();
            for (int v : adj[u]) {
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    q.push(v);
                }
            }
        }

        // Step 2: check if any non-suspicious method invokes a suspicious one
        bool canRemove = true;
        for (auto& e : invocations) {
            int a = e[0], b = e[1];
            if (!suspicious[a] && suspicious[b]) {
                canRemove = false;
                break;
            }
        }

        // Step 3: build result
        vector<int> result;
        if (!canRemove) {
            result.resize(n);
            for (int i = 0; i < n; i++) result[i] = i;
        } else {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) result.push_back(i);
            }
        }
        return result;
    }
};