public class BombEnemy_361 {

    public int maxKilledEnemies(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int max = 0;
        int[] tmp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i ++) {
            int count = 0;
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j]  == 'E') {
                    count ++;
                }

                if (grid[i][j] == 'W') {
                    for (int z = j - 1; z >= 0; z --) {
                        if (grid[i][z] == 'W') {
                            break;
                        }

                        if (grid[i][z] == '0') {
                            tmp[z] += count;
                            if (tmp[z] > max) {
                                max = tmp[z];
                            }
                        }
                    }

                    count = 0;
                }
            }

            for (int j = grid[i].length - 1; j >= 0; j --) {
                if (grid[i][j] == 'W') {
                    break;
                }

                if (grid[i][j] == '0') {
                    tmp[j] += count;
                    if (tmp[j] > max) {
                        max = tmp[j];
                    }
                }
            }
        }
        return max;
    }

}
