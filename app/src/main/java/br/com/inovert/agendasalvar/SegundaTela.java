package br.com.inovert.agendasalvar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class SegundaTela extends AppCompatActivity  {


    private EditText edtNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);


        edtNome=(EditText)findViewById(R.id.edtNome);

    }




}
