import java.util.ArrayList;

public class SuperHeroes {
    ArrayList<SuperHeroe> dc_superHeroes = new ArrayList<>();
    ArrayList<SuperHeroe> marvel_superHeroes = new ArrayList<>();

    public void addSuperHeroes() {
        dc_superHeroes.add(new SuperHeroe("flash", 3, new String[] { "fast", "slowmotion", "strength" }, false, "DC"));
        dc_superHeroes.add(new SuperHeroe("Thor", 2, new String[] { "intelligent", "fly" }, false, "DC"));
    }

    public void printHeroeInformation() {
        for (int i = 0; i < dc_superHeroes.size(); i++) {
            SuperHeroe hero = dc_superHeroes.get(i);
            System.out.println("Name: " + hero.superHeroName);
            System.out.println("Universe: " + hero.universe);
            System.out.println("Is alive ?: " + hero.isAlive);
            System.out.println("Powers:");
            hero.getPowers();
            System.out.println();
        }

    }
}