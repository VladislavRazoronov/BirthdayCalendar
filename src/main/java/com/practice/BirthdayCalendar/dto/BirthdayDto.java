package com.practice.BirthdayCalendar.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BirthdayDto {
    private Long id;

    private String person;

    private Date date;

    private String comments;

    private String contacts;
}
