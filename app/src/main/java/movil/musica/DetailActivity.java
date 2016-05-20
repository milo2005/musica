package movil.musica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import movil.musica.databinding.ActivityDetailBinding;
import movil.musica.models.Cancion;
import movil.musica.util.C;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding b = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setSupportActionBar(b.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int pos =  getIntent().getIntExtra("pos",0);

        Cancion c = (Cancion) C.inicio.get(pos);

        b.setCancion(c);

    }
}
