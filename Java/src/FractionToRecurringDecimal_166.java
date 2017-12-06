import java.util.HashMap;

/**
 *  坑1：abs一个Int负数就overflow了，因为负的range比正数多1，所以要变成long来处理
 *  坑2：要在abs之前转成long！！
 */

public class FractionToRecurringDecimal_166 {

    public String fractionToDecimal(int numerator, int denominator) {

        // 除数为0
        if (denominator == 0) {
            return "NaN";
        }

        // 被除数为0
        if (numerator == 0) {
            return  "0";
        }

        StringBuilder result = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append('-');
        }

        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        result.append(n/d);

        // 如果整除直接返回结果
        long r = n % d;
        if (r == 0) {
            return result.toString();
        } else {
            result.append('.');
        }

        // 模拟除法
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (r != 0) {
            if (map.containsKey(r)) {
                result.insert(map.get(r).intValue(), '(');
                result.append(')');
                break;
            }
            map.put(r, result.length());
            r *= 10;
            result.append(r/d);
            r %= d;
        }

        return result.toString();
    }

}
