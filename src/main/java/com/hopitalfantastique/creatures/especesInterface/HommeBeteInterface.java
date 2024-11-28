package java.com.hopitalfantastique.creatures.especesInterface;

public interface HommeBeteInterface extends Race {
    String race = "HommeBete";
    default String getRace() {
        return race;
    }
}
