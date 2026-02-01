class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] bindBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            bindBoard[i] = board[i].toCharArray();
        }

        int resultCount = 0;

        while (true) {
            int count = 0;
            boolean[][] toRemove = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (
                            bindBoard[i][j] != '.' &&
                                    bindBoard[i][j] == bindBoard[i][j + 1] &&
                                    bindBoard[i][j + 1] == bindBoard[i + 1][j] &&
                                    bindBoard[i + 1][j] == bindBoard[i + 1][j + 1]
                    ) {
                        toRemove[i][j] = true;
                        toRemove[i][j + 1] = true;
                        toRemove[i + 1][j] = true;
                        toRemove[i + 1][j + 1] = true;
                    }
                }
            }

            for (int i = 0; i < toRemove.length; i++) {
                for (int j = 0; j < toRemove[i].length; j++) {
                    if (toRemove[i][j]) {
                        count++;
                        bindBoard[i][j] = '.';
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int writeIndex = m - 1;

                for (int j = m - 1; j >= 0; j--) {
                    if (bindBoard[j][i] != '.') {
                        bindBoard[writeIndex][i] = bindBoard[j][i];
                        writeIndex--;
                    }
                }

                while (writeIndex >= 0) {
                    bindBoard[writeIndex][i] = '.';
                    writeIndex--;
                }
            }

            resultCount += count;
            if (count == 0) {
                break;
            }
        }

        return resultCount;
    }
}