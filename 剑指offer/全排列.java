import java.util.LinkedList;
import java.util.List;

public class Permutation {
	
	public static void getPermutation(List<String> res, int[] arr, int start, int end) {
		if(start == end) {
			StringBuilder sb = new StringBuilder();
			int len = arr.length;
			for(int i=0; i<len; i++)
				sb.append(arr[i]);
			res.add(sb.toString());
		}
		
		for(int i=start; i<=end; i++) {
			swap(arr, start, i);
			getPermutation(res, arr, start+1, end);
			swap(arr, start, i);
		}
	}
	
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4};
		List<String> res = new LinkedList<String>();
		int len = arr.length;
		getPermutation(res, arr, 0, len - 1);
		for(String s: res) {
			System.out.println(s);
		}
	}

}
