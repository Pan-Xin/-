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
