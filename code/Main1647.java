package code;

import java.util.*;
import java.io.*;

public class Main1647 {
    static class Road {
        int s;
        int f;
        int w;

        public Road(int s, int f, int w) {
            this.s = s;
            this.f = f;
            this.w = w;
        }
    }

    static int[] parent;
    static int weight;
    static PriorityQueue<Integer> list;

    static int getParent(int a) {
        if (a != parent[a])
            parent[a] = getParent(parent[a]);

        return parent[a];
    }

    static void union(int a, int b, int w) {
        // System.out.println(a + " " + b);
        int pa = getParent(a);
        int pb = getParent(b);

        if (pa == pb)
            return;

        if (pa < pb) {// 둘중 작은것을 부모로
            // parent[b] = pa;
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
            // parent[a] = pb;
        }

        // System.out.println(Arrays.toString(parent));
        weight += w;
        list.add(w);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 집 개수
        int M = Integer.parseInt(st.nextToken());// 길 개수
        PriorityQueue<Road> pq = new PriorityQueue<>(new Comparator<Road>() {
            public int compare(Road r1, Road r2) {
                return r1.w - r2.w;
            }
        });// 유지비가 작은 순으로 정렬

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Road(a, b, c));
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;// 처음에 부모는 자기 자신
        }

        weight = 0;
        list = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer r1, Integer r2) {
                return r2 - r1;
            }
        });// 유지비가 큰 순으로 정렬
        while (pq.size() != 0) {
            Road road = pq.poll();
            // if (getParent(road.s) == getParent(road.f))
            // continue;// 이미 연결되어있는 도시라면

            union(road.s, road.f, road.w);// 연결한다
            // weight += road.w;
        }

        System.out.println(weight - list.poll());
    }
}