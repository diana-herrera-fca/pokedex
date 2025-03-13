package com.proyecto.pokedex.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.proyecto.pokedex.entity.api.PokemonDetailResponse;
import com.proyecto.pokedex.entity.api.ResponseBase;
import com.proyecto.pokedex.entity.api.PokemonResponse;
import com.proyecto.pokedex.entity.response.Page;
import com.proyecto.pokedex.entity.response.PokemonGeneralInfo;
import com.proyecto.pokedex.service.PokedexService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokedexServiceImpl implements PokedexService {
    RestTemplate restTemplate = new RestTemplate();
    @Cacheable(value = "pokemonCache", key = "#limit - #offset")
    public Page getAllPokemon(int limit, int offset) {
        final String uri = "https://pokeapi.co/api/v2/pokemon?limit="+limit+"&offset="+offset;
        PokemonResponse result = restTemplate.getForObject(uri, PokemonResponse.class);
        List<PokemonGeneralInfo> pokemonDetail = new ArrayList<>();
        for(ResponseBase pokemon: result.getResults()){
            pokemonDetail.add(getPokemonGeneralInformation(pokemon.getName()));
        }
        Page page = new Page();
        page.setCount(result.getCount());
        page.setItems(pokemonDetail);
        return page;
    }
    @Cacheable(value = "pokemonCache", key = "#name- general")
    public PokemonGeneralInfo getPokemonGeneralInformation(String name) {
        final String uri = "https://pokeapi.co/api/v2/pokemon/"+name;
        PokemonGeneralInfo result = restTemplate.getForObject(uri, PokemonGeneralInfo.class);
        return result;
    }
    @Cacheable(value = "pokemonCache", key = "#name")
    public PokemonDetailResponse getPokemonDetail(String name) {
        final String uri = "https://pokeapi.co/api/v2/pokemon/"+name;
        try {
            PokemonDetailResponse result = restTemplate.getForObject(uri, PokemonDetailResponse.class);
            result.setEvolutions(getPokemonEvolutions(name));
            result.setDescription(getPokemonDescription(result.getId()));
            return result;
        }catch (HttpClientErrorException.NotFound e){
            System.err.println("Error fetching data: " + e.getMessage());
            return new PokemonDetailResponse();
        }
    }

    @Cacheable(value = "pokemonCache", key = "#name-evolutions")
    public List<PokemonGeneralInfo> getPokemonEvolutions(String pokemonName) {
        List<PokemonGeneralInfo> evolutions = new ArrayList<>();
        try {
            String speciesUrl = "https://pokeapi.co/api/v2/pokemon-species/" + pokemonName + "/";
            ResponseEntity<JsonNode> speciesResponse = restTemplate.getForEntity(speciesUrl, JsonNode.class);
            JsonNode speciesJson = speciesResponse.getBody();

            if (speciesJson == null || !speciesJson.has("evolution_chain")) {
                throw new RuntimeException("Evolution chain URL not found for " + pokemonName);
            }
            String evolutionChainUrl = speciesJson.get("evolution_chain").get("url").asText();
            ResponseEntity<JsonNode> evolutionResponse = restTemplate.getForEntity(evolutionChainUrl, JsonNode.class);
            JsonNode evolutionJson = evolutionResponse.getBody();
            if (evolutionJson == null || !evolutionJson.has("chain")) {
                throw new RuntimeException("Invalid evolution chain data for " + pokemonName);
            }
            JsonNode current = evolutionJson.get("chain");
            while (current != null) {
                evolutions.add(getPokemonGeneralInformation(current.get("species").get("name").asText()));
                current = current.get("evolves_to").size() > 0 ? current.get("evolves_to").get(0) : null;
            }
        } catch (Exception e) {
            System.err.println("Error fetching evolution data: " + e.getMessage());
        }
        return evolutions;
    }
    @Cacheable(value = "pokemonCache", key = "#id-description")
    public String getPokemonDescription(int id) {
        try {
            String url = "https://pokeapi.co/api/v2/characteristic/" + id + "/";
            ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);
            JsonNode jsonResponse = response.getBody();
            if (jsonResponse == null || !jsonResponse.has("descriptions")) {
                throw new RuntimeException("No descriptions found for ID: " + id);
            }
            for (JsonNode descNode : jsonResponse.get("descriptions")) {
                if ("en".equals(descNode.get("language").get("name").asText())) {
                   return (descNode.get("description").asText());
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching characteristic: " + e.getMessage());
        }
        return "No description available";
    }
}
