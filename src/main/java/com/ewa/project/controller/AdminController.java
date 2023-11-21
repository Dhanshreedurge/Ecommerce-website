package com.ewa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewa.project.exception.AdminNotFoundException;
import com.ewa.project.model.AdminDto;
import com.ewa.project.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/createAdmin")
	public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
		AdminDto createdAdmin = adminService.createAdmin(adminDto);
		return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
	}

	@GetMapping("/{adminId}")
	public ResponseEntity<AdminDto> getAdminById(@PathVariable Long adminId) {
		AdminDto adminDto = adminService.getAdminById(adminId);
		if (adminDto == null) {
	        throw new AdminNotFoundException("Admin not found with ID: " + adminId);
	    }
		return new ResponseEntity<>(adminDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAllAdmins")
	public ResponseEntity<List<AdminDto>> getAllAdmins() {
	    List<AdminDto> admins = adminService.getAllAdmins();
	    return new ResponseEntity<>(admins, HttpStatus.OK);
	}

	@PutMapping("/{adminId}")
	public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long adminId, @RequestBody AdminDto adminDto) {
		AdminDto updatedAdmin = adminService.updateAdmin(adminId, adminDto);
		return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
	}

	@DeleteMapping("/{adminId}")
	public String deleteAdmin(@PathVariable Long adminId) {
		
		return adminService.deleteAdmin(adminId);
	}
}
