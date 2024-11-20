package com.example.marcobook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marcobook.R;

public class CarrinhoActivity extends AppCompatActivity {

    private LinearLayout ll_inicio, ll_favoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrinho);

        ll_inicio = findViewById(R.id.ll_inicio);
        ll_favoritos = findViewById(R.id.ll_favoritos);

        ll_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CarrinhoActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        ll_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CarrinhoActivity.this, FavoritosActivity.class);
                startActivity(intent);

            }
        });

    }
}