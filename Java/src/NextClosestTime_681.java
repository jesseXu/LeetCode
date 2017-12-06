import java.util.Arrays;
import java.util.HashSet;

public class NextClosestTime_681 {

    public String nextClosestTime(String time) {
        int[] a = new int[4];
        HashSet<Integer> set = new HashSet<>();
        set.add(a[0] = time.charAt(0) - '0');
        set.add(a[1] = time.charAt(1) - '0');
        set.add(a[2] = time.charAt(3) - '0');
        set.add(a[3] = time.charAt(4) - '0');

        Integer[] array = set.toArray(new Integer[0]);
        Arrays.sort(array);

        //循环所有分位可能，如果有大于输入的时间，并且小于60，返回时间
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] * 10 + array[j] < 60 && array[i] * 10 + array[j] > a[2] * 10 + a[3]) {
                    return "" + a[0] + a[1] + ":" + array[i] + array[j];
                }
            }
        }

        //对于小时也一样处理
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] * 10 + array[j] < 24 && array[i] * 10 + array[j] > a[0] * 10 + a[1]) {
                    return "" + array[i] + array[j] + ":" + array[0] + array[0];
                }
            }
        }

        //如果没有就用最小数生成
        return "" + array[0] + array[0] + ":" + array[0] + array[0];
    }
}
