package org.problems;

import java.util.Arrays;

public class SpiralMatrixII {

    int up=0;
    int left=0;
    int down=0;
    int right=0;
    int row=0;
    int column=0;
    int number=1;
    public static void main(String ...args){
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][]matrix = spiralMatrixII.generateMatrix(20);

        Arrays.stream(matrix)
                .forEach(row->{
                    Arrays.stream(row)
                    .forEach(e -> System.out.print(e + " "));
                    System.out.println();
                });
    }

    public int[][] generateMatrix(int n){
        int [][]matrix = new int[n][n];

        while(number <= n*n){
            moveRight(matrix, n);
            moveDown(matrix, n);
            moveLeft(matrix, n);
            moveUp(matrix, n);
        }
        return matrix;
    }

    public void moveLeft(int [][]matrix, int n){
        for(; column >= left; column--){
            matrix[row][column] = number;
            number++;
        }
        column++;
        row--;
        left++;


    }
    public void moveRight(int [][]matrix,int n){
         for(; column < n-right; column++){
             matrix[row][column] = number;
             number++;
         }
         column--;
         row++;
         right++;
    }
    public void moveDown(int [][]matrix, int n ){
        for(; row < n-down; row++){
            matrix[row][column] = number;
            number++;
        }
        row--;
        column--;
        down++;
    }

    public void moveUp(int [][]matrix, int n){
        for(; row > up; row--){
            matrix[row][column] = number;
            number++;
        }
        row++;
        column++;
        up++;
    }
}
