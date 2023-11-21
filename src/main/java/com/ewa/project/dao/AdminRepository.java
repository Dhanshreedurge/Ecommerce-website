package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
}
