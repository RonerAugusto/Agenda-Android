package br.com.inovert.agendasalvar;

/**
 * Created by roner on 20/07/15.
 */

import android.content.Context;
import android.database.sqlite.*;
import android.renderscript.Script;


public class DataBase extends  SQLiteOpenHelper {


    public DataBase (Context context){

        super(context, "AGENDA", null, 1);  //conexao com o banco


    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(ComandoSQL.getCreateContato());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
