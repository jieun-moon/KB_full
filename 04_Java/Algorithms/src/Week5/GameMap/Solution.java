package Week5.GameMap;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int solution(int[][] maps) {
        //map의 행의 개수를 변수 n에 저장
        int n = maps.length;
        //지도의 열의 개수를 변수 m에 저장
        int m = maps[0].length;
        //방문 여부를 저장하는 2차원 배열 생성, 초기값은 모두 false
        boolean[][] visited = new boolean[n][m];
        //큐를 생성, 큐는 탐색을 위한 자료 구조
        Queue<int[]> queue = new ArrayDeque<>();

        //BFS 탐색을 수행한다
        //시작점(0, 0)과 초기 거리 1을 큐에 추가하고 방문 처리
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        //행 이동 방향: 왼쪽, 아래, 오른쪽, 위
        int[] dr = {0, 1, 0, -1};
        //열 이동 방향: 왼쪽, 아래, 오른쪽, 위
        int[] dc = {-1, 0, 1, 0};

        //큐가 비어있지 않은 동안 반복
        while(!queue.isEmpty()){
            //큐에서 현재 위치와 거리를 꺼냄
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], dist = cur[2];

            //탐색 과정에서 목적지에 도달하면 거리를 반환
            //현재 위치가 목표 지점(n-1, m-1)이라면 현재 거리 반환
            if(r == n-1 && c == m-1){
                return dist;
            }

            //네 방향으로 이동을 시도
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d], nc = c + dc[d];

                //새 위치가 지도 내에 있고 이동 가능한 곳인지 확인
                if(nr >=0 && nr < n && nc >=0 && nc < m && maps[nr][nc] == 1){
                    //아직 방문하지 않은 곳이라면
                    if(!visited[nr][nc]){
                        //방문 처리하고 큐에 새 위치와 거리 추가
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }

//        탐색 과정에서 목적지에 도달하지 못했다면 -1을 반환한다
        return -1;
    }
}
