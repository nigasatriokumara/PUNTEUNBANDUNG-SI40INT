package apps.sinterklas.punteunbandung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedHotelActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HotelAdapter hotelAdapter;
    List<Hotel> hotelsList;
    Button btnreview;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private static final String TAG = FeedEventActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_hotel);
        hotelsList = new ArrayList<>();
        btnreview = (Button) findViewById(R.id.btnReview);
        recyclerView = (RecyclerView) findViewById(R.id.rv_hotel);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("HotelData");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                hotelsList.clear();


                for (DataSnapshot produkSnapshot : dataSnapshot.getChildren()) {

                    Hotel hotel = produkSnapshot.getValue(Hotel.class);
                    hotelsList.add(hotel);
                }

                hotelAdapter = new HotelAdapter(FeedHotelActivity.this, hotelsList);
                GridLayoutManager layoutManager =
                        new GridLayoutManager(FeedHotelActivity.this, 2, GridLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(hotelAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "eror : .", databaseError.toException());

            }
        });

    }
}
