package fr.abstractClass;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractSpell {
    public AbstractSpell(String name, int success_rate) {
        this.name = name;
        this.success_rate = success_rate;
    }

    @Override
    public String toString() {
        return "AbstractSpell{" +
            "name='" + name + '\'' +
            ", success_rate=" + success_rate +
            '}';
    }

    @Getter
    private final String name;
    @Getter
    @Setter
    private  int success_rate;
}
