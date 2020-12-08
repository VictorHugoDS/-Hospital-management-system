package hospital.management.system.entidades;

import java.io.Serializable;

public abstract class Base implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
