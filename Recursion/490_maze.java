class Solution {
  public static boolean maze (char[][] maze, int startX, int startY, int targetX, int targetY) {
    if (startX < 0 || startY < 0 || 
        startX >= maze.length || startY >= maze[0].length || maze[startX][startY]=='X') return false;  //stop condition
    if (startX == targetX && startY == targetY) return true; //stop condition
    
    maze[startX][startY]=='X';
    int[] dx = {1,0,-1,0};  //four directions
    int[] dy = {0,-1,0,1};
    for (int i = 0; i<4; i++){
     if (maze(maze, startX + dx[i], startY + dy[i], targetX, targetY)
        return true;
    }
    return false;
  }
}
