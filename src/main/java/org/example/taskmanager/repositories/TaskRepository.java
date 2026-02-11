package org.example.taskmanager.repositories;

import org.example.taskmanager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public interface TaskRepository extends JpaRepository<Task, Long> {

}