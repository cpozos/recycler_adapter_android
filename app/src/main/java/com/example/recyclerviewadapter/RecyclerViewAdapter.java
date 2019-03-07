package com.example.recyclerviewadapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mNombres= new ArrayList<>();
    private ArrayList<String> mImagenes = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> mNombres, ArrayList<String> mImagenes)
    {
        this.mNombres = mNombres;
        this.mImagenes = mImagenes;
        this.mContext = context;
    }

    /**
     * Es el método responsable de inflar la vista
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position)
    {
        Log.d(TAG,"onBindViewHolder : called");

        Glide.with(mContext)
                .asBitmap()
                .load(mImagenes.get(position))
                .into(viewHolder.imagenItem);

        viewHolder.nameItem.setText(mNombres.get(position));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d(TAG,"onClicked: clicked on " + mNombres.get(position));
                Toast.makeText(mContext, mNombres.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return mNombres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imagenItem;
        TextView nameItem;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);
            imagenItem = itemView.findViewById(R.id.item_image);
            nameItem = itemView.findViewById(R.id.item_name);
            parentLayout = itemView.findViewById(R.id.relativLayaoutListItem);

        }
    }

}
