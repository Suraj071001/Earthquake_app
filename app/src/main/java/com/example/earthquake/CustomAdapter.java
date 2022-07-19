package com.example.earthquake;


import static android.media.CamcorderProfile.get;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final List<Model> userlist1;
    private final Context context;
    String text5;
    public static final String Extra_Video = "com.example.vedioapp.Extra_Video";

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView,textView2,textView3,textView4,textView5;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
            textView2 = view.findViewById(R.id.textView2);
            textView3 = view.findViewById(R.id.textView3);
            textView4 = view.findViewById(R.id.textView4);
            textView5 = view.findViewById(R.id.textView5);
            view.setOnClickListener(this);


        }


        @Override
        public void onClick(View view) {
            String url = (String) textView5.getText();
            Uri web = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW,web);
            view.getContext().startActivity(intent);
        }
    }


    public CustomAdapter(@NonNull MainActivity context, List<Model> earthquakes){
        this.userlist1 = earthquakes;
        this.context = context;
    }
    public void clearApplications() {
        int size = this.userlist1.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                userlist1.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    public void addApplications(List<Model> applications) {
        this.userlist1.addAll(applications);
        this.notifyItemRangeInserted(0, applications.size() - 1);
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_custom_adapter, viewGroup, false);
        return new ViewHolder(view);
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        
        Double magnitude = userlist1.get(position).getT1();
        viewHolder.textView.setText(magnitude.toString());
        String text2 = userlist1.get(position).getT2();
        viewHolder.textView2.setText(text2);
        String text3 = userlist1.get(position).getT3();
        viewHolder.textView3.setText(text3);
        String text4 = userlist1.get(position).getT4();
        viewHolder.textView4.setText(text4);
        GradientDrawable magnitudeCircle = (GradientDrawable) viewHolder.textView.getBackground();
        int color = getMagnitudeColor(userlist1.get(position).getT1());
        magnitudeCircle.setColor(color);

        text5 = userlist1.get(position).getT5();
        viewHolder.textView5.setText(text5);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return userlist1.size();
    }

    public int getMagnitudeColor(Double magnitude){
        int magnitudeValue = (int) Math.floor(magnitude);
        int magnitudeResourse ;
        switch (magnitudeValue){
            case 0:
            case 1:
                magnitudeResourse = R.color.magnitude1;
                break;
            case 2:
                magnitudeResourse = R.color.magnitude2;
                break;
            case 3:
                magnitudeResourse = R.color.magnitude3;
                break;
            case 4:
                magnitudeResourse = R.color.magnitude4;
                break;
            case 5:
                magnitudeResourse = R.color.magnitude5;
                break;
            case 6:
                magnitudeResourse = R.color.magnitude6;
                break;
            case 7:
                magnitudeResourse = R.color.magnitude7;
                break;
            case 8:
                magnitudeResourse = R.color.magnitude8;
                break;
            case 9:
                magnitudeResourse = R.color.magnitude9;
                break;
            case 10:
                magnitudeResourse = R.color.magnitude9;
                break;
            default:
                magnitudeResourse = R.color.magnitude1;

        }
    return ContextCompat.getColor(context,magnitudeResourse);
    }

}
