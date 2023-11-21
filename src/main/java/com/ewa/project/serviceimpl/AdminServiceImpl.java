package com.ewa.project.serviceimpl;

import com.ewa.project.service.AdminService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.AdminConverter;
import com.ewa.project.dao.AdminRepository;
import com.ewa.project.entity.Admin;
import com.ewa.project.model.AdminDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminConverter adminConverter;

	@Override
	public AdminDto createAdmin(AdminDto adminDto) {
		Admin admin = adminConverter.convertToAdminEntity(adminDto);
		admin = adminRepository.save(admin);
		return adminConverter.convertToAdminDto(admin);
	}

	@Override
	public AdminDto getAdminById(Long adminId) {
		Admin admin = adminRepository.findById(adminId).orElse(null);
		return adminConverter.convertToAdminDto(admin);
	}

	@Override
	public AdminDto updateAdmin(Long adminId, AdminDto adminDto) {
		Admin admin = adminConverter.convertToAdminEntity(adminDto);
		admin.setAdminId(adminId);
		admin = adminRepository.save(admin);
		return adminConverter.convertToAdminDto(admin);
	}

	@Override
	public String deleteAdmin(Long adminId) {
		adminRepository.deleteById(adminId);
		return "Admin with ID " + adminId + " has been deleted successfully.";
	}

	@Override
	public List<AdminDto> getAllAdmins() {
		List<Admin> admins = adminRepository.findAll();
		List<AdminDto> adminDtos = new ArrayList<>();

		for (Admin admin : admins) {
			adminDtos.add(adminConverter.convertToAdminDto(admin));
		}

		return adminDtos;
	}

}
