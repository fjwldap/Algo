package code;

import java.util.*;
import java.io.*;

public class Main2583 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] map;
    static int N;
    static int M;
    static int num;
    static ArrayList<Integer> al;

    public static void func(int x, int y) {
        map[x][y] = 1;
        num++;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N)
                continue;

            if (map[nx][ny] == 0) {
                func(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[K][4];

        map = new int[M][N];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            arr[k][0] = Integer.parseInt(st.nextToken());
            arr[k][1] = Integer.parseInt(st.nextToken());
            arr[k][2] = Integer.parseInt(st.nextToken());
            arr[k][3] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < K; k++) {
            for (int i = arr[k][1]; i < arr[k][3]; i++) {
                for (int j = arr[k][0]; j < arr[k][2]; j++) {
                    map[i][j] = -1;
                }
            }
        }

        int count = 0;
        al = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    num = 0;
                    count++;
                    func(i, j);
                    al.add(num);
                }
            }
        }

        System.out.println(count);
        Collections.sort(al);
        for (int i = 0; i < count; i++)
            System.out.print(al.get(i) + " ");
    }
}
