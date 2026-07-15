package org.problems.baire;

import java.util.TreeSet;

public class MinReservationSeats {


    public static void main (String ...args){

        MinReservationSeats minReservationSeats = new MinReservationSeats();
        //int []seatsHistory = minReservationSeats.getReservations(3,new int[]{0,0,0});
        int []seatsHistory2 = minReservationSeats.getReservations(7,new int[]{0,0,0,3,1,0,4,0,0,0});
        int []seatsHistory3 = minReservationSeats.getReservations(12,
                new int[]{0,0,0,3,1,0,4,0,0,0
                        ,10,0,0,0,2,6,7,0,0});

        for(int i=0; i < seatsHistory2.length; i++){
            System.out.print(seatsHistory2[i] + ", ");
        }
        System.out.println();
        for(int i=0; i < seatsHistory3.length; i++){
            System.out.print(seatsHistory3[i] + ", ");
        }
    }

    public int[] getReservations(int seatsToReserve, int []seatsReserved){
        TreeSet<Integer> tree = new TreeSet<>();
        int []seatReservationHistory = new int[seatsToReserve];
        int srhIndex = 0;
        int val = 1;
        for(int i = 0; i < seatsReserved.length; i++){
            if(seatsReserved[i] == 0){
                if(!tree.isEmpty()){
                    int min = tree.getFirst();
                    tree.remove(min);
                    seatReservationHistory[srhIndex++] = min;
                }
                else{
                    seatReservationHistory[srhIndex++] = val;
                    val++;
                }
            }
            else{
                if(val > seatsReserved[i]){
                    tree.add(seatsReserved[i]);
                }
            }
        }
        return seatReservationHistory;
    }
}
