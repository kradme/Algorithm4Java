package cn.lang.sort.merge;
/**
 * 自底向上的归并排序
 * @author Lang
 *
 */
public class MergeSortBottom2Top extends AbsMergeSort{
	
	public static void main(String[] args) {
		AbsMergeSort sort = new MergeSortBottom2Top();
		Integer[] aa = new Integer[] {1,5,3,2,5,7,1,5,2,0,6,12,7,2345,2356,56};
		sort.sort(aa);
		System.out.println(show(aa));
	}

	@Override
	public void sort(Comparable<?>[] aa) {
		aux = new Comparable<?>[aa.length];
		for(int size=1;size<=aa.length;size *= 2) {
			for(int i=0;i<aa.length;i += size+size) {
				merge(aa, i,i+size-1, Math.min(i+size+size-1, aa.length-1));
			}
		}
	}

}
