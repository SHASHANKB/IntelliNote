package main.java.com.intellinote.controller;

import main.java.com.intellinote.model.Note;
import main.java.com.intellinote.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shashankbhardwaj on 28/11/16.
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    DatabaseService databaseService;

    @RequestMapping(name = "/createNote", method = RequestMethod.POST)
    public Integer createNewNote(@RequestBody Note note){

        //save Note and get the noteId
        Integer noteId = databaseService.addNote(note);
        return noteId;
    }
}
