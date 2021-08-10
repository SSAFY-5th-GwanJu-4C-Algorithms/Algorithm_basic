package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_5639 {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String tmp;
		
		while((tmp = br.readLine()) != null) {
			Node next = new Node(Integer.parseInt(tmp));
			Insert(root,next);
		}
		
		postOrder(root);
		System.out.println(sb);
	}
	
	private static void postOrder(Node root) {
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		sb.append(root.num+"\n");
	}

	private static void Insert(Node root, Node next) {
		if(next.num<root.num) {
			if(root.left !=null) {
				Insert(root.left, next);
			}else {
				root.left = next;
			}
		}else {
			if(root.right != null) {
				Insert(root.right, next);
			}else {
				root.right = next;
			}
		}
	}

	static class Node{
		int num;
		Node left;
		Node right;
		public Node(int num) {
			this.num = num;
		}
	}
}
