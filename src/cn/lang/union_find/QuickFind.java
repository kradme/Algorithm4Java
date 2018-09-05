package cn.lang.union_find;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QuickFind extends AbsUnionFind{
	
	public QuickFind(int N) {
		this.count=N;
		this.id=new int[N];
		for(int i=0;i<N;i++) {
			id[i]=i;
		}
	}

	@Override
	public void Union(int p, int q) {
		int val = id[p];
		int targetVal = id[q];
		if(val==targetVal) {
			return;
		}
		for(int i=0;i<id.length;i++) {
			if(id[i]==targetVal) {
				id[i]=val;
			}
		}
		count--;
		
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("D:\\OneDriver\\OneDrive\\algs4-data\\tinyUF.txt")));
		String line = null;
		int N = Integer.valueOf(br.readLine());
		IUnionFind uf = new QuickFind(N);
		int i=0;
		while((line=br.readLine())!=null) {
			if(i!=0) {
				String[] words = line.split(" ");
				int p = Integer.valueOf(words[0]);
				int q = Integer.valueOf(words[1]);
				if(uf.connected(p, q)) {
					continue;
				}
				System.out.println(p+" "+q);
				uf.Union(p, q);
				
			}
			i++;
		}
		System.out.println(uf.toString());
		System.out.println(uf.count()+"components");
	}
}
