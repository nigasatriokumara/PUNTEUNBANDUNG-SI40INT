package apps.sinterklas.punteunbandung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedPlaceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PlaceAdapter placeAdapter;
    List<Place> placeList;
    FirebaseDatabase database;
    DatabaseReference myRef ;
    private static final String TAG = FeedPlaceActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_place);

        placeList  = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rv_place);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("PlaceData");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                placeList.clear();


                for (DataSnapshot produkSnapshot : dataSnapshot.getChildren()) {

                    Place place = produkSnapshot.getValue(Place.class);
                    placeList.add(place);
                }

                placeAdapter = new PlaceAdapter(FeedPlaceActivity.this, placeList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(FeedPlaceActivity.this, LinearLayoutManager.HORIZONTAL,
                        false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(placeAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "eror : .", databaseError.toException());

            }
        });


    }
}
