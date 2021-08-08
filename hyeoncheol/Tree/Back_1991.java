package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Back_1991 {
	static HashMap<String, ArrayList<String>> hm = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> tmp = new ArrayList<String>();
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();

			tmp.add(b);
			tmp.add(c);
			hm.put(a, tmp);
		}

		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");

	}

	private static void preorder(String s) {
		if (s.equals("."))
			return;

		System.out.print(s);
		preorder(hm.get(s).get(0));
		preorder(hm.get(s).get(1));
	}

	private static void inorder(String s) {
		if (s.equals("."))
			return;

		inorder(hm.get(s).get(0));
		System.out.print(s);
		inorder(hm.get(s).get(1));
	}

	private static void postorder(String s) {
		if (s.equals("."))
			return;

		postorder(hm.get(s).get(0));
		postorder(hm.get(s).get(1));
		System.out.print(s);
	}
}
