package com.zhang.controller;

import com.zhang.servce.WeekdayService;
import com.zhang.vo.CountWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weekday")
public class WeekdayController {

    @Autowired
    WeekdayService weekdayService;

    @RequestMapping("/forms")
    public List<Integer> forms() {
        return weekdayService.getFormsWeekday();
    }

    @RequestMapping("/sw")
    public List<CountWT> sw() {
        return weekdayService.getSW();
    }
}
