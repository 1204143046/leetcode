package com.ls.basic.tree;

import java.util.Stack;

public class PrintTree {

	public static void main(String[] args) {
		TreeNode root = buildTree();
		System.out.println("all");
		allPrintTree(root);
		System.out.println("\npre");
		prePrintTree(root);
		System.out.println("\npre by stack");
		prePrintTreeByStack(root);
		System.out.println("\nin");
		inPrintTree(root);
		System.out.println("\nin by stack");
		inPrintTreeByStack(root);
		System.out.println("\npost");
		postPrintTree(root);
		System.out.println("\npost by stack");
		postPrintTreeByStack(root);
		System.out.println();
	}

	private static void postPrintTreeByStack(TreeNode root) {
		if(root != null){
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			s1.push(root);
			while(!s1.isEmpty()){
				TreeNode head = s1.pop();
				s2.add(head);
				if(head.left != null){
					s1.push(head.left);
				}
				if(head.right != null){
					s1.push(head.right);
				}
			}
			while(!s2.isEmpty()){
				System.out.print(s2.pop().val + "\t");
			}
		}
		
	}

	private static void inPrintTreeByStack(TreeNode root) {
		if(root != null){
			Stack<TreeNode> s = new Stack<TreeNode>();
			TreeNode head = root;
			while(!s.isEmpty() || head != null){
				if(head != null){
					s.push(head);
					head = head.left;
				}else{
					head = s.pop();
					System.out.print(head.val + "\t");
					head = head.right;
				}
			}
		}
		
		
	}

	private static void postPrintTree(TreeNode root) {
		if(root == null){
			return;
		}
		postPrintTree(root.left);
		postPrintTree(root.right);
		System.out.print(root.val + "\t");
	}

	private static void inPrintTree(TreeNode root) {
		if(root == null){
			return ;
		}
		inPrintTree(root.left);
		System.out.print(root.val + "\t");
		inPrintTree(root.right);
	}

	private static void prePrintTree(TreeNode root) {
		if(root == null){
			return;
		}
		System.out.print(root.val + "\t");
		prePrintTree(root.left);
		prePrintTree(root.right);
	}

	private static void prePrintTreeByStack(TreeNode root){
		if(root == null){
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.add(root);
		while(!s.isEmpty()){
			TreeNode node = s.pop();
			System.out.print(node.val +"\t");
			if(node.right != null){
				s.add(node.right);				
			}
			if(node.left != null){
				s.add(node.left);				
			}
		}
	}
	private static void allPrintTree(TreeNode root) {
		if(root == null){
			return ;
		}
		System.out.print(root.val + "\t");
		allPrintTree(root.left);
		System.out.print(root.val + "\t");
		allPrintTree(root.right);
		System.out.print(root.val + "\t");
	}

	private static TreeNode buildTree() {
		TreeNode root = new TreeNode(1, null, null);
		TreeNode node2 = new TreeNode(2,null, null);
		TreeNode node3 = new TreeNode(3,null, null);
		TreeNode node4 = new TreeNode(4,null, null);
		TreeNode node5 = new TreeNode(5,null, null);
		TreeNode node6 = new TreeNode(6,null, null);
		TreeNode node7 = new TreeNode(7,null, null);
		TreeNode node8 = new TreeNode(8,null, null);
		TreeNode node9 = new TreeNode(9,null, null);
		TreeNode node10 = new TreeNode(10,null, null);
		TreeNode node11 = new TreeNode(11,null, null);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node8;
		node3.right = node9;
		node5.left = node6;
		node6.left = node7;
		node8.right = node10;
		node10.left = node11;
		return root;
	}
	
}


class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
	
}
