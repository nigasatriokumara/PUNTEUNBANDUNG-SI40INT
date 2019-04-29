package apps.sinterklas.punteunbandung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by user pc on 4/27/2019.
 */

public class HotelAdapter  extends RecyclerView.Adapter<HotelAdapter.HotelHolder> {

    private Context context;
    private List<Hotel> mList;

    public HotelAdapter(Context context, List<Hotel> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public HotelAdapter.HotelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotelAdapter.HotelHolder(LayoutInflater.from(context).
                inflate(R.layout.item_linear_4, parent, false));
    }

    @Override
    public void onBindViewHolder(final HotelAdapter.HotelHolder holder, final int position) {

        final Hotel data = mList.get(position);

        holder.tvnama.setText(data.getNama());
        holder.tvlokasi.setText(data.getLokasi());
        Glide.with(context)
                .load(data.getImage_url())
                .into(holder.imgevent);
        holder.btnreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //goes to new activity passing the item name
                Intent intent = new Intent(v.getContext(), HotelReviewActivity.class);
                Bundle b = new Bundle();

                //get text for current item
                String id = data.getId();
                //put text into a bundle and add to intent
                intent.putExtra("id", id);

                //get position to carry integer
                intent.putExtra("position", position);

                intent.putExtras(b);

                //begin activity
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public Hotel getDataArticle(int position){
        return mList.get(position);
    }

    class HotelHolder extends RecyclerView.ViewHolder {

        private TextView tvnama, tvlokasi;
        private ImageView imgevent;
        private Button btnreview;

        HotelHolder (View itemView) {
            super(itemView);
            tvnama = itemView.findViewById(R.id.itemnamahotel);
            tvlokasi = itemView.findViewById(R.id.itemlokasi);
            imgevent = itemView.findViewById(R.id.itemimg4);
            btnreview = itemView.findViewById(R.id.btnReview);
        }
    }
}
