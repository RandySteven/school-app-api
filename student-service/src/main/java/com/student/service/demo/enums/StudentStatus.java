package com.student.service.demo.enums;

public enum StudentStatus {
    /**
     * Normal Student
     */
    NORMAL,
    /**
     * Student Council, Top 10 students, students with achievement
     */
    WHITELIST,
    /**
     * Student with 0 score, Student who already got 3 times of sp
     */
    BLACKLIST,
    /**
     * Student who do a cheating in final exam
     */
    DROPOUT
}
