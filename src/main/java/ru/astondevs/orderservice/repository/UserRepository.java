package ru.astondevs.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.astondevs.orderservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
