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

public class AdminLoginActivity extends AppCompatActivity {
  private EditText username, email, password;
  private Button Login, Register;
  private FirebaseAuth firebaseAuth;

  @Override
  protected void onCreate(Bundle savedInstanceState)  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin_login);
    getSupportActionBar().setTitle("Admin Login Form");

    Register =(Button)findViewById(R.id.button7);
    Register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(), AdminRegisterActivity.class);
        startActivity(i);
      }
    });

    username = (EditText)findViewById(R.id.Username);
    email = (EditText)findViewById(R.id.editText);
    password = (EditText)findViewById(R.id.Password);
    Login = (Button)findViewById(R.id.button3);

    firebaseAuth = FirebaseAuth.getInstance();
    FirebaseApp.initializeApp(AdminLoginActivity.this);

    Login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        String user = username.getText().toString().trim();
        String e_mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (TextUtils.isEmpty(user)) {
          Toast.makeText(AdminLoginActivity.this, "Enter Your Username", Toast.LENGTH_SHORT).show();
          return;
        }
        if (TextUtils.isEmpty(e_mail)) {
          Toast.makeText(AdminLoginActivity.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
          return;
        }
        if (TextUtils.isEmpty(pass)) {
          Toast.makeText(AdminLoginActivity.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
          return;
        }
        if (user.length() < 8) {
          Toast.makeText(AdminLoginActivity.this, "Username is Too Short", Toast.LENGTH_SHORT).show();
        }
        if (email.length() < 10) {
          Toast.makeText(AdminLoginActivity.this, "Email is Too Short", Toast.LENGTH_SHORT).show();
        }
        if (pass.length() < 6) {
          Toast.makeText(AdminLoginActivity.this, "Password is Too Short", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.signInWithEmailAndPassword(e_mail, pass)
                .addOnCompleteListener(AdminLoginActivity.this, new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {

                      startActivity(new Intent(getApplicationContext(),MainMenuAdmin.class));

                    }else{

                      Toast.makeText(AdminLoginActivity.this, "Login Failed or User not Available", Toast.LENGTH_SHORT).show();
                    }
                  }
                });
      }
    });
  }
}
