package movil.musica.models;

/**
 * Created by Dario Chamorro on 13/05/2016.
 */
public class Item {

    public static final int TYPE_SONG = 0;
    public static final int TYPE_ALBUM = 1;

    int tipo;

    public int getTipo() {
        return tipo;
    }

}
