package continuousnet.calender;

import android.content.Context;
import android.content.Intent;
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

public class CyclingActivitiesAdapter extends RecyclerView.Adapter<CyclingActivitiesAdapter.CyclingViewHolder> {
    Context context;
    List<CyclingActivity> cyclingActivities;

    CyclingActivitiesAdapter(List<CyclingActivity> cyclingActivities) {
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
        context = holder.itemView.getContext();
        holder.timeActivity.setText(cyclingActivities.get(position).timeActivity);
        holder.nameActivity.setText(cyclingActivities.get(position).nameActivity);
        // holder.idActivity.setT(persons.get(i).photoId);

        holder.itemView.findViewById(R.id.button_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(holder.itemView.getContext(), "Button " + position, Toast.LENGTH_LONG).show();
                if(position == 0){
                    Intent intent = new Intent(context, HistoryActivity.class);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, SettingsActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return cyclingActivities.size();
    }

    public static class CyclingViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView timeActivity;
        Button nameActivity;
        TextView idActivity;

        CyclingViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            timeActivity = (TextView) itemView.findViewById(R.id.time);
            nameActivity = (Button) itemView.findViewById(R.id.button_activity);
            idActivity = (TextView) itemView.findViewById(R.id.share);
        }

    }

}
