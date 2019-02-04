package com.udemy.toolbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;
public class RecyclerAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    List<User> userList;
    Context context;
    ColorGenerator generator = ColorGenerator.MATERIAL;

    public RecyclerAdapter(Context context,List<User> userList) {
        this.context=context;
        this.userList = userList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactrecyclerview, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        User object = userList.get(position);
        holder.contactNumber.setText(object.contactNumber);
        holder.contactName.setText(object.contactName);
        int colors[] = new int[] { Color.RED,Color.GREEN,Color.GRAY,Color.parseColor("#4876ff"),Color.parseColor("#cc0033"),Color.parseColor("#99d3df"),Color.parseColor("#fa4e09")};
        int chosenColor = colors[Math.abs(object.contactName.hashCode()) % colors.length];

        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.WHITE)
                .useFont(Typeface.MONOSPACE)
                .fontSize(50) /* size in px */
                .bold()
                .toUpperCase()
                .endConfig()
                .buildRound(object.getContactName().substring(0,1), chosenColor);
        holder.contactImage.setImageDrawable(drawable);
        //Glide.with(context).load(R.drawable.circle).into(holder.contactImage);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
