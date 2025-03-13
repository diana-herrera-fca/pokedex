package com.proyecto.pokedex.entity.response;

import com.proyecto.pokedex.entity.api.AbilityWrapper;
import com.proyecto.pokedex.entity.api.Sprite;
import com.proyecto.pokedex.entity.api.TypeWrapper;

import java.util.List;

public class PokemonGeneralInfo {
    private int id;
    private String name;
    private int weight;
    private List<TypeWrapper> types;

    private List<AbilityWrapper> abilities;
    private Sprite sprites;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<TypeWrapper> getTypes() {
        return types;
    }

    public void setTypes(List<TypeWrapper> types) {
        this.types = types;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<AbilityWrapper> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityWrapper> abilities) {
        this.abilities = abilities;
    }
}
