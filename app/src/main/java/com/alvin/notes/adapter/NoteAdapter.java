package com.alvin.notes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alvin.notes.R;
import com.alvin.notes.model.Note;
import com.alvin.notes.view.activity.AddNoteActivity;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    //10120078 - Alvin Izza Rohman - IF2
    private List<Note> notes;
    private Context context;

    public NoteAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.title.setText(note.getTitle());
        holder.category.setText(note.getCategory());
        holder.desc.setText(note.getDesc());
        holder.date.setText(note.getDate());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddNoteActivity.class);
            intent.putExtra("Note", note);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView category;
        TextView desc;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_note);
            category = itemView.findViewById(R.id.category_note);
            desc = itemView.findViewById(R.id.desc_note);
            date = itemView.findViewById(R.id.date_note);
        }
    }
}
