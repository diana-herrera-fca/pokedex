package com.proyecto.pokedex.entity.response;

import java.util.List;

public class Page {
    int count;
    List<PokemonGeneralInfo> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PokemonGeneralInfo> getItems() {
        return items;
    }

    public void setItems(List<PokemonGeneralInfo> items) {
        this.items = items;
    }
}
