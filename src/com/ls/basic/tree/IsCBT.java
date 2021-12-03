package com.ls.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ÊÇ·ñÊÇÂú¶þ²æÊ÷
 * @author l20095
 *
 */
public class IsCBT {

	public static void main(String[] args) {
		TreeNode root = buildCBT();
		System.out.println();
		System.out.println("is cbt  " + isCBT(root));
		TreeNode head = buildNotLeftLeafCBT();
		System.out.println("has right node but don't have left node  " + isCBT(head));
		
		TreeNode head2 = buildNotLeafCBT();
		System.out.println("gather one after leaf  " + isCBT(head2));
	}

	private static boolean isCBT(TreeNode root) {
		boolean notExistLeaf = false;
		if(root != null){
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode node = queue.poll();
				System.out.print(node.val + "\t");
				
				if(node.left == null && node.right != null){
					return false;
				}
				if(notExistLeaf && (node.left != null || node.right != null)){
					return false;
				}
				
				if(node.left != null){
					queue.add(node.left);
				}else{
					notExistLeaf = true;
				}
				if(node.right != null){
					queue.add((node.right));
				}else{
					notExistLeaf = true;
				}
				
				
				
			}
			return true;
		}
		return false;
	}
	
	
	private static TreeNode buildNotLeftLeafCBT() {
		TreeNode root = new TreeNode(1, null, null);
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node6 = new TreeNode(6, null, null);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
//		node3.left = node6;
		node3.right = node6;
		return root;
	}
	
	private static TreeNode buildNotLeafCBT() {
		TreeNode root = new TreeNode(1, null, null);
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node6 = new TreeNode(6, null, null);
		TreeNode node7 = new TreeNode(7, null, null);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node4.left = node7;
		return root;
	}

	private static TreeNode buildCBT() {
		TreeNode root = new TreeNode(1, null, null);
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node6 = new TreeNode(6, null, null);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
//		node3.right = node6;
		return root;
	}
}
