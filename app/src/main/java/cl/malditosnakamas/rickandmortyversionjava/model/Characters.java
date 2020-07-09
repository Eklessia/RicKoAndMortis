package cl.malditosnakamas.rickandmortyversionjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Characters {

    @SerializedName("results")
    private List<Character> characters;

    public Characters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}

