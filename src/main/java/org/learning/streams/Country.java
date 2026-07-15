package org.learning.streams;

public class Country {
    private String name;
    private Long population;
    private String continent;
    private int value=0;

    public Country(String name, Long population, String continent){
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public String getName(){
        return this.name;
    }
    public Long getPopulation(){
        return this.population;
    }
    public int getValue(){
        return value;
    }
}
