package com.practice.BirthdayCalendar.mapper;

import com.practice.BirthdayCalendar.dto.BirthdayDto;
import com.practice.BirthdayCalendar.model.Birthday;
import org.springframework.stereotype.Component;

@Component
public class BirthdayMapper {

    public BirthdayDto toDto(Birthday birthday){
        return BirthdayDto.builder()
                .id(birthday.getId())
                .person(birthday.getPerson())
                .date(birthday.getDate())
                .comments(birthday.getComments())
                .contacts(birthday.getContacts())
                .build();
    }

    public Birthday fromDto(BirthdayDto dto){
        Birthday birthday = new Birthday();
        birthday.setPerson(dto.getPerson());
        birthday.setDate(dto.getDate());
        birthday.setComments(dto.getComments());
        birthday.setContacts(dto.getContacts());
        return birthday;
    }
}
