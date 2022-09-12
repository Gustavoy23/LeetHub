class Solution {
    int res;
    int m;
    int n;
    public int maximumRows(int[][] matrix, int numSelect) {
        res = 0;
        this.m = matrix.length;
        this.n = matrix[0].length;
        checkCol(matrix, numSelect, 0, 0, new HashSet<>());
        return res;
    }
    
    private void checkCol(int[][] matrix, int numSelect, int index, int Col, Set<Integer> visited) {
        
        if(visited.size() == numSelect) {
            int count = 0;
            
            for(int i = 0; i < m; i++) {
                boolean flag = true;
                for(int j = 0; j < n; j++) {
                   if(matrix[i][j] == 1) { 
                    if(!visited.contains(j)){
                        flag = false;
                        break;
                    }
                   }
                }
                if(flag) count++;
            }
            res = Math.max(res, count);
            return;
        }
        
        if(index >= n) return;
        
        visited.add(index);
        checkCol(matrix, numSelect, index+1, Col+1, visited);
        visited.remove(index);
        checkCol(matrix, numSelect, index+1, Col, visited);
        
    }
}