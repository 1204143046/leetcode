package com.ls.basic.tree;

/**
 * ÊÇ·ñÊÇËÑË÷¶þ²æÊ÷
 * @author l20095
 *
 */
public class IsBST {

	public static void main(String[] args) {
		TreeNode head = buildIsBST();
		System.out.println("isBST  " +isBST(head, 0).isBST);
		TreeNode root = buildNotBST();
		System.out.println("not BST  " + isBST(root,0).isBST);
	}

	private static ReturnType isBST(TreeNode head, int h) {
		if(head == null){
			return new ReturnType(true, 0);
		}
		
		ReturnType left = isBST(head.left, h + 1);
		ReturnType right = isBST(head.right, h + 1);
		if(left.isBST && right.isBST && Math.abs(left.height - right.height) <= 1){
			return new ReturnType(true, Math.max(left.height, right.height) + 1);
		}
		return new ReturnType(false, Math.max(left.height, right.height));
	}

	private static class ReturnType{
		public boolean isBST;
		public int height;
		
		public ReturnType(boolean isBST, int h){
			this.isBST = isBST;
			this.height = h;
		}
	}
	private static TreeNode buildIsBST() {
		TreeNode root = new TreeNode(10, null, null);
		TreeNode node2 = new TreeNode(5, null, null);
		TreeNode node3 = new TreeNode(90, null, null);
		TreeNode node4 = new TreeNode(1, null, null);
		TreeNode node5 = new TreeNode(6, null, null);
		TreeNode node6 = new TreeNode(80, null, null);
		TreeNode node7 = new TreeNode(100, null, null);
		TreeNode node8 = new TreeNode(95, null, null);
		TreeNode node9 = new TreeNode(200, null, null);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.left = node8;
		node7.right = node9;
		return root;
	}
	
	private static TreeNode buildNotBST() {
		TreeNode root = new TreeNode(10, null, null);
		TreeNode node2 = new TreeNode(5, null, null);
		TreeNode node3 = new TreeNode(90, null, null);
//		TreeNode node4 = new TreeNode(1, null, null);
//		TreeNode node5 = new TreeNode(6, null, null);
		TreeNode node6 = new TreeNode(80, null, null);
		TreeNode node7 = new TreeNode(100, null, null);
		TreeNode node8 = new TreeNode(95, null, null);
		TreeNode node9 = new TreeNode(200, null, null);
		
		root.left = node2;
		root.right = node3;
//		node2.left = node4;
//		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.left = node8;
		node7.right = node9;
		return root;
	}
}
