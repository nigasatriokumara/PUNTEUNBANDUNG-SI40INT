package apps.sinterklas.punteunbandung;

import android.Manifest;
<<<<<<< HEAD
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
=======
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.strictmode.IntentReceiverLeakedViolation;
>>>>>>> 18d0727a885fa49ee824c195f0ad0aaa28cbd429
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
=======
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
>>>>>>> 18d0727a885fa49ee824c195f0ad0aaa28cbd429

public class MainMenu extends AppCompatActivity {
    Button Ambulance, Police, Events, Place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
<<<<<<< HEAD
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
=======
>>>>>>> 18d0727a885fa49ee824c195f0ad0aaa28cbd429

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
<<<<<<< HEAD
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
        switch (item.getItemId()){
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));

                break;
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
                    Intent i = new Intent(MainMenu.this, FeedEventActivity.class);
                    startActivity(i);
                }
            });
        }

        public void onPlacesButton (View view){
            Place = (Button) findViewById(R.id.button6);
            Place.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(MainMenu.this, FeedPlaceActivity.class);
                    startActivity(a);
                }
            });
        }

    public void onGuiderButton (View view){
        Place = (Button) findViewById(R.id.button5);
        Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainMenu.this, FeedGuiderActivity.class);
                startActivity(a);
=======

    }

    public void onAmbulanceButton(View view) {
        Ambulance = findViewById(R.id.button8);

        String number = "022-118";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    public void onPoliceButton(View view) {
        Police = findViewById(R.id.button7);

        String number = "022-7800166";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    public void onEventsButton(View view) {
        Events = (Button) findViewById(R.id.button4);
        Events.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argo) {
                Intent i = new Intent(MainMenu.this, EventActivity.class);
                startActivity(i);
>>>>>>> 18d0727a885fa49ee824c195f0ad0aaa28cbd429
            }
        });
    }

<<<<<<< HEAD
    public void onHotelButton (View view){
        Place = (Button) findViewById(R.id.button);
        Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainMenu.this, FeedHotelActivity.class);
=======
    public void onPlacesButton(View view) {
        Place = (Button)findViewById(R.id.button6);
        Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent (MainMenu.this, PlaceActivity.class);
>>>>>>> 18d0727a885fa49ee824c195f0ad0aaa28cbd429
                startActivity(a);
            }
        });
    }
<<<<<<< HEAD
    }

=======
}
>>>>>>> 18d0727a885fa49ee824c195f0ad0aaa28cbd429

