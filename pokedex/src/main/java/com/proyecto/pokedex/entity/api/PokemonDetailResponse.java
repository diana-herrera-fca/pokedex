package com.proyecto.pokedex.entity.api;

import com.proyecto.pokedex.entity.response.PokemonGeneralInfo;

import java.util.List;

public class PokemonDetailResponse {
    private int id;
    private String name;
    private String description;
    private int height;
    private int weight;
    private int base_experience;
    private List<TypeWrapper> types;
    private List<AbilityWrapper> abilities;
    private Sprite sprites;
    private List<StatWrapper> stats;
    private List<PokemonGeneralInfo> evolutions;

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public List<TypeWrapper> getTypes() {
        return types;
    }

    public void setTypes(List<TypeWrapper> types) {
        this.types = types;
    }

    public List<AbilityWrapper> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityWrapper> abilities) {
        this.abilities = abilities;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<StatWrapper> getStats() {
        return stats;
    }

    public void setStats(List<StatWrapper> stats) {
        this.stats = stats;
    }

    public List<PokemonGeneralInfo> getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(List<PokemonGeneralInfo> evolutions) {
        this.evolutions = evolutions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

