package Cargo;

import Railways.IDgenerator;

public abstract class Cargo {
    private int id;

    public Cargo() {
        setId(IDgenerator.getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}