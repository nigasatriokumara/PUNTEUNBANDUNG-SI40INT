package apps.sinterklas.punteunbandung;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderAdapterPlace extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.mipmap.kebunteh,
            R.mipmap.marketlembang,
            R.mipmap.cileunca,
            R.mipmap.kawah
    };
    // list of titles
    public String[] lst_title = {
            "Kawah Putih",
            "Kebun Teh",
            "Situ Cileunca",
            "Floating Market"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Kawah Putih adalah sebuah tempat wisata di Jawa Barat yang terletak di kawasan Ciwidey. Kawah putih merupakan sebuah danau yang terbentuk dari letusan Gunung Patuha.",
            "Kebun Teh Rancabali adalah saah satu perkebunan teh paling populer yang ada di wilayah Ciwidey kabupaten bandung. Berada di ketinggian 1.650 mdpl dengan suhu udara rata-rata di siang hari 20 derajat celcius dan bisa berubah menjadi sangat dingin di malam hari sekitar 5 derajat celsius.",
            "Perkebunan teh di sini sangat luas dan pemandangan alamnya sangat indah dengan lapisan kabut putih di atasnya yang selalu menemani.",
            "Situ Cileunca yang berlokasi di Warnasari, Pangalengan, Bandung, Jawa Barat (Aksara Sunda Baku) adalah sebuah danau buatan dengan luas mencapai 1.400 hektar dengan latar belakang perbukitan dan pegunungan yang indah. Selain difungsikan sebagai objek wisata, Situ Cileunca juga berfungsi sebagai pembangkit listrik tenaga air (PLTA). Air yang berasal dari danau tersebut dialirkan melalui Sungai Palayangan. Sungai ini pula yang sering dijadikan sebagai arena ber-arung jeram.Kedalaman danau mencapai 17 meter, dan sebelum tahun 1918, ini merupakan hutan belantara yang kemudian diubah menjadi situ, yang berfungsi melayani kebutuhan air masyarakat.",
            "Berbicara Kawasan Wisata Lembang yang dikenal cukup aduhai memang tidak ada matinya,termasuk salah satu objek wisata Favorit dan populer di Lembang Bandung yang satu ini yaitu Floating Market Lembang. Floating Market Lembang yang bila diartikan ke dalam bahasa Indonesia berarti Pasar terapung di Lembang ini bisa dikatakan merupakan satu-satunya pasar terapung yang terdapat di Bandung,bahkan di Jawa Barat."
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };


    public SliderAdapterPlace(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
