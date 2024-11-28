package java.com.hopitalfantastique.creatures.especesInterface;

public interface ZombieInterface extends Race {
    String race = "Zombie";
    default String getRace() {
        return race;
    }
}
