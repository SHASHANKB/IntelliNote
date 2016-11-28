package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shashankbhardwaj on 28/11/16.
 */
@Controller
@RequestMapping("/")
public class NoteController {

    @RequestMapping("/createNote")
    public String createNewNote(){

    }
}
