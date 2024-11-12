package com.example.marcobook.controller;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.marcobook.dao.LivroDao;
import com.example.marcobook.model.Livro;

import java.util.ArrayList;

public class LivroController {

    private Context context;

    public LivroController(Context context) {
        this.context = context;
    }

    public String salvarLivro(String ra, String nome){
        try{
            if(TextUtils.isEmpty(ra)){
                return "Informe o RA do Livro";
            }
            if(TextUtils.isEmpty(nome)){
                return "Informe o NOME do Livro";
            }

            //Verifica se existe um livro cadastrado com
            // o RA informado
            Livro livro = LivroDao
                    .getInstance(context)
                    .getById(Integer.parseInt(ra));

            if(livro != null){
                return "O RA (" + ra + ") já está cadastrado.";
            }else{
                livro = new Livro();
                /*livro.setRa(Integer.parseInt(ra));
                livro.setNome(nome);*/

                long id = LivroDao.getInstance(context).insert(livro);

                if(id > 0)
                {

                    return "Livro cadastrado com sucesso!";

                }else
                {

                    return "Não foi possível gravar os dados do Livro." +
                            " Solicite suporte técnico.";
                }
            }


        }catch (Exception ex)
        {

            Log.e("Unipar",
                    "Erro salvarLivro(): "+ex.getMessage());

        }

        return "Erro ao gravar dados do Livro. " +
                "Solicite suporte técnico.";

    }

    public ArrayList<Livro> retornarTodosLivros(){
        return LivroDao.getInstance(context).getAll();
    }

}
