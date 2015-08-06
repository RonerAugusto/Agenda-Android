package br.com.inovert.agendasalvar.Dominio;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.database.sqlite.*;
import android.database.*;

import br.com.inovert.agendasalvar.Entidade.Contato;
import br.com.inovert.agendasalvar.R;
import br.com.inovert.agendasalvar.database.DataBase;
import br.com.inovert.agendasalvar.consultanobanco.RepositorioContato;



public class PrimeiraTela extends AppCompatActivity implements View.OnClickListener{


    private EditText edtAdicionar;
    private ImageButton btnAdicionar;
    private ListView lstContatos;

    //private ArrayAdapter<Contato> adpContato;


    //teste push


  //conexao
    private DataBase dataBase;
    private SQLiteDatabase conn;

    private RepositorioContato repositoriocontato;





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
            conn = dataBase.getWritableDatabase();

            repositoriocontato=new RepositorioContato(conn);
            //adpContato=repositoriocontato.buscacontato(this);

            lstContatos.setAdapter(repositoriocontato.buscacontato(this));





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
        startActivityForResult(it,0); //sera retornado um valor do activiry segunda tela
        //que pegarei pelo metodo abaixo onResult
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        lstContatos.setAdapter(repositoriocontato.buscacontato(this));
        //depois que processar os dados da primeira segundatela
        //ira vir o processamento para ca e exucutara o trecha a cima
    }
}
