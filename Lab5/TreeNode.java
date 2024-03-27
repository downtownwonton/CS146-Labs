package lab5CS146;

import java.util.Random;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode()
	{
		
	}
	
	public TreeNode(int val)
	{
		this.val = val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static void main(String[] args)
	{
		
		BinaryTree tree = new BinaryTree();
		Random rand = new Random();
		
		int randomInt = rand.nextInt(70);
		
		tree.root = new TreeNode(randomInt);
		
		for (int i = 0; i <= 5; i++)
		{
			 randomInt = rand.nextInt(70);
			 System.out.println("Adding: " + randomInt);
			 tree.add(randomInt);
		}
		
		System.out.println("Root is " + tree.root.val);
		
		tree.levelOrderTraversal();
		
		System.out.println(tree.isValidBST(tree.root));
		
		tree.invertTree(tree.root);
		tree.levelOrderTraversal();
		
		System.out.println(tree.isValidBST(tree.root));
		
		
	}
}

