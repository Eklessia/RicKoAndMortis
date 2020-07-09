package cl.malditosnakamas.rickandmortyversionjava.data;

import cl.malditosnakamas.rickandmortyversionjava.model.Characters;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface CharacterApi {
    @GET("character")
    Single<Characters> getAllCharacter();
}
