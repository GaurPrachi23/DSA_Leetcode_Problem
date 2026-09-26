/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int inIndex = map.get(rootValue);
        int leftSize = inIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, inIndex + 1, inEnd);
        return root;
    }
}