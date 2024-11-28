package java.com.TP3.hopitalfantastique.creatures.especesInterface;

public interface ElfInterface extends Race {
    String race = "Elf";
    default String getRace() {
        return race;
    }
}
