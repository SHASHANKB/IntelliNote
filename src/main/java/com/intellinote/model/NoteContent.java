package main.java.com.intellinote.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shashankbhardwaj on 26/11/16.
 */
public class NoteContent extends AbstractTimestampEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ncId;

    @Column(name = "content")
    private String content;

    public int getNcId() {
        return ncId;
    }

    public void setNcId(int ncId) {
        this.ncId = ncId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteContent that = (NoteContent) o;

        return ncId == that.ncId;

    }

    @Override
    public int hashCode() {
        return ncId;
    }
}
