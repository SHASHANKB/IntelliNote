package main.java.com.intellinote.service;

import main.java.com.intellinote.model.Note;
import main.java.com.intellinote.model.NoteContent;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shashankbhardwaj on 1/12/16.
 */
public class DatabaseService {

    private static SessionFactory factory;
    public DatabaseService(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public Integer addNote(Note note){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer nId = null;
        try{
            tx = session.beginTransaction();
            nId = (Integer) session.save(note);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return nId;
    }

    public List<Note> listUserNotes(Integer userId){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Note> notes = null;
        try{
            tx = session.beginTransaction();
            notes = session.createQuery("FROM Note where userId = "+userId).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return notes;
    }

    public Boolean updateNote(Integer nId, NoteContent noteContent){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Note note = (Note)session.get(Note.class, nId);
            note.setNoteContent(noteContent);
            note.setUpdationDate(new Date());
            session.update(note);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    public Boolean deleteNote(Integer noteId){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Note note =
                    (Note)session.get(Note.class, noteId);
            session.delete(note);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

}
