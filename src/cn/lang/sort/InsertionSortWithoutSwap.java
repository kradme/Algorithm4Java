package cn.lang.sort;

/**
 * 插入排序
 * @author Lang
 *
 */
public class InsertionSortWithoutSwap extends AbsSort {
	
	public static void main(String[] args) {
		Integer[] comparables = random2Sort(100);
//		Comparable<?>[] comparables = readIn("data//largeW.txt");
		AbsSort sort = new InsertionSortWithoutSwap();
		System.out.println("===============  排序开始    ===============");
		long start = System.currentTimeMillis();
		sort.sort(comparables);
		System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
		System.out.println(show(comparables));
		System.out.println("Is Sorted? : "+isSorted(comparables));
	}

	@Override
	public void sort(Comparable<?>[] aa) {
//		for(int i=1;i<aa.length;i++) {
//			for(int j=i;j>0 && less(aa[j],aa[j-1]);j--) {
////				AbsSort.animation((Integer[])aa, j,j-1);
//				exch(aa,j,j-1);
//			}
//		}
		int N = aa.length;
		for(int i=1;i<N;i++){
			Comparable<?> temp = aa[i];
			int j;
			for(j=i-1;j>=0 && less(temp, aa[j]); j--){
				aa[j+1] = aa[j];
			}
			aa[j+1] = temp;
		}

	}

}
