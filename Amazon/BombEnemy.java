package Amazon;

public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;     		// rows
        int n= m>0 ? grid[0].length:0;  //columns
        
        if(m*n==0) {
        	return 0;
        }
        
        int res=0, rowKills=0;
        int[] colKills = new int[n];
        
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		
        		if(j==0|| grid[i][j-1]=='W') {
            		rowKills =0;
            		for(int k=j; k<n && grid[i][k] !='W';k++) {
            			if(grid[i][k]=='E') {
            				rowKills++;
            			}
            		}
         	
        		}
        		
        		if(i==0 || grid[i-1][j]=='W') {
        			colKills[j]=0;
        			for(int k=i;k<m && grid[k][j]!='W';k++) {
        				if(grid[k][j]=='E') {
        					colKills[j]++;
        				}
        			}
        		}
        		
        		if(grid[i][j]=='0') {
        			res = Math.max(res, rowKills+colKills[j]);
        		}
        		
        		
        	}
        }
        return res;
        
    }
}
