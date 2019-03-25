package dev.secondsun.beyondbasics.annotations.examples.lint;

public class AMVReader {


    public String getAnimal() {
        return AMVProvider.getAMV("animal");
    }

    public String getMineral() {
        return AMVProvider.getAMV("mineral");
    }

    public String getVegetable() {
        return AMVProvider.getAMV("vegetable");
    }

    /**
     * Joke method because I'm a 16 year old hax0rz!
     * @return null, always null.
     */
    public String getTom() {
        //This should not lint
        return AMVProvider.getAMV("tom");
    }





}
