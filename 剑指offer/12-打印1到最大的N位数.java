// Algorithm 1: 利用加法, 从1加到maxNum
// 结束的标准是：最高位产生进位，此时可以停止

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	
	public static void printNums(int num) {
		if(num == 0)
			return ;
		
		char[] arr = new char[num];
		
		// init
		for(int i=0; i<num; i++)
			arr[i] = '0';
		
		while(!addOne(arr, num)) {
			myPrint(arr, num);
		}
	}

	private static void myPrint(char[] arr, int len) {
		StringBuilder sb = new StringBuilder();
		boolean hasFirst = false;
		for(int i=0; i<len; i++) {
			if(arr[i] != '0') {
				if(!hasFirst)
					hasFirst = true;
				sb.append(arr[i]);
			}
			else if(hasFirst)
				sb.append('0');		
		}
		System.out.println(sb);
	}

	private static boolean addOne(char[] arr, int len) {
		boolean isAdd = true;
		for(int i=len-1; i>=0; i--) {
			if(isAdd) {
				int temp = arr[i] - '0' + 1;
				arr[i] = (char)(temp % 10 + '0');
				if(temp / 10 != 0)
					isAdd = true;
				else
					isAdd = false;
			}
			if(i == 0 && isAdd) // 如果是最后一个进位的话，表示结束，已经达到最大了
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		printNums(3);

	}

}


// Algorithm 2: 递归, 排列的思想, 比较简洁

public class PrintMaxNum {
	
	public static void printMax(int[] arr, int start, int end) {
		if(start > end) {
			StringBuilder sb = new StringBuilder();
			int len = arr.length;
			boolean hasStart = false;
			for(int i=0; i<len; i++) {
				if(arr[i] != 0 && !hasStart)
					hasStart = true;
				if(hasStart) {
					sb.append(arr[i]);
				}
			}
			if(!sb.toString().equals("")) 
				System.out.println(sb.toString());
			
			return;
		}
		
		for(int i=0; i<10; i++) {
			arr[start] = i;
			printMax(arr, start + 1, end);
		}
	}
	
	
	public static void main(String[] args) {
		int num = 3;
		int[] arr = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = 0;
		printMax(arr, 0, num - 1);
	}

}
