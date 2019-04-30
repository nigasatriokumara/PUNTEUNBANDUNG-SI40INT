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

public class FeedEventActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EventAdapter eventAdapter;
    List<Event> eventList;
    FirebaseDatabase database;
    DatabaseReference myRef ;
    private static final String TAG = FeedEventActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_event);
        eventList  = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rv_event);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("EventData");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                eventList.clear();


                for (DataSnapshot produkSnapshot : dataSnapshot.getChildren()) {

                    Event event = produkSnapshot.getValue(Event.class);
                    eventList.add(event);
                }

                eventAdapter = new EventAdapter(FeedEventActivity.this, eventList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(FeedEventActivity.this, LinearLayoutManager.HORIZONTAL,
                        false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(eventAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "eror : .", databaseError.toException());

            }
        });


    }
}
