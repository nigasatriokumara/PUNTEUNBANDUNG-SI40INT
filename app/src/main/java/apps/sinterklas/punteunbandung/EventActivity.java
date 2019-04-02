package apps.sinterklas.punteunbandung;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EventActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SliderAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SliderAdapter(this);
        viewPager.setAdapter(myadapter);

    }
}
