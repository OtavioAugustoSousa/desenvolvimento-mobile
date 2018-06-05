package br.unicatolica.pos.otavio.itstore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView tvEmail;
    private TextView tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        tvEmail = findViewById(R.id.email);
        tvPassword = findViewById(R.id.senha);
    }

    public void onClickCadastrar(View v){
        Intent intent = new Intent(LoginActivity.this,
                CadastroUsuarioActivity.class);
        startActivity(intent);
        finish();
    }
    public void onClickEsqueciSenha(View v){
        Intent intent = new Intent(LoginActivity.this,
                EsqueciSenhaActivity.class);
        startActivity(intent);
        finish();
    }
    public void onClickLogar(View v){
        final Intent intent = new Intent(LoginActivity.this,
                ListaProdutosActivity.class);
        mAuth.signInWithEmailAndPassword(tvEmail.getText().toString(), tvPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

}
