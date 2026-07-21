package org.problems.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inconvenience {

    public static void main(String ...args){

        Inconvenience inconvenience = new Inconvenience();
        List<List<Integer>> grid = new ArrayList<>();

        List<Integer> row = new ArrayList<>(Arrays.asList(1,0,0,0,0,1));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
        List<Integer> row5 = new ArrayList<>(Arrays.asList(1,0,0,0,0,0));

        grid.add(row);
        grid.add(row2);
        grid.add(row3);
        grid.add(row4);
        grid.add(row5);
        int inconvenience2 = inconvenience.getMinInconvenience(grid);
        System.out.println(inconvenience2);
    }

    public  int getMinInconvenience(List<List<Integer>>grid){
        List<int[]> warehouses = new ArrayList<>();
        int maxDistance = 0;
        //First find the warehouses
        for(int y =0; y < grid.size(); y++ ){
            for(int x =0; x < grid.get(y).size(); x++){
                if(grid.get(y).get(x) ==1){
                    warehouses.add(new int[]{x,y});
                    grid.get(y).set(x,-1);
                }
            }
        }

        //Calculate the max distance to the nearest store
        for(int i =0; i < warehouses.size(); i++){
            for(int y =0; y < grid.size(); y++ ){
                for(int x =0; x < grid.get(y).size(); x++){
                    if(grid.get(y).get(x) != -1 ){
                        int minDistance = Math.max(
                                Math.abs(y-warehouses.get(i)[1])
                                ,Math.abs(x-warehouses.get(i)[0]));
                        if(minDistance < grid.get(y).get(x)){
                            grid.get(y).set(x,minDistance);
                        }
                        else if(grid.get(y).get(x) == 0){
                            grid.get(y).set(x,minDistance);
                        }
                    }
                }
            }
        }

        //Find maxDistance location and change to a store
        //it can be any store this is my theory that it
        //will affect the distance to all location
        //unless they are you have a max distance and
        //they are spread out really far from each other
        //then the inconvenience will be the same.

        int[]location = new int[]{0,0};
        for(int y =0; y < grid.size(); y++ ){
            for(int x =0; x < grid.get(y).size(); x++){
                if(grid.get(y).get(x) != -1 ){
                    if(grid.get(y).get(x) > maxDistance){
                        location[0] = x;
                        location[1] = y;
                        maxDistance = grid.get(y).get(x);
                    }
                    grid.get(y).set(x,0);
                }
            }
        }
        grid.get(location[1]).set(location[0],-1);
        warehouses.add(location);

        for(int i =0; i < warehouses.size(); i++){
            for(int y =0; y < grid.size(); y++ ){
                for(int x =0; x < grid.get(y).size(); x++){
                    if(grid.get(y).get(x) != -1 ){
                        int minDistance = Math.max(
                                Math.abs(y-warehouses.get(i)[1])
                                ,Math.abs(x-warehouses.get(i)[0]));
                        if(minDistance < grid.get(y).get(x)){
                            grid.get(y).set(x,minDistance);
                        }
                        else if(grid.get(y).get(x) == 0){
                            grid.get(y).set(x,minDistance);
                        }
                    }
                }
            }
        }

        //Get the maxinconvenience
        maxDistance = 0;
        for(int y =0; y < grid.size(); y++ ){
            for(int x =0; x < grid.get(y).size(); x++){
                if(grid.get(y).get(x) != -1 ){
                   if(grid.get(y).get(x) > maxDistance){
                       maxDistance = grid.get(y).get(x);
                   }
                }
            }
        }

        for(int i =0; i < grid.size();i++){
            System.out.println(grid.get(i));
        }
        return maxDistance;
    }
}
