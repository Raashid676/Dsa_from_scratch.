
class Solution {
    private void inorderTraversal(TreeNode root, List<Integer> values){
        
        if(root !=  null){

            inorderTraversal(root.left, values);
            values.add(root.val);

            inorderTraversal(root.right, values);
            
        }
    }
   
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);



        return values.get(k - 1);


        
    }
}