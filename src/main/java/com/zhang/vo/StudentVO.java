package com.zhang.vo;

import com.zhang.entily.Student;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class StudentVO {
    private List<Student> students;
}
