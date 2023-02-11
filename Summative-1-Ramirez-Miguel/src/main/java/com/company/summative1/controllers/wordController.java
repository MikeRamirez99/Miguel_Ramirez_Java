package com.company.summative1.controllers;
import com.company.summative1.models.word;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class wordController {
    private List<word> wordList;
    public wordController(){
    word w1 = new word(1,"Serendipity","The occurrence and development of events by chance in a happy or beneficial way.");
    word w2 = new word(2,"Anachronism","An anachronism is something (or someone) that is out of place in terms of time or chronology.");
        word w3 = new word(3,"Accismus","A form of irony in which someone feigns indifference to something he or she desires");
        word w4 = new word(4,"Cacophony","A cacophony is a harsh mixture of sounds.");
        word w5 = new word(5,"Draconian","An adjective to describe something that is excessively harsh and severe.");
        word w6 = new word(6,"Limerence","Defined as an involuntary state of mind resulting from a romantic attraction to another person combined with an overwhelming, obsessive need to have one’s feelings reciprocated.");
        word w7 = new word(7,"Pareidolia","A psychological phenomenon in which the mind perceives a specific image or pattern where it does not actually exist, such as seeing a face in the clouds.");
        word w8 = new word(8,"Riposte","A quick or witty retaliatory reply.");
        word w9 = new word(9,"Sanctimony","Pretend or hypocritical religious devotion or righteousness.");
        word w10 = new word(10,"Verisimilitude","Something that merely seems to be true or real.");


    wordList = Arrays.asList(w1,w2,w3,w4,w5,w6,w7,w8,w9,w10);
    }


    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public word getRandomWord() {
        Random random = new Random();
        int select = random.nextInt(10);
        return wordList.get(select);
    }

}
