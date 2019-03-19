import java.util.LinkedList;
import java.util.Queue;


public class Test {
	
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if(end <= start)
			return ;
		
		int p = arr[start];
		int i = start;
		int j = end;
		
		while(i != j) {
			while(arr[j] >= p && j != i) // 让j先走
				j--;
			while(arr[i] <= p && i != j) // i后走
				i ++;
			swap(arr, i, j);
		}
		
		swap(arr, start, i); // 基准数归位
		
		quickSort(arr, start, i - 1); // 左边和右边递归quickSort
		quickSort(arr, i + 1, end);
		
	}

	public static void main(String[] args) {
		int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		
		quickSort(arr, 0, arr.length - 1);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");

	}

}
