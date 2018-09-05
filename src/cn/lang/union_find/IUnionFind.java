package cn.lang.union_find;

public interface IUnionFind {
	/**
	 * 连接p、q
	 * @param p
	 * @param q
	 */
	void Union(int p, int q);
	/**
	 * p(0到N-1)所在的分量的标识
	 * @param p
	 * @return
	 */
	int find(int p);
	/**
	 * 判断是否连接
	 * @param p
	 * @param q
	 * @return
	 */
	boolean connected(int p, int q);
	/**
	 * 连通分量的数量
	 * @return
	 */
	int count();
}
