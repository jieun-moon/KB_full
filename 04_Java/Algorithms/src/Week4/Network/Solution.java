package Week4.Network;

import java.util.Queue;

public class Solution {
    //visited를 전역변수로 빼면 매개변수로 건내줄 필요 없음
    boolean[] visited;
    public int solution(int n, int[][] computers) {

        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, n, computers);
                answer++;
            }

        }
        return answer;
    }
    void dfs(int cur, int n, int[][] computers){
        visited[cur] = true;

        for (int i = 0; i < n; i++){
            if (computers[cur][i] == 1) {
                if(!visited[i])
                    dfs(i, n, computers);
            }
        }
    }
}
