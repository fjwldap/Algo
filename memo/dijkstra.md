# 다익스트라

시작도시에서 도착도시까지 가장 빠른 방법으로..

## 필요한 것

    visited[]
    map[] 값이 담길 배열 (얼마나 걸리는지, 비용..)
    pq<시작도시, 도착도시, 값> 값순으로. ~~시작도시는 사실 없어도 됨~~

- 방문했는지 체크
- pq로 알아낸 값 vs map배열의 값을 비교

  - 갱신해야 하니까 pq로 알아낸값이 더 크면 안봐도 된다

- 갈 수 있는 길로 가는데..
  - s -> i 가 빠른지 s->n + n->i가 빠른지
  - 값이 갱신되면 pq에 넣는다

```
while (pq.size() != 0) {
            Road r = pq.poll();
            if (pq로 알아낸 값 vs map배열의 값)
                continue;// 이미 최소거리여서 안봐도 됨

            for (int i = 0; i < al.get(r.f).size(); i++) {
                if ( s -> i vs s->n + n->i)
                    map[s.f] 갱신;
                    pq.add(new Road(r.f, al.get(r.f).get(i), r.w));
                }
            }
        }
```
