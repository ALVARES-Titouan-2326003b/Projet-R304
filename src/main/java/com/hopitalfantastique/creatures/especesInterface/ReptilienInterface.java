package java.com.hopitalfantastique.creatures.especesInterface;

public interface ReptilienInterface extends Race {
    String race = "Reptilien";
    default String getRace() {
        return race;
    }
}
