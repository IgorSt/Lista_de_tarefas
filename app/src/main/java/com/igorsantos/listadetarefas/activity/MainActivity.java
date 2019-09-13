package com.igorsantos.listadetarefas.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.igorsantos.listadetarefas.R;
import com.igorsantos.listadetarefas.adapter.TarefaAdapter;
import com.igorsantos.listadetarefas.helper.RecyclerItemClickListener;
import com.igorsantos.listadetarefas.model.Tarefa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaTarefas;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaDeTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //configura o RecycleView
        recyclerViewListaTarefas = findViewById(R.id.recyclerViewListaTarefas);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_adicionar_tarefa.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaTarefas(){
        //listar tarefas (recuperar do banco de dados)
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNomeDaTarefa("Ir ao supermercado");
        listaDeTarefas.add(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNomeDaTarefa("Ir a feira");
        listaDeTarefas.add(tarefa2);

        //configura o adapter
        tarefaAdapter = new TarefaAdapter(listaDeTarefas);

        //adiciona o evento de clique
        recyclerViewListaTarefas.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerViewListaTarefas, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.i("clique", "onItemClick");
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Log.i("clique", "onLongItemClick");
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }));

        //configura o recycleView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewListaTarefas.setLayoutManager(layoutManager);
        recyclerViewListaTarefas.setHasFixedSize(true);
        recyclerViewListaTarefas.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerViewListaTarefas.setAdapter(tarefaAdapter);
    }

    @Override
    protected void onStart() {
        carregarListaTarefas();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
