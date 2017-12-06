public class LongestAbsoluteFilePath_388 {

    public int lengthLongestPath(String input) {

        String[] paths = input.split("\n");

        int maxLength = 0;
        int[] array = new int[paths.length + 1];
        array[0] = 0;
        for(String path: paths) {
            int lev = path.lastIndexOf("\t") + 1;
            int c = (lev > 0 ? array[lev - 1] : 0) + path.length() - lev + (lev > 0 ? 1 : 0);
            if (path.contains(".") && maxLength < c) {
                maxLength = c;
            } else {
                array[lev] = c;
            }
        }

        return maxLength;
    }

}