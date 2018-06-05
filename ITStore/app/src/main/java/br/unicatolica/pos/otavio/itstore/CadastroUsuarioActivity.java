package br.unicatolica.pos.otavio.itstore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CadastroUsuarioActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView tvEmail;
    private TextView tvPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        mAuth = FirebaseAuth.getInstance();
        tvEmail = findViewById(R.id.email);
        tvPassword = findViewById(R.id.senha);
    }
    public void onClickSalvar(View view) {
        final Intent intent = new Intent(CadastroUsuarioActivity.this,
                LoginActivity.class);


        mAuth.createUserWithEmailAndPassword(tvEmail.getText().toString(), tvPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(intent);
                            finish();
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("ERRO", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CadastroUsuarioActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
