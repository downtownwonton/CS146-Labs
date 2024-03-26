package lab4CS146;

public class BinaryTree {

	BinaryTree tree;
	TreeNode root;
	
	public BinaryTree()
	{
		
	}
	
	public BinaryTree(int val)
	{
		root = new TreeNode(val);
	}
	
	public void add(int val)
	{
		root = addRecursive(root, val);
	}
	
	private TreeNode addRecursive(TreeNode current, int val)
	{
		if (current == null)
		{
			return new TreeNode(val);
		}
		if (val < current.val)
		{
			current.left = addRecursive(current.left, val);
		}
		else if (val > current.val)
		{
			current.right = addRecursive(current.right, val);
		}
		else
		{
			return current;
		}
		
		return current;
	}
	
	public TreeNode invertTree(TreeNode root)
	{
		TreeNode temp;
		if (root == null) return root;
		else
		{
			temp = new TreeNode(0, root.left, root.right);
			root.left = temp;
			root.right = temp.left;
			root.left = temp.right;
			
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}
	
	public int getHeight(TreeNode root)
	{
		if (root == null) return 0;
		else
		{
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			
			if (leftHeight >= rightHeight) return (leftHeight + 1);
			else return (rightHeight + 1);
		}
	}
	
	public void printCurrentLevel(TreeNode root, int level)
	{
		if (root == null) return;
		if (level == 1) System.out.print(root.val + " ");
		else
		{
			printCurrentLevel(root.left, level - 1);
			printCurrentLevel(root.right, level - 1);
		}
	}
	
	public void levelOrderTraversal()
	{
		int h = getHeight(root);
		
		for (int i = 1; i <= h; i++)
		{
			printCurrentLevel(root, i);
		}
	}
}

