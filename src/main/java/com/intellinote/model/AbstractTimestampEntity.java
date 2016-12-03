package main.java.com.intellinote.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by shashankbhardwaj on 3/12/16.
 */
public class AbstractTimestampEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}