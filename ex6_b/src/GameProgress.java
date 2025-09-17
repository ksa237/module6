import java.io.Serializable;

public class GameProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int health;
    private final int weapons;
    private final int lvl;
    private final double distance;

    public GameProgress(int health, int lvl, int weapons, double distance) {
        this.health = health;
        this.lvl = lvl;
        this.weapons = weapons;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{"+
                "health="+health+
                ", weapons="+weapons+
                ", lvl=" + lvl +
                ", distance=" + distance+
                "}";
    }

}
