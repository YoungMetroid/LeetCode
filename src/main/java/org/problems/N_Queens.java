package org.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N_Queens {

    public N_Queens(){
        solveNQueens(6);
    }
    public List<List<String>> solveNQueens(int n){
        List<List<String>> solutions = new ArrayList<>();
        List<StringBuilder> board;

        board = IntStream.range(0,n)
                .mapToObj(i-> new StringBuilder(".".repeat(n)))
                .toList();


        backtrack(solutions,board,0,n);
        return solutions;

    }

    public void backtrack(List<List<String>> solutions, List<StringBuilder>board,int row, int n){
        for(int i = 0; i < n ; i++){
            if(!doesQueenExistInColumn(board,i) && !doesQueenExistInDiagnal(board,row,i,n)){
                board.get(row).replace(i,i+1,"Q");
                if(row == n-1){
                    solutions.add(new ArrayList<>(board.stream().map(StringBuilder::toString).toList()));
                }
                else backtrack(solutions, board, row+1,n );
                board.get(row).replace(i,i+1,".");
            }
        }
    }
    public boolean doesQueenExistInColumn(List<StringBuilder> board, int column){
        for(StringBuilder sb:board){
            if(sb.charAt(column)== 'Q'){
                return true;
            }
        }
        return false;
    }
    public boolean doesQueenExistInDiagnal(List<StringBuilder> board,int row, int column,int n){
        //upleft
        for(int i=row,j = column; i >=0 && j>=0; i--,j--){
            if(board.get(i).charAt(j) == 'Q')
                return true;
        }
        //upright
        for(int i=row,j = column; i >=0 && j < n; i--,j++){
            if(board.get(i).charAt(j) == 'Q')
                return true;
        }
        //downleft
        for(int i=row,j = column; i < n && j>=0; i++,j--){
            if(board.get(i).charAt(j) == 'Q')
                return true;
        }
        //upleft
        for(int i=row,j = column; i < n && j < n; i++,j++){
            if(board.get(i).charAt(j) == 'Q')
                return true;
        }
        return false;
    }

}
