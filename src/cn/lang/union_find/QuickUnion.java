package cn.lang.union_find;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickUnion extends AbsUnionFind{
	
	public QuickUnion(int N) {
		this.count=N;
		this.id=new int[N];
		for(int i=0;i<N;i++) {
			id[i]=i;
		}
	}

	@Override
	public void Union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP==rootQ) {
			return;
		}
		id[rootP]=rootQ;
		count--;
	}

	@Override
	public int find(int p) {
		while(p!=id[p]) {
			p=id[p];
		}
		return p;
	}
	
	public static void main(String[] args) {
		BufferedReader br = null;
		long start = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader(new File("D:\\OneDriver\\OneDrive\\algs4-data\\largeUF.txt")));
			String line = null;
			int N = Integer.valueOf(br.readLine());
			IUnionFind uf = new QuickUnion(N);
			int i=0;
			while((line=br.readLine())!=null) {
				if(i!=0) {
					String[] words = line.split(" ");
					int p = Integer.valueOf(words[0]);
					int q = Integer.valueOf(words[1]);
					if(uf.connected(p, q)) {
						continue;
					}
//					System.out.println(p+" "+q);
					uf.Union(p, q);
					
				}
				i++;
			}
			System.out.println(uf.toString());
			System.out.println(uf.count()+"components");
			System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
