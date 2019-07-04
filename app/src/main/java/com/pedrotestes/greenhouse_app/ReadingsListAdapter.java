package com.pedrotestes.greenhouse_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class ReadingsListAdapter extends RecyclerView.Adapter<ReadingsListAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    //vars
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mIconsUrls = new ArrayList<>();
    private Context mContext;


    public ReadingsListAdapter(Context mContext, ArrayList<String> mTitles, ArrayList<String> mIconsUrls) {
        this.mTitles = mTitles;
        this.mIconsUrls = mIconsUrls;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("TAG", "onCreateViewHolder: called");


        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.sensor_readings_widget, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: called");

        holder.title.setText(mTitles.get(position));
        //holder.image.setImageDrawable(mContext.getResources().getDrawable(Integer.parseInt(mIconsUrls.get(position))));

    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.wid_reading_img);
            title = itemView.findViewById(R.id.wid_reading_title);
        }
    }
}
