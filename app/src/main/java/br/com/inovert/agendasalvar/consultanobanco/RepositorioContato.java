package br.com.inovert.agendasalvar.consultanobanco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

/**
 * Created by roner on 22/07/15.
 */
public class RepositorioContato {


    private SQLiteDatabase conn;

    public void conection (SQLiteDatabase conn)
    {


        this.conn=conn;

    }

      public ArrayAdapter<String> buscacontato(Context context)
      {

         //metodo que fara aperecer no meu listvew a lista que buscarei no banco
        ArrayAdapter<String> adpContato = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);


        Cursor cursor=conn.query("CONTATO",null,null,null,null,null,null);

         if (cursor.getCount() > 0){

             do
             {

                 String telefone = cursor.getString(1); //metodo cursos pega o valor da minha coluna 1 q e telefone
                 adpContato.add(telefone);
             }
             while (cursor.moveToNext());



         }


          return adpContato; //retorno o metodo para o buscacontato




      }
}
