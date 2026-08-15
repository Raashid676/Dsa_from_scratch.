
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            result.add(node.val);

            if(node.left != null){
                q.offer(node.left);

            }if(node.right != null){
                q.offer(node.right);
            }
        }

        for(int i=0; i<result.size(); i++){
            int sum = 0;

            for(int j= i+1; j<result.size(); j++){

                sum = result.get(i) + result.get(j);

                if(sum == k){
                    return true;
                }
            }
        }

        return false;
     
       
        
    }
}