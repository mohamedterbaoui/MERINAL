package com.example.mohamed.merinal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class contentAdapter extends RecyclerView.Adapter<contentAdapter.ViewHolder> implements Filterable {
    private ArrayList<Content> mArrayList;
    private ArrayList<Content> mFilteredList;

    public contentAdapter(ArrayList<Content> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public contentAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(contentAdapter.ViewHolder viewHolder, int i) {

        viewHolder.name.setText(mFilteredList.get(i).getMedName());
        viewHolder.infos.setText(mFilteredList.get(i).getAddInfo());
        viewHolder.icon.setImageResource(mFilteredList.get(i).getImageRes());
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<Content> filteredList = new ArrayList<>();

                    for (Content content : mArrayList) {

                        if (content.getAddInfo().toLowerCase().contains(charString) || content.getMedName().toLowerCase().contains(charString)) {

                            filteredList.add(content);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Content>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name , infos ;
        ImageView icon;
        public ViewHolder(View view) {
            super(view);

            name = (TextView)view.findViewById(R.id.name);
            infos = (TextView)view.findViewById(R.id.infos);
            icon = (ImageView)view.findViewById(R.id.imageView);

        }
    }

}
