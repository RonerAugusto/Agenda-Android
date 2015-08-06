package br.com.inovert.agendasalvar.Dominio;

import android.app.AlertDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import android.content.*;


import java.util.Date;

import br.com.inovert.agendasalvar.Entidade.Contato;
import br.com.inovert.agendasalvar.R;
import br.com.inovert.agendasalvar.consultanobanco.RepositorioContato;
import br.com.inovert.agendasalvar.database.DataBase;



public class SegundaTela extends AppCompatActivity implements View.OnClickListener {

   //declaraçao dos objetos
    //a que usei para dar push


    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtEmail;
    private EditText edtEndereco;
    private EditText edtData;
    private EditText edtGrupo;

    private Spinner spnTelefone;
    private Spinner spnEmail;
    private Spinner spnEndereco;
    private Spinner spnData;

    private ArrayAdapter<String> adpTelefone;
    private ArrayAdapter<String> adpEmail;
    private ArrayAdapter<String> adpEndereco;
    private ArrayAdapter<String> adpData;


    //conexao

    private SQLiteDatabase conn;
    private DataBase database;
    private RepositorioContato repositorioContato;
    private Contato contato;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        //aqui recupero as referencias do objeto

        edtNome=(EditText)findViewById(R.id.edtNome);
        edtTelefone=(EditText)findViewById(R.id.edtTelefone);
        edtEndereco=(EditText)findViewById(R.id.edtEnderco);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtData=(EditText)findViewById(R.id.edtData);
        edtGrupo=(EditText)findViewById(R.id.edtGrupo);

        spnTelefone=(Spinner)findViewById(R.id.spnTelefone);
        spnEmail=(Spinner)findViewById(R.id.spnEmail);
        spnEndereco=(Spinner)findViewById(R.id.spnEndereco);
        spnData=(Spinner)findViewById(R.id.spnData);


         //instacia dos objetos do tipo arrayadpter
        adpTelefone= new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item); //instaciando meu array
        adpTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //exibe os itens do spinner

        adpEmail= new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        adpEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpEndereco=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpData=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //vinculaçao dos spinner com seus respectivos arrays
        spnTelefone.setAdapter(adpTelefone);
        spnEmail.setAdapter(adpEmail);
        spnEndereco.setAdapter(adpEndereco);
        spnData.setAdapter(adpData);

        //adicionando campos
        adpTelefone.add("Celular");
        adpTelefone.add("Residencial");
        adpTelefone.add("Trabalho");

        adpEmail.add("Pessoal");
        adpEmail.add("Trabalho");

        adpEndereco.add("Residencial");
        adpEndereco.add("Empresa");

        adpData.add("Aniversario");
        adpData.add("DataComemorativa");

        try {


            //conexao com o banco
            database=new DataBase(this);
            conn=database.getWritableDatabase();

            repositorioContato= new RepositorioContato(conn);








        }catch (SQLException ex){

            AlertDialog.Builder dlgerro= new AlertDialog.Builder(this);
            dlgerro.setMessage("erro ao conectar ao banco"+ ex.getMessage());
            dlgerro.setNeutralButton("OK", null);
            dlgerro.show();




        }













    }



   //esse metodo e responsavel por associar meu res/menu com o metodo principal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_segunda_tela, menu);



        return super.onCreateOptionsMenu(menu);



    }

    //metodo que escuta o clique do menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mni_acao1:


            if (contato == null)
            {
                inserir();



            }
                finish();



                break;



            case R.id.mni_acao3:
                break;


        }



        return super.onOptionsItemSelected(item);
    }

           private void inserir ()

           {
               try
               {
                   contato = new Contato();

                   contato.setNome(edtNome.getText().toString());
                   contato.setTelefone(edtTelefone.getText().toString());
                   contato.setEmail(edtEmail.getText().toString());
                   contato.setEndereço(edtEndereco.getText().toString());
                   contato.setGrupos(edtGrupo.getText().toString());

                   Date date = new Date();
                   contato.setData(date);


                   contato.setTipoTelefone("");
                   contato.setTipoEmail("");
                   contato.setTipoEndereço("");
                   contato.setTipoData("");


                   repositorioContato.inserir(contato);
               } catch (Exception except)
               {

                   AlertDialog.Builder alert= new  AlertDialog.Builder(this);
                   alert.setMessage("erro ocorreu ao inserir" +except.getMessage());
                   alert.setNeutralButton("OK", null);
                   alert.show();

               }







           }







    //young are listening my buttons
    @Override
    public void onClick(View v) {

    }
}
