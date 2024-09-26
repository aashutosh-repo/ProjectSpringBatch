package com.test.batch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.batch.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    // Define custom queries if needed
	List<Weather> findByDate(LocalDate date);
}
