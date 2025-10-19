package com.mycompany.app.service;

import com.mycompany.app.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDao extends JpaRepository<Event, Integer> {
}
