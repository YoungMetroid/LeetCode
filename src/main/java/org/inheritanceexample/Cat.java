package org.inheritanceexample;

public class Cat implements Animal{
    String name;
    int legs;
    float height;
    int teeth;

    public Cat(String name, int legs, float height, int teeth){
        this.name = name;
        this.legs = legs;
        this.height = height;
        this.teeth = teeth;
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
        System.out.println("Meow");
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
