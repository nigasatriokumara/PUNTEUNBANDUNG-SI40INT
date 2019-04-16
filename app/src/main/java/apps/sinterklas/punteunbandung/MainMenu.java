package apps.sinterklas.punteunbandung;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button Ambulance, Police, Events, Place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
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
            startActivity(new Intent(MainMenu.this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

        public void onAmbulanceButton (View view){
            Ambulance = findViewById(R.id.button8);

            String number = "022-118";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        }

        public void onPoliceButton (View view){
            Police = findViewById(R.id.button7);

            String number = "022-7800166";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        }

        public void onEventsButton (View view){
            Events = (Button) findViewById(R.id.button4);
            Events.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View argo) {
                    Intent i = new Intent(MainMenu.this, EventActivity.class);
                    startActivity(i);
                }
            });
        }

        public void onPlacesButton (View view){
            Place = (Button) findViewById(R.id.button6);
            Place.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(MainMenu.this, PlaceActivity.class);
                    startActivity(a);
                }
            });
        }
    }


