# nCr
백트래킹 이용  
A, B == B, A

    comb(arr, visited, idx, r);
    //arr에서 idx부터 r개 뽑는다

    comb(int[] arr, boolean[] visited, int idx, int r){
      if(r==0){
      //다뽑았다
        return;
      }

      for(int i=idx;i< N; i++){
        visited[i]=true;
        comb(arr, visited, i+1, r-1);//i 다음꺼부터 뽑는다
        visited[i]=false;
      }
    }

# nPr
순서를 생각하니깐 A, B != B, A

    perm(arr, visited, temp, idx, r);
    //arr에서 r개 뽑아서 temp에 저장

    perm(int[] arr, boolean[] visited, int[] temp, int idx, int r){
      if(idx == r){
      //다뽑았다
        return;
      }

      for(int i=0;i< N; i++){
          if(!visited[i])
          {
            visited[i]=true;
            temp[idx] = arr[i];
            perm(arr, visited, temp, idx+1, r);//idx 다음꺼부터 뽑는다
            visited[i]=false;
          }
      }
    }
