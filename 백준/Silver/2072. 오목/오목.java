import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static class Coor {
        public int x;
        public int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[20][20];

        for (int y = 1; y < 20; y++) {
            for (int x = 1; x < 20; x++) {
                board[y][x] = 2;
            }
        }

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[y][x] = i % 2;

            if (vertBfs(board, x, y) == 5) {
                System.out.print(i + 1);
                return;
            }

            if (horiBfs(board, x, y) == 5) {
                System.out.print(i + 1);
                return;
            }

            if (diagBfs(board, x, y) == 5) {
                System.out.print(i + 1);
                return;
            }

            if (reverseDiagBfs(board, x, y) == 5) {
                System.out.print(i + 1);
                return;
            }
        }

        System.out.print(-1);
    }

    public static int vertBfs(int[][] board, int startX, int startY) {
        int myStone = board[startY][startX];
        int stones = 0;
        Set<String> visited = new HashSet<>();
        visited.add(startX + "/" + startY);
        Deque<Coor> deque = new ArrayDeque<>();
        deque.addLast(new Coor(startX, startY));

        while (!deque.isEmpty()) {
            Coor lastCoor = deque.pollFirst();
            
            if (board[lastCoor.y][lastCoor.x] == myStone) {
                stones += 1;
            } else {
                continue;
            }

            int nextX = lastCoor.x - 1;
            String coorString = nextX + "/" + startY;

            if (nextX >= 1 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(nextX, startY));
            }

            nextX = lastCoor.x + 1;
            coorString = nextX + "/" + startY;

            if (nextX <= 19 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(nextX, startY));
            }
        }

        return stones;
    }

    public static int horiBfs(int[][] board, int startX, int startY) {
        int myStone = board[startY][startX];
        int stones = 0;
        Set<String> visited = new HashSet<>();
        visited.add(startX + "/" + startY);
        Deque<Coor> deque = new ArrayDeque<>();
        deque.addLast(new Coor(startX, startY));

        while (!deque.isEmpty()) {
            Coor lastCoor = deque.pollFirst();
            
            if (board[lastCoor.y][lastCoor.x] == myStone) {
                stones += 1;
            } else {
                continue;
            }

            int nextY = lastCoor.y - 1;
            String coorString = startX + "/" + nextY;

            if (nextY >= 1 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(startX, nextY));
            }

            nextY = lastCoor.y + 1;
            coorString = startX + "/" + nextY;

            if (nextY <= 19 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(startX, nextY));
            }
        }

        return stones;
    }

    public static int diagBfs(int[][] board, int startX, int startY) {
        int myStone = board[startY][startX];
        int stones = 0;
        Set<String> visited = new HashSet<>();
        visited.add(startX + "/" + startY);
        Deque<Coor> deque = new ArrayDeque<>();
        deque.addLast(new Coor(startX, startY));

        while (!deque.isEmpty()) {
            Coor lastCoor = deque.pollFirst();
            
            if (board[lastCoor.y][lastCoor.x] == myStone) {
                stones += 1;
            } else {
                continue;
            }

            int nextX = lastCoor.x - 1;
            int nextY = lastCoor.y - 1;
            String coorString = startX + "/" + nextY;

            if (nextY >= 1 && nextX >= 1 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(nextX, nextY));
            }

            nextX = lastCoor.x + 1;
            nextY = lastCoor.y + 1;
            coorString = startX + "/" + nextY;

            if (nextY <= 19 && nextX <= 19 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(nextX, nextY));
            }
        }

        return stones;
    }

    public static int reverseDiagBfs(int[][] board, int startX, int startY) {
        int myStone = board[startY][startX];
        int stones = 0;
        Set<String> visited = new HashSet<>();
        visited.add(startX + "/" + startY);
        Deque<Coor> deque = new ArrayDeque<>();
        deque.addLast(new Coor(startX, startY));

        while (!deque.isEmpty()) {
            Coor lastCoor = deque.pollFirst();
            
            if (board[lastCoor.y][lastCoor.x] == myStone) {
                stones += 1;
            } else {
                continue;
            }

            int nextX = lastCoor.x + 1;
            int nextY = lastCoor.y - 1;
            String coorString = startX + "/" + nextY;

            if (nextY >= 1 && nextX <= 19 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(nextX, nextY));
            }

            nextX = lastCoor.x - 1;
            nextY = lastCoor.y + 1;
            coorString = startX + "/" + nextY;

            if (nextY <= 19 && nextX >= 1 && !visited.contains(coorString)) {
                visited.add(coorString);
                deque.addLast(new Coor(nextX, nextY));
            }
        }

        return stones;
    }
}
