package apps.sinterklas.punteunbandung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenuAdmin extends AppCompatActivity {
    Button Ambulance, Police, Events, Place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // launch settings activity
            startActivity(new Intent(MainMenuAdmin.this, SettingsActivity.class));
            return true;
        }
        switch (item.getItemId()){
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onEventsButton (View view){
        Events = (Button) findViewById(R.id.button2);
        Events.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argo) {
                Intent i = new Intent(MainMenuAdmin.this, InputEventActivity.class);
                startActivity(i);
            }
        });
    }

    public void onPlacesButton (View view){
        Place = (Button) findViewById(R.id.button3);
        Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainMenuAdmin.this, InputPlaceActivity.class);
                startActivity(a);
            }
        });
    }

    public void onGuiderButton (View view){
        Place = (Button) findViewById(R.id.button4);
        Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainMenuAdmin.this, InputGuiderActivity.class);
                startActivity(a);
            }
        });
    }

    public void onHotelButton (View view){
        Place = (Button) findViewById(R.id.button1);
        Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainMenuAdmin.this, InputHotelActivity.class);
                startActivity(a);
            }
        });
    }


}
