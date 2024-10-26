package org.dev.database.listcrudrepository.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Event(@Id Long id, String city, LocalDate startDate, LocalDate endDate) {
}
