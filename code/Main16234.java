import java.util.*;
import java.io.*;
class Main16234{
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int L;
    static int R;
    static int cnt;
    static int people;
    static int[][] map;
    static boolean[][] visited;

    public static void func(int x, int y)
    {
        visited[x][y]=true;
        cnt++;
        people+=map[x][y];
        int a = map[x][y];
        map[x][y]=-1;//임시로 -1로 둔다
        for(int dir=0;dir<4;dir++)
        {
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if(nx<0 || nx>=N || ny<0 || ny>=N)
                continue;

            if(Math.abs(map[nx][ny] - a) < L || Math.abs(map[nx][ny] - a) > R)
                continue;
            
            if(visited[nx][ny]==false)
                func(nx,ny);
        }
    }

    public static void change(int a)
    {//이거때문에 오래 걸리나보다 리스트에 넣는걸로 하는게 더 빠르..다
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(map[i][j]==-1)
                    map[i][j]=a;//새 값으로 갱신
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer=0;
        while(true)
        {
            int count=0;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(visited[i][j]==false)
                    {
                        count++;
                        func(i,j);//연합
                        change(people/cnt);//이값으로 변경
                        people=0;
                        cnt=0;//초기화
                    }
                }
            }

            // for(int i=0;i<N;i++)
            //     System.out.println(Arrays.toString(map[i]));

            if(count==N*N)
                break;
            answer++;
        }
        System.out.println(answer);
    }
}