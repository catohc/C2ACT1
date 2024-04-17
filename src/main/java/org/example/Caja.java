package org.example;

public class Caja {
    private boolean abierto;

    public Caja(boolean abierto) {
        this.abierto = abierto;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    @Override
    public String toString() {
        return "Caja [abierto=" + abierto + "]";
    }

}
