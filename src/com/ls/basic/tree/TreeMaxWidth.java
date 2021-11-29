package com.ls.basic.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeMaxWidth {

	public static void main(String[] args) {
		TreeNode root = buildTree();
		printTreeNodeByWidth(root);
		System.out.println(getTreeMaxWidth(root));
	}
	
	
	
	private static int getTreeMaxWidth(TreeNode root) {

		System.out.println("-----start--------");
		
		int maxWidth = Integer.MIN_VALUE;
		if(root != null){
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			int level = 1;
			int levelCount = 0;
			Map<TreeNode, Integer> nodeLevel = new HashMap<TreeNode, Integer>();
			nodeLevel.put(root, 1);
			while(!q.isEmpty()){
				TreeNode node = q.poll();
				if(nodeLevel.get(node) != level){
					level++;
					levelCount = 1;
				}else{
					levelCount++;
					maxWidth = Math.max(levelCount, maxWidth);
				}
//				System.out.print(node.val + "\t");
				if(node.left != null){
					q.add(node.left);
					nodeLevel.put(node.left, level + 1);
				}
				if(node.right != null){
					q.add(node.right);
					nodeLevel.put(node.right, level + 1);
				}
			}
		}
		
		System.out.println("----------end--------");
		return maxWidth;
		
	
	}



	private static void printTreeNodeByWidth(TreeNode root) {
		System.out.println("----------print treeNodeByWidth-------");
		
		if(root != null){
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			int maxWidth = Integer.MIN_VALUE;
			int level = 1;
			int levelCount = 0;
			Map<TreeNode, Integer> nodeLevel = new HashMap<TreeNode, Integer>();
			nodeLevel.put(root, 1);
			while(!q.isEmpty()){
				TreeNode node = q.poll();
				if(nodeLevel.get(node) != level){
					level++;
					levelCount = 0;
				}else{
					levelCount++;
					maxWidth = Math.max(levelCount, maxWidth);
				}
				System.out.print(node.val + "\t");
				if(node.left != null){
					q.add(node.left);
					nodeLevel.put(node.left, level + 1);
				}
				if(node.right != null){
					q.add(node.right);
					nodeLevel.put(node.right, level + 1);
				}
			}
		}
		System.out.println();
		
		
		
		System.out.println("----------end--------");
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
		
		
		TreeNode node12 = new TreeNode(12, null, null);
		TreeNode node13 = new TreeNode(13, null, null);
		TreeNode node14 = new TreeNode(14, null, null);
		TreeNode node15 = new TreeNode(15, null, null);
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
		
		node4.left = node12;
		node4.right = node15;
		node9.left = node13;
		node9.right = node14;
		return root;
	}
}
