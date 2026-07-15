package org.inheritanceexample;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Grouping {
    public static void main(String ...args){

        List<Animal> animalList = new ArrayList<>();

        Dog b = new Dog("Beagle",4,80,16);
        b.setSmellStrength(1000);
        animalList.add(b);
        animalList.add(new Cat("Egipcio",4,60,12));
        animalList.add(new Cat("Negro",4,60,12));
        animalList.add(new Cat("Pastor",4,60,12));

        for(Animal animal:animalList){
            if(animal instanceof Dog){

                animal.print();

                Dog b2 = (Dog)animal;
                System.out.println(b2.getSmellStrength());
            }
        }
    }
}
