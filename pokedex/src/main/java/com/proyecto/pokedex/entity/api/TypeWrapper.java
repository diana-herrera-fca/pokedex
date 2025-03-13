package com.proyecto.pokedex.entity.api;

public class TypeWrapper {
    private Type type;
    private int slot;
    public int getSlot() { return slot; }
    public void setSlot(int slot) { this.slot = slot; }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}