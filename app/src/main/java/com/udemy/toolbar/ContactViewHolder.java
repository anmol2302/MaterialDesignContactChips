package com.udemy.toolbar;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContactViewHolder extends RecyclerView.ViewHolder {

     ImageView contactImage;
     TextView contactName;
     TextView contactNumber;
     LinearLayout linearLayout;
     CardView cardView;

    public ContactViewHolder(View itemView) {
        super(itemView);
        contactImage = (ImageView) itemView.findViewById(R.id.contactimage);
        contactName = (TextView) itemView.findViewById(R.id.contactname);
        contactNumber = (TextView) itemView.findViewById(R.id.contactnumber);
        cardView=(CardView) itemView.findViewById(R.id.card_view);
    }


}
