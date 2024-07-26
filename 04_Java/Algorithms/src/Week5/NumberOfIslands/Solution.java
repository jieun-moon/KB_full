package Week5.NumberOfIslands;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    numIslands += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        //범위를 벗어나거나 현재 위치가 물('0')인 경우 종료
        if(row <0 || col <0 || row >=rows || col >= cols || grid[row][col] == '0'){
            return;
        }

        //현재 위치를 방문한 것으로 표시('0'으로 변경)
        grid[row][col] = '0';

        //상하좌우로 이동하여 연결된 모든 육지를 탐색
        dfs(grid, row - 1, col); //상
        dfs(grid, row + 1, col); //하
        dfs(grid, row, col - 1); //좌
        dfs(grid, row, col + 1); //우

    }
}
