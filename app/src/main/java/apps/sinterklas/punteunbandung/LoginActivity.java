package apps.sinterklas.punteunbandung;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private Button Login, Register, LoginAsAdmin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        getSupportActionBar().setTitle("User Login Form");

        Register = (Button)findViewById(R.id.email_register_button);
        Register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argo) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
        LoginAsAdmin = (Button) findViewById(R.id.admin_login_button);
        LoginAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getApplicationContext(), AdminLoginActivity.class);
                startActivity(j);
            }});


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.email_sign_in_button);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(LoginActivity.this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String e_mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (TextUtils.isEmpty(e_mail)) {
                    Toast.makeText(LoginActivity.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(LoginActivity.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.length() < 10) {
                    Toast.makeText(LoginActivity.this, "Email is Too Short", Toast.LENGTH_SHORT).show();
                }
                if (pass.length() < 6) {
                    Toast.makeText(LoginActivity.this, "Password is Too Short", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.signInWithEmailAndPassword(e_mail, pass)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    startActivity(new Intent(getApplicationContext(), MainMenu.class));

                                } else {

                                    Toast.makeText(LoginActivity.this, "Login Failed or User not Available", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    public void onRegisterUser(View view) {
    }

    public void onAdminLogin(View view) {
    }
}