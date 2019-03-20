public class Solution {
    public double Power(double base, int exponent) {
        Boolean isNeg = false; // 要注意对参数范围的处理
        if(exponent == 0)
            return 1;
        else if(exponent < 0){
            isNeg = true;
            exponent *= -1;
        }
        
        double res = getRes(base, exponent);
        if(isNeg)
            res = 1 / res;
        
        return res;
  }
    
    public double getRes(double base, int e){
        if(e == 1)
            return base;
        int mid = e / 2;
        if(e % 2 == 0){
            double temp = getRes(base, mid);
            return temp * temp;
        }
        else{
            double temp = getRes(base, mid + 1);
            return temp * temp / base;
        }
    }
}

// Time: O(logn)