// Sol 1:
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	StringBuilder sb = new StringBuilder();
        int len = str.length();
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(ch == ' ')
                sb.append("%20");
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}
// Time: O(n)

// Sol 2:
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	// 用书上的思路写一哈
        int len = str.length();
        int cont = 0;
        for(int i=0; i<len; i++){
            if(str.charAt(i) == ' ')
                cont ++;
        }
        cont *= 2;
        char[] arr = new char[len + cont];
        int p2 = len + cont - 1;
        int p1 = len - 1;
        while(p1 >= 0){
            char ch = str.charAt(p1);
            if(ch != ' ' && p2 >= p1){
                arr[p2] = ch;
                p2 --;
                p1 --;
            }
            else{
                arr[p2] = '0';
                arr[p2 - 1] = '2';
                arr[p2 - 2] = '%';
                p2 -= 3;
                p1 --;
            }
        }
        
        return new String(arr);
    }
}
// Time: O(n)
// Space: O(n)