package br.unicatolica.pos.otavio.itstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicatolica.pos.otavio.itstore.model.Produto;

public class ListaProdutosActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView recyclerView;
    private ProdutosAdapter produtosAdapter;
    private String TAG = "Produtos";

    private FirebaseDatabase database;
    private DatabaseReference myReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        recyclerView = findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        database = FirebaseDatabase.getInstance();
        myReference = database.getReference("produto");
        final List<Produto> produtos = new ArrayList<>();
        final ProdutosAdapter produtosAdapter = new ProdutosAdapter(produtos, new ProdutosAdapter.OnItemClick() {
            @Override
            public void onClick(Produto produto) {
                Intent intent = new Intent(ListaProdutosActivity.this,
                        DetalhesActivity.class);
                intent.putExtra("produto", produto);
                startActivity(intent);
            }

            @Override
            public void onLongClick(Produto produto) {
                myReference.child(produto.getUid()).removeValue();
            }
        });
        recyclerView.setAdapter(produtosAdapter);

        myReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Produto post = dataSnapshot.getValue(Produto.class);
                post.setUid(dataSnapshot.getKey());
                produtos.add(post);
                produtosAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                produtosAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onClickAdd(View v){
        Intent intent = new Intent(ListaProdutosActivity.this,
                CadastroProdutoActivity.class);
        startActivity(intent);
    }

}
