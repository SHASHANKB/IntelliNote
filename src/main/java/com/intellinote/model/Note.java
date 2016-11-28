package model;

import java.util.Date;

/**
 * Created by shashankbhardwaj on 26/11/16.
 */
public class Note {
    private int noteId;
    private NoteContent noteContent;
    private int userId;
    private Date creationDate;


    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public NoteContent getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(NoteContent noteContent) {
        this.noteContent = noteContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return noteId == note.noteId;

    }

    @Override
    public int hashCode() {
        return noteId;
    }
}
