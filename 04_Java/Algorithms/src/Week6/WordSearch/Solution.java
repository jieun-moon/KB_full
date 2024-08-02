package Week6.WordSearch;

public class Solution {
    int m;
    int n;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    boolean[][] visited;

    public boolean exist(char[][] board, String word){
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(board[r][c] == word.charAt(0)){
                    //갔을 때 True표시로 막고
                    visited[r][c] = true;
                    if (backtrack(r,c, 1, board, word)) return true;
                    //backtrack으로 다시 풀기(완전탐색 피로도 참조)
                    visited[r][c] = false;
                }

            }
        }
        return false;
    }

    //모든 방향에 대해 주어진 word랑 일치하면 True 반환
    boolean backtrack(int r, int c, int count, char[][] board, String word){

        if (count >= word.length()) return true;
        //상하좌우가 주어진 word랑 일치하는지 판별
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n){
                if(board[nr][nc] == word.charAt(count)){
                    visited[nr][nc] = true;
                    if (backtrack(nr,nc,count+1, board, word)) return true;
                    //backtrack으로 다시 풀기(완전탐색 피로도 참조)
                    visited[nr][nc] = false;
                }
            }
        }
        return false;
    }
}
