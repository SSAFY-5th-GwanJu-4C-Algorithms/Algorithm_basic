package study.August.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_1991_트리순회 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		Tree tree = new Tree();
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			char c = str[0].charAt(0);
			char c1 = str[1].charAt(0);
			char c2 = str[2].charAt(0);
			tree.add(c, c1, c2);
		}
		tree.preOrder(tree.Root);
		sb.append("\n");
		tree.inOrder(tree.Root);
		sb.append("\n");
		tree.postOrder(tree.Root);
		System.out.println(sb.toString());
		
	}
	
	static class Tree{
		Node Root;
		
		public void add(char now, char left, char right) {
			if(Root == null) {//처음
				if(now != '.') Root = new Node(now);
				if(left != '.') Root.left = new Node(left);
				if(right != '.') Root.right = new Node(right);
			}	
			else {
				search(Root,now,left,right);
			}
		}

		private void search(Node Root, char now, char left, char right) {
			if(Root == null) return;
			else if(Root.now == now) {
				if(left != '.') Root.left = new Node(left);
				if(right != '.') Root.right = new Node(right);
			}
			else {
				search(Root.left,now,left,right);
				search(Root.right,now,left,right);
			}
			
		}
		public void preOrder(Node Root) {
			sb.append(Root.now);
			if(Root.left != null) preOrder(Root.left);
			if(Root.right != null) preOrder(Root.right);
		}
		public void inOrder(Node Root) {
			if(Root.left != null) inOrder(Root.left);
			sb.append(Root.now);
			if(Root.right != null) inOrder(Root.right);
		}
		public void postOrder(Node Root) {
			if(Root.left != null) postOrder(Root.left);
			if(Root.right != null) postOrder(Root.right);
			sb.append(Root.now);
		}
		
	}

	static class Node{
		char now;
		Node left;
		Node right;
		public Node(char now){
			this.now = now;
		}
	}
}
