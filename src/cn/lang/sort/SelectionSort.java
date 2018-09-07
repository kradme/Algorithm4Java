package cn.lang.sort;

/**
 * 选择排序
 * @author Lang
 *
 */
public class SelectionSort extends AbsSort{
	
	public static void main(String[] args) {
		Integer[] comparables = random2Sort(100);
//		Comparable<?>[] comparables = readIn("data//words3.txt");
		AbsSort sort = new SelectionSort();
		sort.sort(comparables);
		System.out.println(show(comparables));
		System.out.println("Is Sorted? : "+isSorted(comparables));
	}

	@Override
	public void sort(Comparable<?>[] comparables) {
//		StdDraw.setCanvasSize(800, 300);
		for(int i=0;i<comparables.length;i++) {
			int min = i;
			for(int j=i;j<comparables.length;j++) {
				if(!less(comparables[min], comparables[j])) {
					min=j;
				}
			}
			exch(comparables, i, min);
//			AbsSort.animation((Integer[])comparables, i, min);
		}
		
	}

}
