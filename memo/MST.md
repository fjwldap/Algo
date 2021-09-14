# MST

모든 점을 최단거리로 연결한다

## 필요한 것

    parent[] 각 점의 부모가 담길 배열
    rank[] 밑에 몇개의 자식이 있는지 (parent[]만 써도 되긴 함)

## 함수

- getParent : 재귀로 부모 저장, 반환

```
static int getParent(int a) {
    if (a != parent[a])
        parent[a] = getParent(parent[a]);

    return parent[a];
}
```

- union : 두 노드 연결

내가 정한 기준

1. rank가 큰거의 부모로
2. rank가 같으면  
   노드번호가 작은걸로 연결

```
public static void union(int a, int b,int l)
{
    int pa = getParent(a);
    int pb = getParent(b);

    if(pa==pb)//부모가 같으면 안합친다
        return;

    if(rank[pa]< rank[pb])
    {
        parent[pa]=pb;
        rank[pb]++;
    }
    else if(rank[pa]>rank[pb])
    {
        parent[pb]=pa;
        rank[pa]++;
    }
    else
    {//rank가 같으면 작은노드
        if(pa<pb)
        {//부모가 작은걸로
            parent[pb]=pa;
            rank[pa]++;
        }
        else
        {
            parent[pa]=pb;
            rank[pb]++;
        }
    }
}
```
