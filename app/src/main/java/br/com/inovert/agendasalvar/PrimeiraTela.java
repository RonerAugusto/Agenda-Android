package br.com.inovert.agendasalvar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class PrimeiraTela extends AppCompatActivity implements View.OnClickListener{


    private EditText edtAdicionar;
    private ImageButton btnAdicionar;
    private ListView lstContatos;
    //teste push









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);


        edtAdicionar=(EditText)findViewById(R.id.edtAdicionar);
        btnAdicionar=(ImageButton)findViewById(R.id.btnAdicionar);
        lstContatos=(ListView)findViewById(R.id.lstContato);

        btnAdicionar.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

    }
}
