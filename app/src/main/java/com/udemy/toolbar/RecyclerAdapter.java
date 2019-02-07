package com.udemy.toolbar;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.security.Permission;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    List<User> userList;
    Context context;

    public RecyclerAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactrecyclerview, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, final int position) {

        User object = userList.get(position);
        holder.contactNumber.setText(object.contactNumber);
        holder.contactName.setText(object.contactName);
        final int colors[] = new int[]{Color.RED, Color.GREEN, Color.GRAY, Color.parseColor("#4876ff"), Color.parseColor("#cc0033"), Color.parseColor("#99d3df"), Color.parseColor("#fa4e09")};
        int chosenColor = colors[Math.abs(object.contactName.hashCode()) % colors.length];

        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.WHITE)
                .useFont(Typeface.MONOSPACE)
                .fontSize(50) /* size in px */
                .bold()
                .toUpperCase()
                .endConfig()
                .buildRound(object.getContactName().substring(0, 1), chosenColor);
        holder.contactImage.setImageDrawable(drawable);
        //Glide.with(context).load(R.drawable.circle).into(holder.contactImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "card clicked witj number" + position + "   " + userList.get(position).getContactNumber(), Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(Intent.ACTION_CALL);
                String phNum = "tel:" + "1234567890";
                myIntent.setData(Uri.parse(phNum));
             context.startActivity(myIntent);

            }
        });
    }



    @Override
    public int getItemCount() {
        return userList.size();
    }
}
