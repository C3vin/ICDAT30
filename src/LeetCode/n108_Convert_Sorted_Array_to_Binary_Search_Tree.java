package LeetCode;

public class n108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length-1);
	}
	private TreeNode helper(int[] nums, int low, int high) {
		if(low > high)
			return null;
		int mid = (low + high) / 2;
		TreeNode bst = new TreeNode(nums[mid]);
		bst.left = helper(nums, low, mid-1);			//bst.left
		bst.right = helper(nums, mid+1, high);			//bst.right
		
		return bst;
	}
	public static void main(String[] args) {
		n108_Convert_Sorted_Array_to_Binary_Search_Tree obj = new n108_Convert_Sorted_Array_to_Binary_Search_Tree();
		int[] nums = {1,2,3,4,5,6,7};
		System.out.println(obj.sortedArrayToBST(nums));
	}
}
