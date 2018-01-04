package continuousnet.calender;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by thedarkslayer on 1/4/18.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CyclingViewHolder>{

    List<CyclingActivity> cyclingActivities;

    RVAdapter(List<CyclingActivity> cyclingActivities){
        this.cyclingActivities = cyclingActivities;
    }


    @Override
    public CyclingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        CyclingViewHolder pvh = new CyclingViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CyclingViewHolder holder, int position) {
        holder.timeActivity.setText(cyclingActivities.get(position).timeActivity);
        holder.nameActivity.setText(cyclingActivities.get(position).nameActivity);
       // holder.idActivity.setT(persons.get(i).photoId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return cyclingActivities.size();
    }

    public static class CyclingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cv;
        TextView timeActivity;
        Button nameActivity;
        TextView idActivity;

        CyclingViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            timeActivity = (TextView)itemView.findViewById(R.id.time);
            nameActivity = (Button)itemView.findViewById(R.id.button_activity);
            idActivity = (TextView)itemView.findViewById(R.id.share);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == nameActivity.getId()) {
                Toast.makeText(v.getContext(), "BUTTON PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
