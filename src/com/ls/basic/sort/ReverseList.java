package com.ls.basic.sort;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {

	public static void main(String[] args) {
		Node head = buildNodeList(3);
		printNode(head);
		/*Node newList = reverseList(head);
		printNode(newList);*/
		printNode(reverseList2(head));
	}

	private static Node reverseList(Node head) {
		if(head.next == null){
			return head;
		}
		Node last = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return last;
		
	}

	private static Node reverseList2(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node pre = null;
		Node next = null;
		
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		
		return pre;
	}
	/**
	 * 翻转前N个节点
	 * @param head
	 * @param n
	 * @return
	 */
	private static Node reverseN(Node head, int n){
		return null;
	}
	
	/**
	 * 翻转m到n直接的节点
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	private static Node reverseBetweenMN(Node head, int m, int n){
		return null;
	}
	private static void printNode(Node head) {
		while(head != null){
			System.out.print(head.getVal() + "\t");
			head = head.getNext();
		}
		System.out.println();
	}

	private static Node buildNodeList(int size) {
		List<Node> nodeList = new ArrayList<Node>();
		for(int i = 0; i < size; i++){
			Node node = new Node(i + 1, null);
			nodeList.add(node);
		}
		for(int i = 0; i < size - 1; i++){
			nodeList.get(i).setNext(nodeList.get(i + 1));
		}
		nodeList.get(size - 1).setNext(null);
//		Node node3 = new Node(3, null);
//		Node node2 = new Node(2, node3);
//		Node node1 = new Node(1, node2);
		return nodeList.get(0);
	}
}

class Node{
	public int val;
	public Node next;
	
	
	public int getVal() {
		return val;
	}


	public void setVal(int val) {
		this.val = val;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}


	public Node(int val, Node node){
		this.val = val;
		this.next = node;
	}
}
