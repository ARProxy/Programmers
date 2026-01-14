import java.io.*;
import java.util.*;

public class Main {

    static int[] direction = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        var stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int rowSize = Integer.parseInt(stringTokenizer.nextToken());
        int columnSize = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int currentRow = Integer.parseInt(stringTokenizer.nextToken());
        int currentColumn = Integer.parseInt(stringTokenizer.nextToken());
        int currentDirection = Integer.parseInt(stringTokenizer.nextToken());

        var room = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < columnSize; j++) {
                room[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int cleanedCount = 0;

        while (true) {
            // 현재 칸 청소
            if (room[currentRow][currentColumn] == 0) {
                room[currentRow][currentColumn] = 2;
                cleanedCount++;
            }

            // 주변 4칸 확인
            boolean hasUncleanedCell = false;
            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + direction[i];
                int nextColumn = currentColumn + direction[(i + 1) % 4];

                if (room[nextRow][nextColumn] == 0) {
                    hasUncleanedCell = true;
                    break;
                }
            }

            // 청소할 곳 없음 > 후진 시도
            if (!hasUncleanedCell) {
                int backRow = currentRow - direction[currentDirection];
                int backColumn = currentColumn - direction[(currentDirection + 1) % 4];

                if (room[backRow][backColumn] == 1) {
                    break;  // 후진 불가 > 종료
                } else {
                    currentRow = backRow;
                    currentColumn = backColumn;
                }
            }
            // 청소할 곳 있음 > 회전 후 전진 시도
            else {
                currentDirection = (currentDirection + 3) % 4;

                int frontRow = currentRow + direction[currentDirection];
                int frontColumn = currentColumn + direction[(currentDirection + 1) % 4];

                if (room[frontRow][frontColumn] == 0) {
                    currentRow = frontRow;
                    currentColumn = frontColumn;
                }
            }
        }

        System.out.println(cleanedCount);
    }
}