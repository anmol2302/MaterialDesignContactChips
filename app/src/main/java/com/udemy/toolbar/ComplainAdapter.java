package com.udemy.toolbar;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.List;

public class ComplainAdapter extends RecyclerView.Adapter<ComplainViewHolder> implements Filterable {

    List<Complain> complainList;
    List<Complain> searchFilter;
    Context context;

    public ComplainAdapter(Context context, List<Complain> complainList) {
        this.context = context;
        this.complainList = complainList;
        this.searchFilter = new ArrayList<>(complainList);
    }

    @Override
    public ComplainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.complainrecyclerview, parent, false);
        return new ComplainViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ComplainViewHolder holder, final int position) {

        Complain object = complainList.get(position);

        holder.departmentText.setText(object.getDepartment_name());
        holder.complainSubject.setText(object.getComplaint_subject());
        holder.complainDate.setText(object.getComplaint_date());
        holder.complainText.setText(checkComplainSize(object.getComplaint()));
        final int colors[] = new int[]{Color.RED, Color.GRAY, Color.parseColor("#FFB74D"), Color.parseColor("#FF5722"), Color.parseColor("#4876ff"), Color.parseColor("#cc0033"), Color.parseColor("#99d3df"), Color.parseColor("#fa4e09"), Color.parseColor("#26C6DA"), Color.parseColor("#039BE5"), Color.parseColor("#F44336"), Color.parseColor("#E91E63"), Color.parseColor("#4A148C"), Color.parseColor("#1DE9B6")};
        int chosenColor = colors[Math.abs(object.getComplaint().hashCode()) % colors.length];
        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.WHITE)
                .useFont(Typeface.MONOSPACE)
                .fontSize(50) /* size in px */
                .bold()
                .toUpperCase()
                .endConfig()
                .buildRound(object.getComplain_id() + "", chosenColor);
        holder.complainId.setImageDrawable(drawable);
        holder.statusImage.setImageResource(R.drawable.complainclosed);
        holder.statusImage.setColorFilter(Color.parseColor("#00e676"));
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View modelBottomSheet = LayoutInflater.from(context).inflate(R.layout.complain_bottom_sheet, null);
//                BottomSheetDialog dialog = new BottomSheetDialog(context);
//                dialog.setContentView(modelBottomSheet);
//                TextView textView = (TextView) modelBottomSheet.findViewById(R.id.test);
//                textView.setText(complainList.get(position).getComplain_id()+"");
//                dialog.show();
//
//
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return complainList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Complain> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(searchFilter);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Complain item : searchFilter) {
                    if (item.getComplaint().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }

                    if (item.getComplaint_status().toLowerCase().contains(filterPattern)) {

                        filteredList.add(item);
                    }
                    if(new String(item.getComplain_id()+"").contains(constraint)){

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
            complainList.clear();
            complainList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    public String checkContactNameSize(String contactName) {

        if (contactName.length() >= 14) {
            return contactName.substring(0, 13) + "...";


        } else {
            return contactName;
        }

    }

    public String checkComplainSize(String suggestion) {


        if (suggestion.length() >= 68) {
            return suggestion.substring(0, 67) + "...";


        } else {
            return suggestion;
        }

    }

}