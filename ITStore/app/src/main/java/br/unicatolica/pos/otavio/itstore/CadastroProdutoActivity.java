package br.unicatolica.pos.otavio.itstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.unicatolica.pos.otavio.itstore.model.Produto;

public class CadastroProdutoActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myReference;
    private TextView tvNome;
    private TextView tvPreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        database = FirebaseDatabase.getInstance();
        myReference = database.getReference("produto");
        tvNome = findViewById(R.id.nome);
        tvPreco = findViewById(R.id.preco);
    }

    public void onSave(View v){
        Produto produto = new Produto(tvNome.getText().toString(),tvPreco.getText().toString());
        myReference.push().setValue(produto);
        finish();
    }
}
