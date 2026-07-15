package org.problems.amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
public class CoinCollection
{
    public class Sequence{
        @Getter
        char coin;
        @Getter @Setter
        int val;

        public Sequence(char coin){
            this.coin = coin;
        }


    }
    public int minimumCoinFlips(String coins){
        char currentCoin = coins.charAt(0);
        int  currentCount = 1;
        List<Sequence> coinList = new ArrayList<>();
        for(int i = 1; i < coins.length(); i++){


            if(currentCoin == coins.charAt(i)){
                currentCount++;
            }
            else{

                Sequence newCoin = new Sequence(currentCoin);
                newCoin.setVal(currentCount);
                coinList.add(newCoin);
                currentCoin = coins.charAt(i);
                currentCount = 1;
            }
        }
        Sequence newCoin = new Sequence(currentCoin);
        newCoin.setVal(currentCount);
        coinList.add(newCoin);


        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coinList.size(); i++){

            int leftSum = getLeftCoinFLips(coinList,i);
            int rightSum = getRightCoinFlips(coinList,i);
            min  = Math.min((leftSum + rightSum), min);
        }

        return min;

    }
    public int getLeftCoinFLips(List<Sequence> coinList,int index){

        char coin = coinList.get(index).getCoin();

        int skip  = coin == 'H' ? 1 : 2;
        int sum = 0;
        for(int i = index-skip; i >= 0; i-=2 ) {
            sum += coinList.get(i).getVal();
        }
        return sum;
    }
    public int getRightCoinFlips(List<Sequence> coinList,int index){

        char coin = coinList.get(index).getCoin();

        int skip  = coin == 'T' ? 1 : 2;
        int sum = 0;
        for(int i = index+skip; i < coinList.size(); i+=2 ) {
            sum += coinList.get(i).getVal();
        }
        return sum;
    }


    public static void main(String []args)
    {

        CoinCollection  cc = new CoinCollection();
        System.out.println(cc.minimumCoinFlips("HHTHTT"));
        System.out.println(cc.minimumCoinFlips("HHTHTTHHHTTTTHHHTTTTTT"));
        System.out.println(cc.minimumCoinFlips("HHTHTTHHHTTTTHHHTTTTTTHHHHHTTTTTTTTTTTHHHHHHTTTTHT"));
        System.out.println(cc.minimumCoinFlips("HHTHTTHHH"));
        System.out.println(cc.minimumCoinFlips("HHTHTTHHHHHHTTHTH"));
        System.out.println(cc.minimumCoinFlips("HHTHTTHTHTHTHTTHHH"));
        System.out.println(cc.minimumCoinFlips("TTTTT"));
        System.out.println(cc.minimumCoinFlips("HHHHH"));
        System.out.println(cc.minimumCoinFlips("TTTTTHHH"));
        System.out.println(cc.minimumCoinFlips("HHHTTTTTT"));
        System.out.println(cc.minimumCoinFlips("HHHH"));
        System.out.println(cc.minimumCoinFlips("TTT"));
        System.out.println(cc.minimumCoinFlips("HT"));
        System.out.println(cc.minimumCoinFlips("TT"));
        System.out.println(cc.minimumCoinFlips("HH"));
        System.out.println(cc.minimumCoinFlips("TH"));
    }

}