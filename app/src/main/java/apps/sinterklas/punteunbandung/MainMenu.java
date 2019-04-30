package apps.sinterklas.punteunbandung;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {
    Button Ambulance, Police, Events, Place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

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
            }
        });
    }

    public void onPlacesButton(View view) {
        Place = (Button)findViewById(R.id.button6);
        Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent (MainMenu.this, PlaceActivity.class);
                startActivity(a);
            }
        });
    }
}

