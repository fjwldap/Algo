package code;

import java.util.*;
import java.io.*;

public class Main18405 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Virus {
        int v;
        int x;
        int y;
        int time;

        public Virus(int v, int x, int y, int time) {
            this.v = v;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Virus> q = new PriorityQueue<Virus>(new Comparator<Virus>() {
            public int compare(Virus v1, Virus v2) {
                if (v1.time == v2.time)
                    return v1.v - v2.v;// 같은것 중에서는 바이러스 번호 빠른 순
                else
                    return v1.time - v2.time;// 시간이 이른게 우선
            }
        });

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0)
                    q.add(new Virus(map[i][j], i, j, 0));
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        while (q.size() != 0) {
            Virus virus = q.poll();
            int x = virus.x;
            int y = virus.y;
            // System.out.println(x + " " + y + " : " + virus.v + " " + virus.time);
            if (virus.time > S)
                break;// 시간보다 커지면

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (map[nx][ny] != 0)
                    continue;// 이미 바이러스가 있는 칸

                if (virus.time + 1 <= S)
                    map[nx][ny] = virus.v;
                q.add(new Virus(virus.v, nx, ny, virus.time + 1));
            }
        }

        // for (int i = 0; i < N; i++)
        // System.out.println(Arrays.toString(map[i]));

        System.out.println(map[X - 1][Y - 1]);
    }

}
