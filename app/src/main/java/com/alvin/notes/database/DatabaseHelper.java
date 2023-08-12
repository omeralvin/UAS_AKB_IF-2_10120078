package com.alvin.notes.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.alvin.notes.NoteInterface;
import com.alvin.notes.model.Note;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper implements NoteInterface {
//10120078 - Alvin Izza Rohman - IF2
    private DatabaseReference notesReference;

    public FirebaseHelper() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        notesReference = database.getReference("notes"); // Menggunakan "notes" sebagai root path di Firebase Database
    }

    public void create(Note note) {
        String noteId = notesReference.push().getKey();
        note.setId(noteId);
        notesReference.child(noteId).setValue(note);
    }

    public void update(Note note) {
        notesReference.child(note.getId()).setValue(note);
    }

    public void delete(String id) {
        notesReference.child(id).removeValue();
    }

    public DatabaseReference getNotesReference() {
        return notesReference;
    }
}
