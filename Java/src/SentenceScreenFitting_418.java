public class SentenceScreenFitting_418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int index = 0;
        int leftCount = cols;
        while (rows > 0) {
            if (leftCount != cols) leftCount --;
            leftCount -= sentence[index].length();
            if (leftCount >= 0) {
                index ++;
                if (index == sentence.length) {
                    count ++;
                    index = 0;
                }
            } else {
                rows --;
                leftCount = cols;
            }
        }
        return  count;
    }
}
