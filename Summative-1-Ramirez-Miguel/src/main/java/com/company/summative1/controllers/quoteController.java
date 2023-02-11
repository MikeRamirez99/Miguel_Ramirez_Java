package com.company.summative1.controllers;
import com.company.summative1.models.quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class quoteController {
private List<quote> quoteList;

public quoteController() {
    quote q1 = new quote(1,"Nelson Mandela","The greatest glory in living lies not in never falling, but in rising every time we fall.");
    quote q2 = new quote(2,"Oscar Wilde","Be yourself; everyone else is already taken.");
    quote q3 = new quote(3,"Albert Einstein","Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.");
    quote q4 = new quote(4,"Frank Zappa","So many books, so little time.");
    quote q5 = new quote(5,"Marcus Tullius Cicero","A room without books is like a body without a soul.");
    quote q6 = new quote(6,"Bernard M. Baruch","Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.");
    quote q7 = new quote(7,"Dr. Seuss","You know you're in love when you can't fall asleep because reality is finally better than your dreams.");
    quote q8 = new quote(8,"Mae West","You only live once, but if you do it right, once is enough.");
    quote q9 = new quote(9,"Mahatma Gandhi","Be the change that you wish to see in the world.");
    quote q10 = new quote(10,"Robert Frost","In three words I can sum up everything I've learned about life: it goes on.");

    quoteList = Arrays.asList(q1,q2,q3,q4,q5,q6,q7,q8,q9,q10);

}

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public quote getRandomQuote() {
        Random random = new Random();
        int select = random.nextInt(10);
        return quoteList.get(select);
    }

}
