package eg.com.iti.mshwar.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eg.com.iti.mshwar.R;
import eg.com.iti.mshwar.model.TripPojo;
import eg.com.iti.mshwar.util.Utils;

import static android.support.constraint.Constraints.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<TripPojo> tripsList;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<TripPojo> data){
        this.tripsList = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = inflater.inflate(R.layout.list_item_main, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override // In order to check the view type in case of multiple list items
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder myViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder " + position);

        TripPojo currentObject = tripsList.get(position);
        myViewHolder.setData(currentObject, position);
        myViewHolder.setListeners();
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }

    public void removeItem(int position){
        tripsList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, tripsList.size());
    }

    public void addItem(int position, TripPojo trip){
        tripsList.add(position, trip);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, tripsList.size());
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tripName, startPoint, endPoint, status;
        ImageView thumbnail, start, delete;
        MaterialCardView container;
        int position;
        TripPojo currentObject;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tripName    = itemView.findViewById(R.id.title_list_item_main);
            startPoint  = itemView.findViewById(R.id.startpoint_list_item_main);
            endPoint    = itemView.findViewById(R.id.endpoint_list_item_main);
            status      = itemView.findViewById(R.id.status_list_item_main);
            thumbnail   = itemView.findViewById(R.id.img_list_item_main);
            start       = itemView.findViewById(R.id.start_list_item_main);
            delete      = itemView.findViewById(R.id.delete_list_item_main);
//            container   = itemView.findViewById(R.id.container_list_item_main);
        }

        public void setData(TripPojo currentObject, int position) {
            this.tripName.setText(currentObject.getTripName());
            this.startPoint.setText(currentObject.getTripStartPoint());
            this.endPoint.setText(currentObject.getTripEndPoint());
            this.status.setText((currentObject.getTripStatus()));
            this.thumbnail.setImageResource(currentObject.getTripStatusImage());
            this.position = position;
            this.currentObject = currentObject;
            this.delete.setImageResource(R.drawable.delete);
            this.start.setImageResource(R.drawable.start);

            if (!currentObject.getTripStatus().equalsIgnoreCase(Utils.UPCOMING)){
                this.start.setVisibility(View.GONE);
            }

            // Change status text color based on status
            switch (currentObject.getTripStatus()){
                case Utils.UPCOMING:
                    this.status.setTextColor(Color.parseColor("#1081e0"));
                    break;
                case Utils.CANCELED:
                    this.status.setTextColor(Color.parseColor("#d75a4a"));
                    break;
                case Utils.DONE:
                    this.status.setTextColor(Color.parseColor("#25ae88"));
                    break;
            }
        }

        public void setListeners() {
            start.setOnClickListener(MyViewHolder.this);
            delete.setOnClickListener(MyViewHolder.this);
            this.itemView.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.start_list_item_main:
                    addItem(position, currentObject);
                    Toast.makeText(v.getContext(), "Start at Position " + position, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.delete_list_item_main:
                    removeItem(position);
                    Toast.makeText(v.getContext(), "Delete at Position " + position, Toast.LENGTH_SHORT).show();
                    break;
//                case R.id.container_list_item_main:
                default:
                    Toast.makeText(v.getContext(), "Click at Position " + position, Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }
}
