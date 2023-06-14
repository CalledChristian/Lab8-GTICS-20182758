package com.example.lab8gtics.Repository;

import com.example.lab8gtics.Entity.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.events.Event;

public interface EventoRepository extends JpaRepository<EventoEntity,Integer> {
}
