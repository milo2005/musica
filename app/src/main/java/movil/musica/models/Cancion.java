package movil.musica.models;

/**
 * Created by Dario Chamorro on 25/04/2016.
 */
public class Cancion {

    String titulo, genero, autor, duracion, album, imagen, imagenArtista;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagenArtista() {
        return imagenArtista;
    }

    public void setImagenArtista(String imagenArtista) {
        this.imagenArtista = imagenArtista;
    }
}
