package org;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main (String [] args ){
            Test t = new Test();
            t.testLoop("1234", 0,0);
    }


    public void testLoop(String number, int index, Integer count){
        StringBuilder sb = new StringBuilder(number);

         for(int i = index; i < number.length()-1; i++) {
            //swap
            testLoop(sb.toString(), index + 1, count);
            //System.out.println(sb);
            Character a = number.charAt(index);
            Character b = number.charAt(i + 1);
            sb = new StringBuilder(number);
            sb.replace(index, index + 1, String.valueOf(b));
            sb.replace(i + 1, i + 2, String.valueOf(a));
            System.out.println(sb);
        }
    }
    public void CountSelectedCharacter(String letter){
        String file = new String("C:/Users/eliza/test.txt");
        if(letter.isEmpty()) return;
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = new String();
            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == letter.charAt(0)){
                        count++;
                    }
                }
            }
            System.out.println(letter +  " : count : " + count);
        }catch (IOException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
