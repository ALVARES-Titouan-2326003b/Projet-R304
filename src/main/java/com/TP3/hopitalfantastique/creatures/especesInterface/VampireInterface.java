package java.com.TP3.hopitalfantastique.creatures.especesInterface;

public interface VampireInterface extends Race {
    String race = "Vampire";
    default String getRace() {
        return race;
    }
}
