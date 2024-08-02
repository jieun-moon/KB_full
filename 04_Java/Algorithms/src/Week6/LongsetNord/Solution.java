package Week6.LongsetNord;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] edge) {
        int count = 0;
        //int[][] edge를 인접리스트로 변환
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            //반대편에 연결됐다는게 무슨 뜻....?
            graph.get(e[1]).add(e[0]);
        }

        //count = bfs(1);
        //bfs(1) 호출
        //graph를 왜 건내주나....?
        return bfs(graph, 1, n);
    }

    int bfs(Map<Integer, List<Integer>> graph, int startVertex, int n){
        //시작점 예약
        // 업데이트가 원활히 되도록 가장 작은값으로 설정
        // maxDist가 10000이면, 업데이트가 되지 않음
        // minDist면, 가장 큰 값으로(무한대, max_size(파이썬기준))설정. 업데이트가 되야하므로
        int maxDist = -1;
        int count = 0;

        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startVertex, 0});
        visited[startVertex] = true;

        while(!queue.isEmpty()){
            //현재 노드 방문
            int[] cur = queue.poll();
            int curVertex = cur[0];
            int dist = cur[1];

            if (maxDist < dist){
                maxDist = dist;
                count = 0;
            }
            count ++;

            //다음 노드 예약
            for(int nextVertex : graph.get(curVertex)){
                if(!visited[nextVertex]){
                    queue.offer(new int[]{nextVertex, dist+1});
                    visited[nextVertex] = true;
                }
            }
        }

        return count;
    }
}
