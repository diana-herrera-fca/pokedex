package com.proyecto.pokedex.entity.api;

public class AbilityWrapper {
    private Ability ability;
    private boolean is_hidden;
    private int slot;
    public boolean isIs_hidden() { return is_hidden; }
    public void setIs_hidden(boolean is_hidden) { this.is_hidden = is_hidden; }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
    public int getSlot() { return slot; }
    public void setSlot(int slot) { this.slot = slot; }
}
