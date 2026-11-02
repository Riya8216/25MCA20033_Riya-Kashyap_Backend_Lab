class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<>());
        return ans;
    }
    void dfs(TreeNode root,int target,List<Integer>path){
        if(root==null)return;
        path.add(root.val);
        target-=root.val;
        if(root.left==null&&root.right==null&&target==0){
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left,target,path);
        dfs(root.right,target,path);
        path.remove(path.size()-1);
    }
}
