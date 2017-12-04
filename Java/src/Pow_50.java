/**
 * 没有难度，但是容易掉进了一堆坑
 * 坑1：需要考虑n为负数
 * 坑2：需要考虑当结果精度超出double范围就不需要再算啦
 * 坑3：与166一样的老坑，用abs的时候记得溢出的问题
 * 坑4：-1的特殊处理
 */

public class Pow_50 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (x == -1) {
            return n%2 == 0 ? 1 : -1;
        }

        double r = 1;
        int p = n;
        if (n < 0) {
            while (p < 0) {
                double tmp = r / x;
                if (r == tmp) {
                    break;
                }
                r = tmp;
                p ++;
            }
        } else {
            while ( p > 0 ) {
                double tmp = r * x;
                if (r == tmp) {
                    break;
                }
                r = tmp;
                p --;
            }
        }
        return  r;
    }

}
