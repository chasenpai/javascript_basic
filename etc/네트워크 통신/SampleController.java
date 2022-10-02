package com.example.js;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @GetMapping("/")
    public String main(){
        return "sample1";
    }


    @GetMapping("/sample1")
    @ResponseBody
    public String sample1(){
        return "hello world!";
    }


    @GetMapping("/sample2")
    @ResponseBody
    public SampleDto sample2(){
        return new SampleDto("차준우", "25", "남");
    }


    @PostMapping("/sample3")
    @ResponseBody
    public SampleDto sample3(@RequestBody SampleDto sampleDto){

        return  sampleDto;
    }


    @PostMapping("/sample4")
    @ResponseBody
    public SampleDto sample4(SampleDto sampleDto){

        return sampleDto;
    }


    @GetMapping("/sample5")
    @ResponseBody
    public ResponseEntity sample5(){

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/sample6")
    @ResponseBody
    public List<SampleDto> sample6(){

        List<SampleDto> sampleDtoList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            SampleDto sampleDto = new SampleDto();
            sampleDto.setName("사람" + i);
            sampleDto.setAge(String.valueOf(25 + i));
            sampleDto.setGender("남자");
            sampleDtoList.add(sampleDto);
        }

        return sampleDtoList;
    }


    @PostMapping("/sample7")
    public String sample7(@RequestParam("comment") String comment, Model model){

        List<String> commentList = new ArrayList<>();
        commentList.add(comment);

        model.addAttribute("commentList", commentList);

        return "sample1 :: #commentList";
    }
    

}
