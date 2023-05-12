package com.a4iir9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter  extends ArrayAdapter<Notes> {
    public Adapter(MainActivity mainActivity, int notes_line, List<Notes> data) {
        super(mainActivity, notes_line, data);
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View view = convertView;
            RecyclerView.ViewHolder holder;
            if (view == null) {
                view = inflater.inflate(R.layout.notes_line, parent, false);
                holder = new RecyclerView.ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (RecyclerView.ViewHolder) view.getTag();
            }
            Notes note = getItem(position);
            if (note != null) {
                holder.labelView.setText(note.getLabel());
                holder.notesView.setText(note.getNote());
            }
            return view;
        }

        static class ViewHolder {
            final TextView labelView;
            final TextView notesView;

            ViewHolder(View view) {
                labelView = view.findViewById(R.id.label_matiere);
                notesView = view.findViewById(R.id.score_matiere);
            }
        }
    }
}
