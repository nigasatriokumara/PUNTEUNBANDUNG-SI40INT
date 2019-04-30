package apps.sinterklas.punteunbandung;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by user pc on 4/26/2019.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder>  {

    private Context context;
    private List<Place> mList;

    public PlaceAdapter(Context context, List<Place> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public PlaceAdapter.PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlaceAdapter.PlaceHolder(LayoutInflater.from(context).
                inflate(R.layout.item_linear_2, parent, false));
    }

    @Override
    public void onBindViewHolder(PlaceAdapter.PlaceHolder holder, int position) {
        final Place data = mList.get(position);

        holder.tvTitle.setText(data.getTitle());
        holder.tvDesc.setText(data.deskripsi);

        Glide.with(context)
                .load(data.getImage_url())
                .into(holder.imgevent);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public Place getDataArticle(int position){
        return mList.get(position);
    }

    class PlaceHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDesc;
        private ImageView imgevent;


        PlaceHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.itemtitle2);
            tvDesc = itemView.findViewById(R.id.itemdescription2);
            imgevent = itemView.findViewById(R.id.itemimg2);
        }
    }
}
