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

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.mipmap.posterlunar2019,
            R.mipmap.buron,
            R.mipmap.post,
            R.mipmap.runway
    };
    // list of titles
    public String[] lst_title = {
            "Lunar Fair",
            "BURON Brandals",
            "Post Electro",
            "FASHION PLAZA BIP"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Lunar Fair yang diadakan oleh March Organizer ini menampilkan banyak tenant fashion dan penampilan dari Tian Ma Barongsai dan Andre & Dnakers ft Febrian. Acara ini diselengarakan dari tanggal 4 sampai 17 Februari 2019 di Paris Van Java.",
            "Wargi Bandung suka dengan musik-musiknya The Brandals? Minggu ini The Brandals akan manggung di Bandung loh. Rangkaian tour The Brandals yang di beri tajuk (Buron) ini akan diadakan di Spasial Bandung pada tanggal 16 Februari 2019.",
            "Minggu ini akan diadakan acara musik lagi nih Wargi Bandung. Akan ada penampilan dari HMGNC, Under The Big Bright Yellow Sun, dan Uvisual. Acara ini diselengarakan di IFI,jl.Purnawarman no 32 pada tanggal 16 februari 2019.",
            "Wargi Bandung mau belanja? Wargi Bandung bisa datang ke acara ini. Akan ada koleksi terbaru dari tenant-tenant yang ada di acara ini untuk koleksi (Spring Outfit). Acara ini akan diadakan pada tanggal 16 februari 2019 di Bandung Indah" +"Plaza."

    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };


    public SliderAdapter(Context context) {
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

