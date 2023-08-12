package com.alvin.notes;

import android.database.Cursor;

import com.alvin.notes.model.Note;

public interface NoteInterface {

    public Cursor read();
    public boolean create(Note note);
    public boolean update(Note note);
    public boolean delete(String id);
}

