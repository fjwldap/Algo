# nCr
백트래킹 이용

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
