package movil.musica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import movil.musica.databinding.ActivityMainBinding;
import movil.musica.databinding.HeaderNavBinding;
import movil.musica.fragments.InicioFragment;
import movil.musica.models.Album;
import movil.musica.models.Cancion;
import movil.musica.models.Usuario;
import movil.musica.util.C;


public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener, InicioFragment.OnItemClick {

    ActivityMainBinding b;
    ActionBarDrawerToggle toggle;

    InicioFragment inicio;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        preferences =  getSharedPreferences("preferencias", MODE_PRIVATE);

        //Configuracion Header

        HeaderNavBinding header = HeaderNavBinding.inflate(getLayoutInflater());
        Usuario u = new Usuario();
        u.setNombre("Dario Chamorro");
        u.setImagenBanner("http://i2.wp.com/hipertextual.com/files/2014/10/universo.jpg?resize=610%2C343");
        u.setImagen("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAANJAAAAJDBiOTY0ZjQ1LWEzNjItNDE1Zi1hN2FhLWY3NDE4YjYyNWIzNQ.jpg");

        header.setUsuario(u);
        b.nav.addHeaderView(header.getRoot());

        //Configuracion Boton Hamburguesa
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this,b.drawer,R.string.open_nav,R.string.close_nav);
        b.drawer.addDrawerListener(this);
        b.nav.setNavigationItemSelectedListener(this);

        //Configuracion de Datos
        C.inicio =  new ArrayList<>();
        inicio = new InicioFragment();
        FragmentTransaction fT = getSupportFragmentManager()
                .beginTransaction();

        fT.replace(R.id.container, inicio);

        fT.commit();

        loadData();


    }

    public void loadData(){
        Cancion c1 = new Cancion();
        c1.setTitulo("Miss Impossible");
        c1.setGenero("Rock");
        c1.setDuracion("3:30");
        c1.setAutor("Poets of the Fall");
        c1.setAlbum("Carnival");
        c1.setImagen("");
        c1.setImagenArtista("http://www.radiocremebrulee.com/wp-content/uploads/2014/08/PoetsOfTheFall-Daze.jpg");

        Cancion c2 = new Cancion();
        c2.setTitulo("Rattle that lock ");
        c2.setGenero("Rock");
        c2.setDuracion("3:30");
        c2.setAutor("David Guilmor");
        c2.setAlbum("Rattle");
        c2.setImagen("http://www.nacionrock.com/wp-content/uploads/rattle_that_lock_cover.jpg");
        c2.setImagenArtista("http://static.independent.co.uk/s3fs-public/thumbnails/image/2015/08/28/02/5864463.jpg");

        Album a1 =  new Album();
        a1.setNombre("AM");
        a1.setGenero("Indi");
        a1.setArtista("Artic Mokeys");
        a1.setCanciones(10);
        a1.setPrecio(30000);
        a1.setImagen("https://i.ytimg.com/vi/O4vkZUC4VPA/0.jpg");

        Cancion c3 = new Cancion();
        c3.setTitulo("Figure Out");
        c3.setGenero("Rock");
        c3.setDuracion("3:30");
        c3.setAutor("Royal blood");
        c3.setAlbum("Ratle");
        c3.setImagen("http://pad2.whstatic.com/images/thumb/a/a8/Figure-Out-a-Song-by-Ear-Step-3.jpg/aid93221-728px-Figure-Out-a-Song-by-Ear-Step-3.jpg");
        c3.setImagenArtista("http://lolp2.c3cdn.com/wp/wp-content/uploads/2014/03/Royal-Blood.jpg");

        C.inicio.add(c1);
        C.inicio.add(c2);
        C.inicio.add(a1);
        C.inicio.add(c3);

        inicio.notifyDataSet();

    }

    //region Preparacion de Boton Hamburguesa
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }


    //endregion

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        b.drawer.closeDrawers();
        switch (item.getItemId()){
            case R.id.nav_logout:
                SharedPreferences.Editor editor =  preferences.edit();
                editor.putBoolean("login", false);
                editor.commit();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return false;
    }

    @Override
    public void onClick(int pos) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("pos", pos);
        startActivity(intent);
    }
}
