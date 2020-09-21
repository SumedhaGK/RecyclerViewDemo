package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/*
SocialMediaAdapter is a custom adapter to manage the view holder object. This class creates
view holders SocialMediaItemViewHolder. OnItemClickListener is an interface which holds
onItemClick() and onItemDelete() which will handle list item click and Item delete cases
 */
public class SocialMediaAdapter extends RecyclerView.Adapter<SocialMediaAdapter.SocialMediaItemViewHolder> {

//    Create an interface to handle the insert and delete item action of the user.
    public interface OnItemClickListener{
        void onItemClick(int position);
        void onItemDelete(int position);
    }
    private ArrayList<SocialMediaItem> socialMediaItem;
    private OnItemClickListener listener;

//  assign the listener
    public void setOnItemClickListenr(OnItemClickListener listenr){
        this.listener = listenr;
    }

//   Get the ArrayList of type SocialMediaItem
    public SocialMediaAdapter(ArrayList<SocialMediaItem> socialMediaItem) {
        this.socialMediaItem = socialMediaItem;
    }

//   Get the view from the Layout inflater and create a view holder
    @NonNull
    @Override
    public SocialMediaItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        SocialMediaItemViewHolder socialMediaItemViewHolder = new SocialMediaItemViewHolder(view, listener);
        return socialMediaItemViewHolder;
    }

//   Bind the current view holder with the data
    @Override
    public void onBindViewHolder(@NonNull SocialMediaItemViewHolder holder, int position) {
        SocialMediaItem currentItem = socialMediaItem.get(position);
    holder.platformName.setText(currentItem.getPlatformName());
    holder.platformMUA.setText(currentItem.getPlatformMAU());
    holder.logoImage.setImageResource(currentItem.getPlatformLogo());
    }

//  Return the size of the ArrayList
    @Override
    public int getItemCount() {
        return socialMediaItem.size();
    }

//  Create a static View Holder class
    static class SocialMediaItemViewHolder extends RecyclerView.ViewHolder {
    private TextView platformName;
    private TextView platformMUA;
    private ImageView logoImage;
    private ImageView trashImage;
    private OnItemClickListener listener;
    private final String tag = "Logging Message";

        public SocialMediaItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
//  Initialize the layout views
            this.listener = listener;
             platformName = (TextView) itemView.findViewById(R.id.text1);
             platformMUA = (TextView) itemView.findViewById(R.id.text2);
             logoImage = (ImageView) itemView.findViewById(R.id.imageView);
             trashImage = (ImageView) itemView.findViewById(R.id.trashImage);

//   Register one row (or a single item of the list) for an onClick listener and call onItemClick() method
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
                         listener.onItemClick(getAdapterPosition());
                     }
             }

             });
//  Register the trash bin imageView to onClick Event and call onItemDelete() method
            trashImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null && getAdapterPosition()!= RecyclerView.NO_POSITION){
                        listener.onItemDelete(getAdapterPosition());
                    }
                }
            });
        }
    }
}
