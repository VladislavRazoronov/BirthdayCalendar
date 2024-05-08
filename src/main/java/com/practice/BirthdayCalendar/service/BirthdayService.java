package com.practice.BirthdayCalendar.service;

import com.practice.BirthdayCalendar.dto.BirthdayDto;
import com.practice.BirthdayCalendar.mapper.BirthdayMapper;
import com.practice.BirthdayCalendar.model.Birthday;
import com.practice.BirthdayCalendar.repository.BirthdayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BirthdayService {

    private final BirthdayRepository repository;

    private final BirthdayMapper birthdayMapper;

    public List<BirthdayDto> getBirthdays(Date date){
        return Optional
                .ofNullable(date)
                .map(repository::findByDate)
                .orElseGet(repository::findAll)
                .stream()
                .map(birthdayMapper::toDto)
                .toList();
    }

    public BirthdayDto createBirthday(BirthdayDto birthdayDto){
        Birthday birthday = birthdayMapper.fromDto(birthdayDto);
        Birthday createdBirthday = repository.save(birthday);
        return birthdayMapper.toDto(createdBirthday);
    }

    public Optional<BirthdayDto> deleteBirthdayById(Long id){
        Optional<BirthdayDto> birthdayDto = repository.findById(id).map(birthdayMapper::toDto);
        repository.deleteById(id);
        return  birthdayDto;
    }

    public Optional<BirthdayDto> getBirthdayById(Long id){
        return repository.findById(id).map(birthdayMapper::toDto);
    }

    public List<BirthdayDto> getBirthdayByDate(Date date){
        return repository.findByDate(date).stream().map(birthdayMapper::toDto).toList();
    }

    public List<BirthdayDto> getBirthdayByPerson(String person){
        return repository.findByPerson(person).stream().map(birthdayMapper::toDto).toList();
    }
}
