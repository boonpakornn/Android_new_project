package com.example.thiti.project_application;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Information> productList;

    //getting the context and product list with constructor
    public Adapter(Context mCtx, List<Information> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.listlayout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Information product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTopic());
        holder.textViewShortDesc.setText(product.getShortDesc());
        holder.longDesc = product.getLongDesc();
        holder.imageView.setAdjustViewBounds(true);
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.linkImg = product.getLinkImg();
        Picasso.get().load(holder.linkImg).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;
        String longDesc, linkImg;

        public ProductViewHolder(View itemView) {
            super(itemView);
            //Set all values from firebase,and put to cardciew
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Put all values to another activites
                    Intent intent = new Intent(mCtx, InformationActivity.class);
                    intent.putExtra("topic", textViewTitle.getText().toString());
                    intent.putExtra("longDesc", longDesc);
                    intent.putExtra("linkImg", linkImg);
                    mCtx.startActivity(intent);
                }
            });
        }
    }
}
//I use templte form this website
//https://www.simplifiedcoding.net/android-recyclerview-cardview-tutorial/