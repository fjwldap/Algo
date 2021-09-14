package code;

import java.util.*;
import java.io.*;

public class Main1520 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int M;
    static int N;
    static int[][] arr;
    static int[][] DP;

    static int func(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            DP[x][y] = 1;
            return 1;// 여기서부터 올라갈거니깐
        }

        if (DP[x][y] != -1) {// 이미 봤던 칸이면
            return DP[x][y];
        }

        DP[x][y] = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N)
                continue;

            if (arr[x][y] <= arr[nx][ny])
                continue;// 내리막길만 갈수있다

            DP[x][y] += func(nx, ny);
        }

        // System.out.println(x + " " + y + " " + DP[x][y]);
        return DP[x][y];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        DP = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = -1;
            }
        }

        func(0, 0);

        // for (int i = 0; i < M; i++)
        // System.out.println(Arrays.toString(DP[i]));

        System.out.println(DP[0][0]);

    }
}
