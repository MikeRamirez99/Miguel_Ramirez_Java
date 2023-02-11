package com.company.summative1.controllers;
import com.company.summative1.models.magic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class magicController {
    private List<magic> magicList;

    public magicController(){
        magic m1 = new magic(1,"Will we have good weather this week?","You will find out soon enough.");
        magic m2 = new magic(2,"Will we have good weather this week?","As I see it, yes.");
        magic m3 = new magic(3,"Will we have good weather this week?","Better not tell you now.");
        magic m4 = new magic(4,"Will we have good weather this week?","Don't count on it.");
        magic m5 = new magic(5,"Will we have good weather this week?","My sources say no.");
        magic m6 = new magic(6,"Will we have good weather this week?","You may rely on it.");

        magicList = Arrays.asList(m1,m2,m3,m4,m5,m6);
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public magic getRandomMagicAnswer(@RequestParam(value = "question", required = false) String question) {
        Random random = new Random();
        int select = random.nextInt(6);
        System.out.print(question);
        magicList.get(select).setQuestion(question);
        return magicList.get(select);
    }

}
