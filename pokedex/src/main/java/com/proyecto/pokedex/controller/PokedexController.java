package com.proyecto.pokedex.controller;

import com.proyecto.pokedex.entity.api.PokemonDetailResponse;
import com.proyecto.pokedex.entity.api.ResponseBase;
import com.proyecto.pokedex.entity.api.PokemonResponse;
import com.proyecto.pokedex.entity.response.Page;
import com.proyecto.pokedex.entity.response.PokemonGeneralInfo;
import com.proyecto.pokedex.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://master.d2y12r4xc83xma.amplifyapp.com/")
public class PokedexController {
    @Autowired
    PokedexService pokedexService;
    @GetMapping("/pokedex")
    public ResponseEntity<?> getAllPokemon(@RequestParam(value = "limit") int limit, @RequestParam(value = "offset") int offset) {
        Page pokemonResponse = pokedexService.getAllPokemon(limit, offset);
        return ResponseEntity.ok().body(pokemonResponse);
    }
    @GetMapping("/pokedex/pokemon/{pokemon}")
    public ResponseEntity<?>  getPokemonDetail(@PathVariable(value = "pokemon") String name) {
        return  pokedexService.getPokemonDetail(name);
    }
}
