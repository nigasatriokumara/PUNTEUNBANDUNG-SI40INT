package apps.sinterklas.punteunbandung;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlaceActivity extends AppCompatActivity {
    private ViewPager viewPager2;
    private SliderAdapterPlace myadapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        viewPager2 = (ViewPager) findViewById(R.id.viewpager2);
        myadapter2 = new SliderAdapterPlace(this);
        viewPager2.setAdapter(myadapter2);

    }
}