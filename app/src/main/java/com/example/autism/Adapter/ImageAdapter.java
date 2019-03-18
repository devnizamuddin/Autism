package com.example.autism.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.autism.PoJo.ImagePoJo;
import com.example.autism.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private ArrayList<ImagePoJo>imagePoJos;
    private ImageClickListener clickListener;

    public ImageAdapter(Context context, ArrayList<ImagePoJo> imagePoJos, ImageClickListener clickListener) {
        this.context = context;
        this.imagePoJos = imagePoJos;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_image_layout,null);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        ImagePoJo imagePoJo = imagePoJos.get(position);
        holder.imageView.setImageResource(imagePoJo.getImageDrawableId());
        holder.imageView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return imagePoJos.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ImageViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onImageClick(imagePoJos.get(getAdapterPosition()));
                }
            });
        }
    }
    public interface ImageClickListener{

        void onImageClick(ImagePoJo imagePoJo);

    }
    public void updateImage(ArrayList<ImagePoJo>imagePoJos){
        this.imagePoJos = imagePoJos;
        notifyDataSetChanged();
    }
}
