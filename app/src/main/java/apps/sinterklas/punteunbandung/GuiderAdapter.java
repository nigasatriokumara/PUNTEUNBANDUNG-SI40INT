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

public class GuiderAdapter extends RecyclerView.Adapter<GuiderAdapter.GuiderHolder> {

    private Context context;
    private List<Guider> mList;

    public GuiderAdapter(Context context, List<Guider> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public GuiderAdapter.GuiderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GuiderAdapter.GuiderHolder(LayoutInflater.from(context).
                inflate(R.layout.item_linear_3, parent, false));
    }

    @Override
    public void onBindViewHolder(GuiderAdapter.GuiderHolder holder, int position) {

        final Guider data = mList.get(position);

        holder.tvnama.setText(data.getNama());
        holder.tvdestinasi.setText(data.getDestinasi());
        holder.tvnotelpon.setText(data.getNotelpon());
        holder.tvemail.setText(data.getEmail());
        holder.tvbahasa.setText(data.getBahasa());

        Glide.with(context)
                .load(data.getImage_url())
                .into(holder.imgevent);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public Guider getDataArticle(int position){
        return mList.get(position);
    }

    class GuiderHolder extends RecyclerView.ViewHolder {

        private TextView tvnama, tvdestinasi,tvnotelpon,tvemail,tvbahasa;
        private ImageView imgevent;

        GuiderHolder(View itemView) {
            super(itemView);
            tvnama = itemView.findViewById(R.id.itemnama);
            tvdestinasi = itemView.findViewById(R.id.itemdestinasi);
            tvnotelpon = itemView.findViewById(R.id.itemnotelp);
            tvemail = itemView.findViewById(R.id.itememail);
            tvbahasa = itemView.findViewById(R.id.itembahasa);
            imgevent = itemView.findViewById(R.id.itemimg3);
        }
    }


}
