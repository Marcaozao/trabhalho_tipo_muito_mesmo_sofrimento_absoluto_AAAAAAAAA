package com.example.marcobook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marcobook.R;
import com.example.marcobook.model.Livro;

import java.util.ArrayList;
/*
public class LivroListAdapter extends
          RecyclerView.Adapter<LivroListAdapter.ViewHolder> {
/*
    private ArrayList<Livro> listaLivros;
    private Context context;

    public LivroListAdapter(ArrayList<Livro> listaLivros,
                            Context context) {
        this.listaLivros = listaLivros;
        this.context = context;
    }

    /**
     * Método responsável em carregar o
     * arquivo xml para cada elemento da lista
     * @return
     */
    /*
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                LayoutInflater.from(parent.getContext());

        View listItem =
                inflater.inflate(R.layout.item_list_Livro,
                        parent, false);

        return new ViewHolder(listItem);
    }

    /**
     * Método responsável em escrever os dados no layout
     */
    /*
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Livro livro = listaLivros.get(position);
        /*holder.tvRa.setText(String.valueOf(livro.getRa()));
        holder.tvNome.setText(Livro.getNome());*//*
    }
    @Override
    public int getItemCount() {
        return listaLivros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvRa, tvNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvRa = itemView.findViewById(R.id.tvRa);
            this.tvNome = itemView.findViewById(R.id.tvNome);
        }
    }
}*/
