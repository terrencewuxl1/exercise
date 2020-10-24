package com.java.concept;

import java.util.*;

public class SnakeGame {

    class Point{
        int row,col;
        public Point(int r,int c){
            row=r;
            col=c;
            Random r=new Random();
            int i=r.nextInt(50);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row &&
                    col == point.col;

        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    Queue<Point> q;
    Set<Point> set;
    int[][] board, foods;
    int w,h,eat, fi;
    Point head;
    Map<String, int[]> direct;
    public SnakeGame(int width, int height, int[][] food) {
        w=width;
        h=height;
        board=new int[h][w];
        direct =new HashMap<>();
        direct.put("U",new int[]{-1,0});
        direct.put("L",new int[]{0,-1});
        direct.put("R",new int[]{0,1});
        direct.put("D",new int[]{1,0});
        q=new LinkedList<>();
        head=new Point(0,0);
        q.offer(head);
        eat=0;
        foods=food;
        board[foods[0][0]][foods[0][1]]=1;
        fi=1;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] diff= direct.get(direction);
        head=new Point(head.row+ diff[0], head.col+diff[1]);
        int r= head.row, c= head.col;
        if(r<0||r==h||c<0||c==w||set.contains(head))return -1;
        q.offer(head);
        set.add(head);
        if(board[r][c]==1){
            eat++;
            board[r][c]=0;
            if(fi++== foods.length){
                return eat;
            }
            Point nextFood=new Point(foods)
        }else {
            set.remove(q.poll());
        }
        return eat;
    }
}
