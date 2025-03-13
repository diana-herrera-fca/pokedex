package com.proyecto.pokedex.entity.api;

import java.util.List;

public class PokemonResponse {
    int count;
    String next;
    String previous;
    List<ResponseBase> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ResponseBase> getResults() {
        return results;
    }

    public void setResults(List<ResponseBase> results) {
        this.results = results;
    }
}

