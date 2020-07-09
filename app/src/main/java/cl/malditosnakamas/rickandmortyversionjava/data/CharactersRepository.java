package cl.malditosnakamas.rickandmortyversionjava.data;

import cl.malditosnakamas.rickandmortyversionjava.model.Characters;
import io.reactivex.Single;

public interface CharactersRepository {
    Single<Characters> getAll();
}
