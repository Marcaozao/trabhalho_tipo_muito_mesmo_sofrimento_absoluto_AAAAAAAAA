package com.example.marcobook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marcobook.R;

public class FavoritosActivity extends AppCompatActivity {

    private LinearLayout ll_inicio, ll_carrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);

        ll_inicio = findViewById(R.id.ll_inicio);
        ll_carrinho = findViewById(R.id.ll_carrinho);

        ll_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FavoritosActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        ll_carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FavoritosActivity.this, CarrinhoActivity.class);
                startActivity(intent);

            }
        });

    }
}
