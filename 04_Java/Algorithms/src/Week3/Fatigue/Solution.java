package Week3.Fatigue;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int answer = 0;
    boolean[] visited;
    int n;

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];
        backtrack(k, dungeons, 0);
        return answer;
    }
    //
    public void backtrack(int cur_k, int[][] dungeons, int cnt){
        if (cnt > answer) {
            answer = cnt;
        }
        //recursive call
        for(int i = 0; i<n; i++){
            //사실 basecase는 cur_k >= dungeons[i][1] 여기 포함
            if(cur_k >= dungeons[i][1] && !visited[i]){
                visited[i]= true; //추가하기
                backtrack(cur_k - dungeons[i][1], dungeons, cnt+1);
                visited[i]=false; //빼기
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 80;
    }
}