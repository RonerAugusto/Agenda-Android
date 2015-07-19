package br.com.inovert.agendasalvar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.content.*;


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
                break;
            case R.id.mni_acao3:
                break;


        }



        return super.onOptionsItemSelected(item);
    }

    //young  listening my buttons
    @Override
    public void onClick(View v) {

    }
}
