package study.August.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BJ_4358_생태학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		
		int cnt = 0;
		String tree = br.readLine();
		while(true) {
			cnt++;
			hashMap.put(tree,hashMap.getOrDefault(tree, 0) + 1);
			tree = br.readLine();
			if(tree == null || tree.length() == 0) break;
		}//입력 끝
		
		ArrayList<Tree> trees = new ArrayList<Tree>();
		for(String treename : hashMap.keySet()) {
			Tree t = new Tree();
			t.name = treename;
			t.rate = hashMap.get(treename);
			trees.add(t);
		}
		
		Collections.sort(trees,(o1,o2)->{
			return o1.name.compareTo(o2.name);
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Tree t: trees) {
			sb.append(t.name).append(" ");
			sb.append(String.format("%.4f",(double)t.rate/cnt*100)).append("\n");
		}
		
		System.out.println(sb.toString());
		
	
	}
	private static class Tree{
		String name;
		int rate;
		
	}
}
