class Solution {
    class Pair {
            int x;
            int y;
            public Pair(int a, int b) {
                x = a;
                y = b;
            }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] distance = new int[row][col];
        for (int i = 0; i < row; i++) {
            for  (int j = 0; j < col; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        distance[start[0]][start[1]] = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(start[0],start[1]));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x;
                int y = cur.y;
                int dist = distance[x][y];
                while (x >= 0 && x< maze.length && y >= 0 && y< maze[0].length && maze[x][y]==0) {
                    x += dx[i];
                    y += dy[i];
                    dist++;
                }
                x -= dx[i];
                y -= dy[i];
                --dist;
                if (distance[x][y] > dist) {
                    distance[x][y] = dist;
                    if (x != destination[0] || y != destination[1]) {
                        queue.offer(new Pair(x,y));
                    }
                }
                
            }
        }
        int res = distance[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE? -1 : res;
    }
}
