package apps.sinterklas.punteunbandung;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder>  {

    private Context context;
    private List<Event> mList;

    public EventAdapter(Context context, List<Event> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventHolder(LayoutInflater.from(context).
                inflate(R.layout.item_liear_1, parent, false));
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        final Event data = mList.get(position);

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

    public Event getDataArticle(int position){
        return mList.get(position);
    }

    class EventHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDesc;
        private ImageView imgevent;


        EventHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.itemtitle1);
            tvDesc = itemView.findViewById(R.id.itemdescription1);
            imgevent = itemView.findViewById(R.id.itemimg1);
        }
    }


}