package com.practice.BirthdayCalendar.controller;

import com.practice.BirthdayCalendar.dto.BirthdayDto;
import com.practice.BirthdayCalendar.service.BirthdayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BirthdaysController {

    private final BirthdayService birthdayService;

    @GetMapping("/birthdays")
    public ResponseEntity<List<BirthdayDto>> getBirthdays(@RequestParam(required = false)Date date){
        return ResponseEntity.ok(birthdayService.getBirthdays(date));
    }

    @GetMapping("/birthdays/{id}")
    public ResponseEntity<BirthdayDto> getBirthdayById(@PathVariable Long id){
        return ResponseEntity.ok(birthdayService.getBirthdayById(id).orElseThrow(
                ()-> new RuntimeException("Birthday with that Id doesn't exist")
        ));
    }

    @PostMapping("/birthdays")
    public ResponseEntity<BirthdayDto> createBirthday(@RequestBody @Validated BirthdayDto birthdayDto){
        return ResponseEntity.ok().body(birthdayService.createBirthday(birthdayDto));
    }

    @DeleteMapping("/birthdays/{id}")
    public ResponseEntity<BirthdayDto> deleteBirthday(@PathVariable Long id){
        return ResponseEntity.ok().body(birthdayService.deleteBirthdayById(id).orElseThrow(
                ()-> new RuntimeException("Birthday with that Id doesn't exist")
        ));
    }
}
