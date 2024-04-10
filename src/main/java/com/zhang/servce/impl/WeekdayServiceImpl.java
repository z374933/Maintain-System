package com.zhang.servce.impl;

import com.zhang.entily.Weekday;
import com.zhang.mapper.WeekdayMapper;
import com.zhang.servce.WeekdayService;
import com.zhang.vo.CountWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WeekdayServiceImpl implements WeekdayService {

    @Autowired
    WeekdayMapper weekdayMapper;

    public List<Integer> getFormsWeekday() {
        List<Weekday> weekdays = weekdayMapper.listWeekdayForms();
        ArrayList<Integer> list = new ArrayList<>(7);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        for (int i = 0; i < weekdays.size(); i++) {
            String week = weekdays.get(i).getWeekday();
            if (week.equals("Monday")) {
                list.add(0, weekdays.get(i).getSum());
            }
            if (week.equals("Tuesday")) {
                list.add(1, weekdays.get(i).getSum());
            }
            if (week.equals("Wednesday")) {
                list.add(2, weekdays.get(i).getSum());
            }
            if (week.equals("Thursday")) {
                list.add(3, weekdays.get(i).getSum());
            }
            if (week.equals("Friday")) {
                list.add(4, weekdays.get(i).getSum());
            }
            if (week.equals("Saturday")) {
                list.add(5, weekdays.get(i).getSum());
            }
            if (week.equals("Sunday")) {
                list.add(6, weekdays.get(i).getSum());
            }
        }
        return list;
    }

    @Override
    public List<CountWT> getSW() {
        return weekdayMapper.listCountWT();
    }

}
