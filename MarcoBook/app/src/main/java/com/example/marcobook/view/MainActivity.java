package com.example.marcobook.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.Cursor;

import com.example.marcobook.R;
import com.example.marcobook.helper.SQLiteDataHelper;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    private LinearLayout ll_carrinho, ll_favoritos, ll_menu;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        ll_carrinho = findViewById(R.id.ll_carrinho);
        ll_favoritos = findViewById(R.id.ll_favoritos);
        ll_menu = findViewById(R.id.ll_menu);

        ll_carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                startActivity(intent);

            }
        });

        ll_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                startActivity(intent);

            }
        });

        ll_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });

            SQLiteDataHelper dbHelper = new SQLiteDataHelper(this);

            // Abrindo o banco de dados no modo leitura
            db = dbHelper.getWritableDatabase();

            // Inserindo dados de exemplo
            inserirDados();

            // Consultando e exibindo os 3 produtos mais caros
            mostrarProdutosMaisCaros();
        }

    // Função para inserir dados no banco de dados
    private void inserirDados() {
        db.execSQL("INSERT INTO produto (nome, preco, quant_vendas) VALUES ('Produto A', 100.0, 50)");
        db.execSQL("INSERT INTO produto (nome, preco, quant_vendas) VALUES ('Produto B', 150.0, 30)");
        db.execSQL("INSERT INTO produto (nome, preco, quant_vendas) VALUES ('Produto C', 200.0, 20)");
        db.execSQL("INSERT INTO produto (nome, preco, quant_vendas) VALUES ('Produto D', 50.0, 200)");
        db.execSQL("INSERT INTO produto (nome, preco, quant_vendas) VALUES ('Produto E', 120.0, 60)");
    }

    // Função para consultar os 3 produtos mais caros e exibir nos TextViews
    private void mostrarProdutosMaisCaros() {
        // Realizando a consulta ordenada pelo preço, do maior para o menor
        Cursor cursor = db.rawQuery("SELECT nome, preco FROM produto ORDER BY preco DESC LIMIT 3", null);

        // Verificando se a consulta retornou resultados
        if (cursor != null && cursor.moveToFirst()) {
            // Produto 1
            String nomeProduto1 = cursor.getString(cursor.getColumnIndex("nome"));
            double precoProduto1 = cursor.getDouble(cursor.getColumnIndex("preco"));
            textViewProduto1.setText("Nome: " + nomeProduto1 + "\nPreço: R$" + precoProduto1);

            // Produto 2
            if (cursor.moveToNext()) {
                String nomeProduto2 = cursor.getString(cursor.getColumnIndex("nome"));
                double precoProduto2 = cursor.getDouble(cursor.getColumnIndex("preco"));
                textViewProduto2.setText("Nome: " + nomeProduto2 + "\nPreço: R$" + precoProduto2);
            }

            // Produto 3
            if (cursor.moveToNext()) {
                String nomeProduto3 = cursor.getString(cursor.getColumnIndex("nome"));
                double precoProduto3 = cursor.getDouble(cursor.getColumnIndex("preco"));
                textViewProduto3.setText("Nome: " + nomeProduto3 + "\nPreço: R$" + precoProduto3);
            }

            cursor.close(); // Fechando o cursor
        } else {
            // Caso não haja produtos ou algum erro
            textViewProduto1.setText("Nenhum produto encontrado.");
            textViewProduto2.setText("");
            textViewProduto3.setText("");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null && db.isOpen()) {
            db.close(); // Fechar o banco de dados
        }

    }
}