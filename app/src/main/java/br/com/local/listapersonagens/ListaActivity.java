package br.com.local.listapersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaActivity extends AppCompatActivity {

    ListView listView;

    String nomePersonagens[] = {
            "Monkey D. Luffy",
            "Roronoa Zoro",
            "Vinsmoke Sanji",
            "Nami",
            "Usopp",
            "Tony Tony Chopper",
            "Nico Robin",
            "Franky",
            "Brook"
    };
    int imgPersonagens[] = {
            R.drawable.luffy,
            R.drawable.zoro,
            R.drawable.sanji,
            R.drawable.nami,
            R.drawable.usopp,
            R.drawable.chopper,
            R.drawable.robin,
            R.drawable.franky,
            R.drawable.brook
    };
    String descPersonagens[] = {
            "Capitão da tripulação dos Chapéus de Palha",
            "Braço direito de Luffy, leal espadachim",
            "Cozinheiro da tripulação dos Chapéus de Palha",
            "Navegadora dos Chapéus de Palha",
            "Franco-atirador da tripulação dos Chapéus de Palha",
            "Médico da tripulação dos Chapéus de Palha",
            "Arqueóloga da tripulação dos Chapéus de Palha",
            "Carpinteiro e construtor do Thousand Sunny (navio) dos Chapéus de Palha",
            "Músico da tripulação dos Chapéus de Palha"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_layout);

        listView = findViewById(R.id.listaLayout);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        //Evento de click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), MostrarPersonagemActivity.class);

                intent.putExtra("nomePersonagens", nomePersonagens[position]);
                intent.putExtra("imgPersonagens", imgPersonagens[position]);
                intent.putExtra("descPersonagens", descPersonagens[position]);

                startActivity(intent);
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgPersonagens.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //Modelo listaView
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView txtNomePersonagem;
            ImageView imgPersonagem;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_layout, null);

            txtNomePersonagem = carregaView.findViewById(R.id.txtListaPersonagem);
            imgPersonagem = carregaView.findViewById(R.id.imgListaPersonagem);

            txtNomePersonagem.setText(nomePersonagens[position]);
            imgPersonagem.setImageResource(imgPersonagens[position]);

            return carregaView;
        }
    }
}