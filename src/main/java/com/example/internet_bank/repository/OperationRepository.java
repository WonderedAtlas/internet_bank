package com.example.internet_bank.repository;

import com.example.internet_bank.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByUserIdAndOperationDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);

    List<Operation> findByUserId(Long userId);

}