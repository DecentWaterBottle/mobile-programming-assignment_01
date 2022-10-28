package com.example.jack_carter_assignment1_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder>{

    private List<Integer> image_list;
    private List<String> description_list;
    private Context context;
    private ClickListener clickListener;

    // Click interface implemented in the MenuActivity class
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    // Adapter Constructor
    public MyRecycleAdapter(List<Integer> image_list, List<String> description_list) {
        this.image_list = image_list;
        this.description_list = description_list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new ViewHolder(view);
    }

    // Setting description and image
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String description = description_list.get(position);
        Integer image = image_list.get(position);
        holder.wonderText.setText(description);
        holder.wonderImage.setImageResource(image);

    }

    // Get number of wonders
    @Override
    public int getItemCount() {
        return image_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView wonderImage;
        public TextView wonderText;

        public ViewHolder(View itemView) {
            super(itemView);

            wonderImage = (ImageView) itemView.findViewById(R.id.wonder_image);
            wonderText = (TextView) itemView.findViewById(R.id.wonder_text);
            itemView.setOnClickListener(this);
        }

        // Fires the onItemClick function in MenuActivity
        @Override
        public void onClick(View view){
            if (clickListener != null) {
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }




}
