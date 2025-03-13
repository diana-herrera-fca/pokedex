package com.proyecto.pokedex.service;

import com.proyecto.pokedex.entity.api.PokemonDetailResponse;
import com.proyecto.pokedex.entity.response.Page;
import com.proyecto.pokedex.entity.response.PokemonGeneralInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokedexService {
    Page getAllPokemon(int limit, int offset);
    PokemonDetailResponse getPokemonDetail(String name);
}
