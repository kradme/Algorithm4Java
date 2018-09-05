package cn.lang.union_find;

public abstract class AbsUnionFind implements IUnionFind{
	/**
	 * 分量的id
	 */
	protected int[] id;
	/**
	 * 分量的数量
	 */
	protected int count;
	
	

	@Override
	public boolean connected(int p, int q) {
		return this.find(p)==this.find(q);
	}

	@Override
	public int count() {
		return count;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<id.length;i++) {
			sb.append("["+id[i]+"],");
		}
		return sb.toString();
	}
	
	public String rootString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<id.length;i++) {
			sb.append("["+find(i)+"],");
		}
		return sb.toString();
	}

}
