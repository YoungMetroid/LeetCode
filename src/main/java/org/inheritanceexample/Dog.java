package org.inheritanceexample;


public class Dog implements Animal{

    String name;
    int legs;
    float height;
    int teeth;
    int smellStrength = 0;


    public Dog(String name, int legs, float height, int teeth){
        this.name = name;
        this.legs = legs;
        this.height = height;
        this.teeth = teeth;
    }
    public void setSmellStrength(int smellStrength){
        this.smellStrength = smellStrength;
    }
    public int getSmellStrength(){
        return smellStrength;
    }
    public String getName(){
        return name;
    }
    @Override
    public int getLegs() {
        return legs;
    }
    @Override
    public void sound() {
        System.out.println("Woof");
    }
    @Override
    public float height() {
        return height;
    }
    @Override
    public int teeth() {
        return teeth;
    }
    public void print(){
        System.out.println(name + " " + height);
    }

}
