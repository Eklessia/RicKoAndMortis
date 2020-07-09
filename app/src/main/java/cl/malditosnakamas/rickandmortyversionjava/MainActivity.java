package cl.malditosnakamas.rickandmortyversionjava;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cl.malditosnakamas.rickandmortyversionjava.data.CharactersRepository;
import cl.malditosnakamas.rickandmortyversionjava.data.RemoteCharacterRepository;
import cl.malditosnakamas.rickandmortyversionjava.data.api.RetrofitManager;
import cl.malditosnakamas.rickandmortyversionjava.model.Characters;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private CharactersRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new RemoteCharacterRepository(RetrofitManager.getCharacterApi());

        Single<Characters> charactersSingle = repository.getAll();

        charactersSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults, this::handleError);
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(this, "Error al intentar leer la api rest", Toast.LENGTH_LONG).show();
    }

    private void handleResults(Characters characters) {
        Toast.makeText(this, "Listos api rest ;) " + characters.getCharacters().size(), Toast.LENGTH_LONG).show();
    }
}