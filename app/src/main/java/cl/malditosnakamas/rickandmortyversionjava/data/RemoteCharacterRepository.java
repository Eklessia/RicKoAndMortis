package cl.malditosnakamas.rickandmortyversionjava.data;

import cl.malditosnakamas.rickandmortyversionjava.model.Characters;
import io.reactivex.Single;

public class RemoteCharacterRepository implements CharactersRepository {

    private CharacterApi characterApi;

    public RemoteCharacterRepository(CharacterApi characterApi) {
        this.characterApi = characterApi;
    }

    @Override
    public Single<Characters> getAll() {
        return characterApi.getAllCharacter();
    }
}
