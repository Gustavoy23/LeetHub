class Solution {
    
    private int m;
    private int n;
    private int[][] direction = {{0,-1},{-1,0},{0,1},{1,0}};
    public boolean hasValidPath(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int[][] streets = new int[7][4];
        
        //left = 0, upper = 1, right = 2, lower = 3 
        streets[1][0] = 1;
        streets[1][2] = 1;
        
        streets[2][1] = 1;
        streets[2][3] = 1;
        
        streets[3][0] = 1;
        streets[3][3] = 1;
        
        streets[4][2] = 1;
        streets[4][3] = 1;
        
        streets[5][0] = 1;
        streets[5][1] = 1;
        
        streets[6][2] = 1;
        streets[6][1] = 1;
        
        Set<Integer> visited = new HashSet<>();
         System.out.println("-");
        return dfs(grid, streets, 0, 0, new int[m][n], new int[]{-1,-1});
        
    }
    
    private boolean dfs(int[][] grid, int[][] streets, int i, int j, int[][] visited, int[] prev) {
        
        if(i < 0 || j < 0 || i >=m || j >= n || visited[i][j] == 1) return false;
        
        if(!check(grid,streets,i,j,prev[0], prev[1])) {
          return false;   
        } 
        
        if(i == m-1 && j == n -1) return true;
        
        int k = grid[i][j];
        
        boolean res = false;    
        visited[i][j] = 1;

        
        for(int d = 0; d < 4; d++) {
            if(streets[k][d] == 1) {
                prev[0] = direction[d][0]*-1;
                prev[1] = direction[d][1]*-1;
                if(dfs(grid, streets, i + direction[d][0], j + direction[d][1], visited,prev)) {
                    res = true;
                    System.out.println("fdsa");
                }
            }
        }
        visited[i][j] = 0;
        
    return res;
    }
    
    private boolean check(int[][] grid,int[][] streets, int i1, int j1, int i0,int j0) {
        
        if(i0==-1 && j0 ==-1) return true; 

        int block = grid[i1][j1];
       // System.out.println(block+ "  "+ i0+". "+j0);
        if(streets[block][0] ==1 && i0 == 0 && j0 ==-1) return true;
        else if(streets[block][1] ==1 && i0 == -1 && j0 ==0) return true;
        else if(streets[block][2] ==1 && i0 == 0 && j0 == 1) return true;
        else if(streets[block][3] ==1 && i0 == 1 && j0 ==0) return true;
        else return false;
        
        
    }
}