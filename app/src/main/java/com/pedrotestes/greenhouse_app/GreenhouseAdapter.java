package com.pedrotestes.greenhouse_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class GreenhouseAdapter extends RecyclerView.Adapter<GreenhouseAdapter.ItemViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the ptems in a list
    private List<Greenhouse> ptemList;

    ClickListner clicklistner;

    //getting the context and ptem list with constructor
    public GreenhouseAdapter(Context mCtx, List<Greenhouse> ptemList) {
        this.mCtx = mCtx;
        this.ptemList = ptemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.greenhouse_list_item, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        //getting the ptem of the specified position
        Greenhouse ptem = ptemList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(ptem.getTitle());
        holder.textViewShortDesc.setText(ptem.getShortdesc());
        holder.textViewRating.setText(String.valueOf(ptem.getRating()));
        holder.textViewPrice.setText(String.valueOf(ptem.getPrice()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(ptem.getImage()));

    }


    @Override
    public int getItemCount() {
        return ptemList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
            //itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clicklistner.itemClicked(itemView, getAdapterPosition());
        }


    }

    public void setOnClickListner(ClickListner clicklistner) {
        this.clicklistner = clicklistner;
    }

    public interface ClickListner {
        void itemClicked(View view, int position);
    }

}
