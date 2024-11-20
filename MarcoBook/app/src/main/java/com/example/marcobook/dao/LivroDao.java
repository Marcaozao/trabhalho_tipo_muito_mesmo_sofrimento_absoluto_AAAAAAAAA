package com.example.marcobook.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.marcobook.helper.SQLiteDataHelper;
import com.example.marcobook.model.Livro;

import java.util.ArrayList;

public class LivroDao implements IGenericDao<Livro>{

    //Variável responsável por abri a conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase baseDados;

    //nome das colunas da tabela
    private String[]colunas = {"RA","NOME"};

    //Nome da tabela
    private String tabela = "ALUNO";

    //Contexto
    private Context context;

    private static LivroDao instancia;

    public static LivroDao getInstance(Context context){
        if(instancia == null) {
            instancia = new LivroDao(context);
        }
        return instancia;
    }

    private LivroDao(Context context) {
        this.context = context;

        //Abrir a Conexao com a base de dados
        openHelper = new SQLiteDataHelper(this.context,
                "MARCOBOOK_DB", null, 1);

        baseDados = openHelper.getWritableDatabase();

    }

    /**
     * Método para inserir dados na tabela ALUNO
     * @param obj Livro
     * @return a linha que foi inserido o registro
     */
    @Override
    public long insert(Livro obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getNome());
            valores.put(colunas[1], obj.getPreco());
            valores.put(colunas[2], obj.getQuant_vendas());

            return baseDados.insert(tabela, null, valores);

        }catch (SQLException ex){
            Log.e("UNIPAR",
                    "ERRO: LivroDao.insert() "+
                    ex.getMessage());
        }

        return 0;
    }

    /**
     * Atualizar registro na tabela livro
     * @param obj Livro
     * @return
     */
    @Override
    public long update(Livro obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());

            String[]identificador =
                    {String.valueOf(obj.getNome())};

            return baseDados.update(tabela,
                    valores,
                    colunas[0]+"= ?",
                    identificador);

        }catch (SQLException ex){
            Log.e("UNIPAR",
                    "ERRO: LivroDao.update() "+
                            ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Livro obj) {
        try{
            String[]identificador =
                    {String.valueOf(obj.getNome())};

            return baseDados.delete(tabela,
                    colunas[0]+" = ?",
                    identificador);

        }catch (SQLException ex){
            Log.e("UNIPAR",
                    "ERRO: LivroDao.delete() "+
                            ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Livro> getAll() {
        ArrayList lista = new ArrayList<>();
        try{
            //SELECT * FROM ALUNO
            Cursor cursor = baseDados.query(tabela,
                    colunas, null, null,
                    null, null, colunas[0]);


            cursor.close();
            return lista;

        }catch (SQLException ex){
            Log.e("LIVRO",
                    "ERRO: LivroDao.getAll() "+
                            ex.getMessage());
        }

        return null;
    }

    @Override
    public Livro getById(int id) {
        try{
            String[]identificador =
                    {String.valueOf(id)};

            Cursor cursor = baseDados.query(tabela,
                    colunas, colunas[0]+" = ?",
                    identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Livro livro = new Livro();/*
                livro.setRa(cursor.getInt(0));
                livro.setNome(cursor.getString(1));*/

                cursor.close();
                return livro;
            }
        }catch (SQLException ex){
            Log.e("LIVRO",
                    "ERRO: LivroDao.getById() "+
                            ex.getMessage());
        }
        return null;
    }
}
