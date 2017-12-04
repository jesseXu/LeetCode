import java.util.HashMap;

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
