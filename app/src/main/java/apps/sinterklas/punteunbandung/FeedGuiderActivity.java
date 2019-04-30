package apps.sinterklas.punteunbandung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedGuiderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GuiderAdapter guiderAdapter;
    List<Guider> guidersList;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private static final String TAG = FeedEventActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_guider);
        guidersList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rv_guider);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("GuiderData");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                guidersList.clear();


                for (DataSnapshot produkSnapshot : dataSnapshot.getChildren()) {

                    Guider guider = produkSnapshot.getValue(Guider.class);
                    guidersList.add(guider);
                }

                guiderAdapter = new GuiderAdapter(FeedGuiderActivity.this, guidersList);
                GridLayoutManager layoutManager =
                        new GridLayoutManager(FeedGuiderActivity.this, 3, GridLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(guiderAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "eror : .", databaseError.toException());

            }
        });


    }
}