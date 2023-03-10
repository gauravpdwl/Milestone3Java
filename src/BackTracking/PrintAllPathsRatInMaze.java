package BackTracking;
import java.io.*;
import java.util.*;

public class PrintAllPathsRatInMaze {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] maze = new int[20][20];
        for (int i = 0; i < n; i++)
        {
            StringTokenizer tk = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++)
            {
                maze[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        Solution.ratInAMaze(maze, n);
    }
    
    public class Solution {

    	public static void printMaze(int maze[][], int i, int j, int path[][], int n) {
    		
    		if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
    			return;
    		}
    		
    		path[i][j]=1;
    		//System.out.println("i-"+i+" j-"+j);
    		if(i==n-1 && j== n-1) {
    			//System.out.println("ComingHere?");
    			for(int k=0;k<n;k++) {
    				for(int l=0;l<n;l++) {
    					System.out.print(path[k][l]+" ");
    				}
    			}
    			path[i][j]=0;
    			System.out.println();
    			return;
    		}
    		
    		//explore top, right, down, left paths
    		printMaze(maze, i-1, j, path, n);
    		printMaze(maze, i, j+1, path, n);
    		printMaze(maze, i+1, j, path, n);
    		printMaze(maze, i, j-1, path, n);
    		
    		path[i][j]=0;
    	}
    	
    	static void ratInAMaze(int maze[][], int n) {
    		int path[][]=new int[n][n];
    		printMaze(maze, 0, 0, path, n);
    	}

    }
}