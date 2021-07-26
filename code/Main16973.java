package code;

import java.util.*;
import java.io.*;

public class Main16973 {
    static class xy {
        int x;
        int y;
        int count;

        public xy(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[] dx = { -1, 1, 0, 0 };// 상하좌우
    static int[] dy = { 0, 0, -1, 1 };
    static int N;
    static int M;

    static int[][] map;

    public static boolean func(int dir, int x, int y, int xf, int yf) {
        switch (dir) {
            case 0:// 상
                for (int w = y; w <= yf; w++) {
                    if (map[x][w] == 1)// 위에 줄만 본다
                        return false;
                }
                break;
            case 1:// 하
                for (int w = y; w <= yf; w++) {
                    if (map[xf][w] == 1)// 아래줄만 본다
                        return false;
                }
                break;
            case 2:// 좌
                for (int h = x; h <= xf; h++) {
                    if (map[h][y] == 1)
                        return false;
                }
                break;
            case 3:// 우
                for (int h = x; h <= xf; h++) {
                    if (map[h][yf] == 1)
                        return false;
                }
                break;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int finishX = Integer.parseInt(st.nextToken()) - 1;
        int finishY = Integer.parseInt(st.nextToken()) - 1;
        visited[startX][startY] = true;
        Queue<xy> q = new LinkedList<>();
        q.add(new xy(startX, startY, 0));

        int answer = -1;
        while (q.size() != 0) {
            xy temp = q.poll();
            // System.out.println(temp.x + " " + temp.y + " -- " + temp.count);
            if (temp.x == finishX && temp.y == finishY) {
                answer = temp.count;
                break;// 도달했다
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = temp.x + dx[dir];
                int ny = temp.y + dy[dir];
                int nxf = nx + H - 1;
                int nyf = ny + W - 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;// 시작점이 벗어나는것

                if (nxf < 0 || nxf >= N || nyf < 0 || nyf >= M)
                    continue;// 끝점이 벗어나는것

                // System.out.println(nx + " " + ny + " ~ " + nxf + " " + nyf + " " + func(dir,
                // nx, ny, nxf, nyf));
                if (visited[nx][ny] != true && func(dir, nx, ny, nxf, nyf) == true) {
                    visited[nx][ny] = true;// 방문 체크를 여기서 한다
                    q.add(new xy(nx, ny, temp.count + 1));// 방문한적없고 벽없는곳
                }
            }
        }

        System.out.println(answer);
    }
}
