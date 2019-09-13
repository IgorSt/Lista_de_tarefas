package com.igorsantos.listadetarefas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.igorsantos.listadetarefas.R;
import com.igorsantos.listadetarefas.model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MinhaViewHolder> {

    private List<Tarefa> listaDeTarefas;

    public TarefaAdapter(List<Tarefa> lista) {
        this.listaDeTarefas = lista;
    }

    @NonNull
    @Override
    public MinhaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new MinhaViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MinhaViewHolder holder, int position) {

        Tarefa tarefa = listaDeTarefas.get(position);
        holder.tarefa.setText(tarefa.getNomeDaTarefa());

    }

    @Override
    public int getItemCount() {
        return this.listaDeTarefas.size();
    }

    public class MinhaViewHolder extends RecyclerView.ViewHolder{

        TextView tarefa;

        public MinhaViewHolder(@NonNull View itemView) {
            super(itemView);

            tarefa = itemView.findViewById(R.id.textViewTarefa);
        }
    }
}
