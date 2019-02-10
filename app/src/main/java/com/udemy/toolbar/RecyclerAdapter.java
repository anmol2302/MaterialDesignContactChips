package com.udemy.toolbar;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ContactViewHolder> implements Filterable {

    List<User> userList;
    List<User> searchFilter;
    Context context;

    public RecyclerAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        this.searchFilter = new ArrayList<>(userList);
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
        holder.contactName.setText(checkContactNameSize(object.contactName));
        final int colors[] = new int[]{Color.RED, Color.GRAY, Color.parseColor("#FFB74D"), Color.parseColor("#FF5722"), Color.parseColor("#4876ff"), Color.parseColor("#cc0033"), Color.parseColor("#99d3df"), Color.parseColor("#fa4e09"), Color.parseColor("#26C6DA"), Color.parseColor("#039BE5"), Color.parseColor("#F44336"), Color.parseColor("#E91E63"), Color.parseColor("#4A148C"), Color.parseColor("#1DE9B6")};
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
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_CALL);
                String phNum = "tel:" + userList.get(position).getContactNumber();
                myIntent.setData(Uri.parse(phNum));
                context.startActivity(myIntent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<User> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(searchFilter);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (User item : searchFilter) {
                    if (item.getContactNumber().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }

                    if (item.getContactName().toLowerCase().contains(filterPattern)) {

                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            userList.clear();
            userList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public String checkContactNameSize(String contactName) {

        String name = "";
        if (contactName.length() >= 19) {
            return contactName.substring(0, 18) + "...";


        } else {
            return contactName;
        }

    }

}