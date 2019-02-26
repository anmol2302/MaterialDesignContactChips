package com.udemy.toolbar;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ComplainViewHolder extends RecyclerView.ViewHolder {

     TextView departmentText;
     ImageView complainSubjectImage;
     TextView complainSubject;
     TextView complainDate;
     ImageView complainId;
     TextView complainText;
     TextView complainStausLabel;
     ImageView statusImage;
     CardView cardView;


    public ComplainViewHolder(View itemView) {
        super(itemView);
        complainId = (ImageView) itemView.findViewById(R.id.complainId);
        departmentText=(TextView) itemView.findViewById(R.id.department);
        complainSubjectImage=(ImageView) itemView.findViewById(R.id.subjectImage);
        complainSubject=(TextView) itemView.findViewById(R.id.subject);
        complainDate=(TextView)itemView.findViewById(R.id.complaindate);
        complainStausLabel =(TextView)itemView.findViewById(R.id.statusLabel);
        statusImage=(ImageView)itemView.findViewById(R.id.statusImage);
        complainText=(TextView) itemView.findViewById(R.id.complain);
        cardView=(CardView) itemView.findViewById(R.id.card_view);

    }



}
