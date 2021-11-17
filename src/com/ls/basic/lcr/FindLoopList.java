package com.ls.basic.lcr;

import java.util.HashSet;
import java.util.Set;

public class FindLoopList {

	public static void main(String[] args) {
		Node head = buildLoopNodeList();
//		printNodeList(head);
		Node loopNode = loopNode2(head);
		System.out.println(loopNode == null ? null : loopNode.val);
	}

	private static Node loopNode2(Node head) {
		if(head == null || head.next == null){
			return null;
		}
		Node f = head.next;
		Node s = head;
		while(f != s && f != null &&  f.next != null && f.next.next != null){
			f = f.next.next;
			s = s.next;
		}
		if(f != s){
			//ÎÞ»·
			return null;
		}
		Node newHead = head;
		while(newHead != f.next){
			newHead = newHead.next;
			f = f.next;
		}
		return newHead;
	}

	private static Node loopNode1(Node head) {
		Set<Node> nodeSet = new HashSet<Node>();
		while(head != null){
			if(nodeSet.contains(head)){
				return head;
			}else{
				nodeSet.add(head);
			}
			
			head = head.next;
		}
		return null;
	}

	private static void printNodeList(Node head) {
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	private static Node buildLoopNodeList() {
		Node node7 = new Node(7, null);
		Node node6 = new Node(6, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		node7.next = node4;
		return node1;
	}
}

class Node{
	public  int val;
	public Node next;
	
	public Node(int val, Node node){
		this.val = val;
		this.next = node;
	}
}