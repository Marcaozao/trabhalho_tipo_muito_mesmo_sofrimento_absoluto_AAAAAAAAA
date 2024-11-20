package com.example.marcobook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marcobook.R;

public class PrivacidadeActivity extends AppCompatActivity {

    private LinearLayout ll_carrinho, ll_favoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.politica_privacidade);

        ll_carrinho = findViewById(R.id.ll_carrinho);
        ll_favoritos = findViewById(R.id.ll_favoritos);

        ll_carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PrivacidadeActivity.this, CarrinhoActivity.class);
                startActivity(intent);

            }
        });

        ll_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PrivacidadeActivity.this, FavoritosActivity.class);
                startActivity(intent);

            }
        });

    }

}
