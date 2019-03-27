
public class  AMVReader {

    public String getAnimal() {
        return lint.AMVProvider.getAMV("animal");
    }
    public String getMineral() {
        return lint.AMVProvider.getAMV("mineral");
    }
    public String getVegetable() {
        return lint.AMVProvider.getAMV("vegetable");
    }

    public String getTom() { return lint.AMVProvider.getAMV("tom"); } // Noncompliant

    public String getVTom(String tom) { return lint.AMVProvider.getAMV(tom); }

}

