package com.example.webservicewitharch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PicsAdapter extends RecyclerView.Adapter<PicsAdapter.picHolder> {

    List<Pictures> pictures = new ArrayList<>();

    @NonNull
    @Override
    public picHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pic_item, parent, false);
        return new picHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull picHolder holder, int position) {
        Pictures currentPics = pictures.get(position);
        holder.creator.setText(currentPics.getmCreator());
        int likeCount = currentPics.getmLikes();
        holder.likes.setText("Likes: " + likeCount);
        Picasso.get().load(currentPics.getmImageUrl()).fit().centerInside().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public void setPics(List<Pictures> pictures) {
        this.pictures = pictures;
        notifyDataSetChanged();
    }


    class picHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView creator, likes;

        public picHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            creator = itemView.findViewById(R.id.text_view_creator);
            likes = itemView.findViewById(R.id.text_view_downloads);
        }
    }
}
