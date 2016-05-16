package movil.musica.adapters;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import movil.musica.R;
import movil.musica.databinding.TemplateAlbumBinding;
import movil.musica.databinding.TemplateCancionBinding;
import movil.musica.models.Album;
import movil.musica.models.Cancion;
import movil.musica.models.Item;

/**
 * Created by Dario Chamorro on 13/05/2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    List<Item> data;
    View.OnClickListener onClickListener;

    public ItemAdapter(List<Item> data, LayoutInflater inflater, View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder v = null;

        if(viewType == Item.TYPE_SONG){
            v = new CancionViewHolder(inflater.inflate(R.layout.template_cancion,null));
        }else{
            v = new AlbumViewHolder(inflater.inflate(R.layout.template_album,null));
        }

        return v;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item i = data.get(position);
        if(i.getTipo() == Item.TYPE_SONG){
            CancionViewHolder h = (CancionViewHolder) holder;
            h.b.setSong((Cancion) i);
            h.b.getRoot().setOnClickListener(onClickListener);
        }else{
            AlbumViewHolder h = (AlbumViewHolder) holder;
            h.b.setAlbum((Album) i);
            h.b.getRoot().setOnClickListener(onClickListener);
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getTipo();
    }

    @Override
    public void onClick(View v) {

    }

    //region Creacion ViewHolders
    static class CancionViewHolder extends RecyclerView.ViewHolder{
        TemplateCancionBinding b;

        public CancionViewHolder(View itemView) {
            super(itemView);
            b = TemplateCancionBinding.bind(itemView);
        }
    }

    static class AlbumViewHolder extends RecyclerView.ViewHolder{
        TemplateAlbumBinding b;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            b = TemplateAlbumBinding.bind(itemView);
        }
    }
    //endregion

}

