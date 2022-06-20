package com.example.cvproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cvproject.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

	Admin findAdminByAdminNameAndPassword(String adminName, String password);

}
