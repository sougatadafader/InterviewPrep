package Amazon;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        
        dfs(image,sr,sc,image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int i,int j, int currentcolor, int newcolor){
        
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=currentcolor){
            return;
        }
        image[i][j]=newcolor;
        
        dfs(image,i+1,j,currentcolor,newcolor);
        dfs(image,i-1,j,currentcolor,newcolor);
        dfs(image,i,j+1,currentcolor,newcolor);
        dfs(image,i,j-1,currentcolor,newcolor);
    
    }
}
