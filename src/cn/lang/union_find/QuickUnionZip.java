package cn.lang.union_find;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 压缩路径
 * @author Lang
 *
 */
public class QuickUnionZip extends AbsUnionFind{
	
	//D:\OneDriver\OneDrive\algs4-data\tinyUF.txt
	public static void main(String[] args) {
		BufferedReader br = null;
		long start = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader(new File("D:\\OneDriver\\OneDrive\\algs4-data\\largeUF.txt")));
			String line = null;
			int N = Integer.valueOf(br.readLine());
			IUnionFind uf = new QuickUnionZip(N);
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
//			System.out.println(uf.toString());
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
	
	public QuickUnionZip(int N) {
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
		this.refresh(p, rootQ);
		count--;
//		System.out.println(toString());
//		System.out.println(rootString());
	}

	@Override
	public int find(int p) {
		int root = p;
		while(root!=id[root]) {
			root=id[root];
		}
		return root;
	}
	
	public void refresh(int p, int val) {
		while(p!=id[p]) {
			int tmp = id[p];
			id[p]=val;
			p=tmp;
		} 
	}
	
	
}
