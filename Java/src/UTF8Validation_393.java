/**
 * 应该是需要考虑输入的是整型大于8位的
 */


public class UTF8Validation_393 {


/*  这个方案是适用多个字符的
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i ++) {
            if (count != 0) {
                count --;
                if (count < 0) return false;
                if ((data[i] & 1 << 7) != 1 << 7 || (data[i] & 1 << 6) != 0 ) {
                    return false;
                }
            } else {
                int c = 0;
                for (int j = 7; j >= 0; j --) {
                    if ((data[i] & 1 << j) == 1 << j) {
                        c ++;
                    } else {
                        break;
                    }
                }

                if (c == 1 || c > 4) {
                    return false;
                }

                if (c > 1) {
                    count = c - 1;
                }
            }
        }

        return count == 0;
    }
*/
}
