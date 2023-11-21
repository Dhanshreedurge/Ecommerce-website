package com.ewa.project.service;

import java.util.List;

import com.ewa.project.model.AdminDto;

public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto);
    
    AdminDto getAdminById(Long adminId);
    
    List<AdminDto> getAllAdmins();
    
    AdminDto updateAdmin(Long adminId, AdminDto adminDto);
    
    String deleteAdmin(Long adminId);
}
