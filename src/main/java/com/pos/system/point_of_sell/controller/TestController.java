package com.pos.system.point_of_sell.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @GetMapping(path = "/get-1")
    public String getMyText(){
        String myText="This is my spring boot project";
        System.out.println(myText);
        return myText;
    }

    @GetMapping(path = "/get-2")
    public String getMyText1(){
        String myText="Hi how are you";
        System.out.println(myText);
        return myText;
    }
    @GetMapping(path = "/get-3")
    public int numberTest(){
        for(int i=0;i<10;i++){
            return i;
        }
        return 1;
    }
}
