package movil.musica.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import movil.musica.R;
import movil.musica.adapters.ItemAdapter;
import movil.musica.util.C;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment implements View.OnClickListener {


    public interface OnItemClick{
        void onClick(int pos);
    }

    ItemAdapter adapter;
    RecyclerView recycler;
    OnItemClick onItemClick;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onItemClick = (OnItemClick) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_inicio, container, false);
        recycler  = (RecyclerView) v.findViewById(R.id.recycle);

        adapter =  new ItemAdapter(C.inicio, getLayoutInflater(null),this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }


    public void notifyDataSet(){
        if(adapter != null)
            adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int pos = recycler.getChildAdapterPosition(v);
        onItemClick.onClick(pos);
    }
}
