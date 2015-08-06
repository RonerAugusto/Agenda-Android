package br.com.inovert.agendasalvar.database;

/**
 * Created by roner on 20/07/15.
 */

import android.content.Context;
import android.database.sqlite.*;


public class DataBase extends  SQLiteOpenHelper {


    public DataBase (Context context){

        super(context, "AGENDA2", null, 3);  //conexao com o banco


    }



    //comandos no banco persistencia
    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(ComandoSQL.getCreateContato());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
