package br.com.inovert.agendasalvar.consultanobanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

import br.com.inovert.agendasalvar.Entidade.Contato;

/**
 * Created by roner on 22/07/15.
 */
public class RepositorioContato {

    //parametro para conecao.
    private SQLiteDatabase conn;

    public RepositorioContato(SQLiteDatabase conn) {

        this.conn=conn;
    }


        public void inserir (Contato contato)
        {
            ContentValues values= new ContentValues();
            values.put("NOME",                 contato.getNome());
            values.put("TELEFONE",             contato.getTelefone());
            values.put("TIPOTELEFONE",         contato.getTipoTelefone());
            values.put("EMAIL",                contato.getEmail());
            values.put("TIPOEMAIL",            contato.getTipoEmail());
            values.put("ENDERECO",             contato.getEndereço());
            values.put("TIPOENDERECO",         contato.getTipoEndereço());
            values.put("DATASESPECIAIS",        contato.getData().getTime());
            values.put("TIPODATASESPECIAIS",   contato.getTipoData());
            values.put("GRUPOS",                contato.getGrupos());


            conn.insertOrThrow("Contato",null,values);




        }



      public ArrayAdapter<Contato> buscacontato(Context context)
      {

         //metodo que fara aperecer no meu listvew a lista que buscarei no banco
        ArrayAdapter<Contato> adpContato = new ArrayAdapter<Contato>(context, android.R.layout.simple_list_item_1);


        Cursor cursor=conn.query("CONTATO",null,null,null,null,null,null);

         if (cursor.getCount() > 0){//verifico se ha registros no meu banco


             cursor.moveToFirst();//movo para o inicio do

             do
             {
                  Contato pegacontato = new Contato();
                  pegacontato.setNome(cursor.getString(1)+"\n ");
                  pegacontato.setTelefone(cursor.getString(2));

                //metodo cursos pega o valor da minha coluna 1 q e nome
                 adpContato.add(pegacontato);
             }
             while (cursor.moveToNext());



         }


          return adpContato; //retorno o metodo para o buscacontato




      }
}
