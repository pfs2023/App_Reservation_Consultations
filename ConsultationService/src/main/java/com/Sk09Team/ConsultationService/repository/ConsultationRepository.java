package com.Sk09Team.ConsultationService.repository;

import com.Sk09Team.ConsultationService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
