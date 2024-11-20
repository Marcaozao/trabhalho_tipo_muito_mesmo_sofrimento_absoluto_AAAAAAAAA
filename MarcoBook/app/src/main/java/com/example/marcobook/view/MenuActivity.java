package com.example.marcobook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marcobook.R;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout ll_marco, ll_favoritos, ll_carrinho, ll_pagamento, ll_privacidade, ll_troca, ll_cashback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ll_marco = findViewById(R.id.ll_marco);
        ll_favoritos = findViewById(R.id.ll_favoritos);
        ll_carrinho = findViewById(R.id.ll_carrinho);
        ll_pagamento = findViewById(R.id.ll_pagamento);
        ll_privacidade = findViewById(R.id.ll_privacidade);
        ll_troca = findViewById(R.id.ll_troca);
        ll_cashback = findViewById(R.id.ll_cashback);

        ll_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, FavoritosActivity.class);
                startActivity(intent);

            }
        });

        ll_carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, CarrinhoActivity.class);
                startActivity(intent);

            }
        });

    }
}