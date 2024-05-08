package com.practice.BirthdayCalendar.repository;

import com.practice.BirthdayCalendar.mapper.BirthdayMapper;
import com.practice.BirthdayCalendar.model.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BirthdayRepository extends JpaRepository<Birthday, Long> {

    List<Birthday> findByDate(Date date);

    List<Birthday> findByPerson(String person);

    Birthday findById(int id);

}
