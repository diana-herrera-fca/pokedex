package com.proyecto.pokedex.service;

import com.proyecto.pokedex.entity.response.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokedexService {
    Page getAllPokemon(int limit, int offset);
    ResponseEntity<?> getPokemonDetail(String name);
}
