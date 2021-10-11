package code;

import java.util.*;
import java.io.*;

public class Main10026 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;

    static void func(int x, int y, char C) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if (map[nx][ny] != C)
                continue;

            if (visited[nx][ny] == false) {
                visited[nx][ny] = true;
                func(nx, ny, C);
            }
        }
    }

    static void func2(int x, int y, char C) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if (C == 'R' || C == 'G') {
                if (map[nx][ny] == 'B')
                    continue;
            } else {
                if (map[nx][ny] != C)
                    continue;
            }

            if (visited2[nx][ny] == false) {
                visited2[nx][ny] = true;
                func2(nx, ny, C);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = str.charAt(j);
        }

        int count = 0;
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    func(i, j, map[i][j]);
                    count++;
                }

                if (visited2[i][j] == false) {
                    func2(i, j, map[i][j]);// 적록색약
                    count2++;
                }
            }
        }

        System.out.println(count + " " + count2);
    }
}