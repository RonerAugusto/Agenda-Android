package br.com.inovert.agendasalvar;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.database.sqlite.*;
import android.database.*;

import br.com.inovert.agendasalvar.database.DataBase;


public class PrimeiraTela extends AppCompatActivity implements View.OnClickListener{


    private EditText edtAdicionar;
    private ImageButton btnAdicionar;
    private ListView lstContatos;
    private DataBase dataBase;
    private SQLiteDatabase  conn;
    //teste push









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);


        edtAdicionar=(EditText)findViewById(R.id.edtAdicionar);
        btnAdicionar=(ImageButton)findViewById(R.id.btnAdicionar);
        lstContatos=(ListView)findViewById(R.id.lstContato);
        btnAdicionar.setOnClickListener(this);


        try {


            //conexao com o banco
            dataBase = new DataBase(this);
            conn = dataBase.getReadableDatabase();

            AlertDialog.Builder dlg= new AlertDialog.Builder(this);
            dlg.setMessage("conectado com sucesso");
            dlg.setNeutralButton("OK", null);
            dlg.show();



          }catch (SQLException ex){

            AlertDialog.Builder dlgerro= new AlertDialog.Builder(this);
            dlgerro.setMessage("erro ao conectar ao banco"+ ex.getMessage());
            dlgerro.setNeutralButton("OK", null);
            dlgerro.show();




        }



    }


    @Override
    public void onClick(View v) {

        Intent it = new Intent(this, SegundaTela.class);
       // it.putExtra("VALOR", edtAdicionar.getText().toString());
        startActivity(it);
    }
}
