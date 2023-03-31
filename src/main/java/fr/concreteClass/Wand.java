package fr.concreteClass;
import fr.enumClass.Core;
import lombok.Getter;
import lombok.Setter;

public class Wand {

    @Getter
    @Setter
    private int size;
    @Getter
    @Setter
    private Core core;

    public Wand(int size, Core core) {
        this.size = size;
        this.core = core;
    }

    public Wand(Wand wand){
        this.size = wand.getSize();
        this.core = wand.getCore();
    }
}
