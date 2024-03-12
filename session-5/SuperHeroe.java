

public class SuperHeroe {
    public String superHeroName = "";
    public int superPowersNumbers = 0;
    public String superPowers[] = new String[superPowersNumbers];
    public boolean isAlive = false;
    public String universe = "";

    public SuperHeroe(String superHeroName_param, int superPowersNumbers_param, String[] superPowers_param,
            boolean isAlive_param, String universe_param) {
        this.superHeroName = superHeroName_param;
        this.superPowersNumbers = superPowersNumbers_param;
        this.superPowers = superPowers_param;
        this.isAlive = isAlive_param;
        this.universe = universe_param;
    }

    public void getPowers(){
        for(int e = 0; e < superPowers.length; e++){
            System.out.print(superPowers[e]+" ");
        }
    }
}