package com.example.cvproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cvproject.entities.Admin;
import com.example.cvproject.repos.AdminRepository;

@Service

public class AdminService {
	
	AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		
		this.adminRepository = adminRepository;
	}

	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	public Admin saveOneAdmin(Admin newAdmin) {
		// TODO Auto-generated method stub
		return adminRepository.save(newAdmin);
	}

	public Admin getOneAdmin(Long adminId) {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId).orElse(null);
	}

	public Admin updateOneAdmin(Long adminId, Admin newAdmin) {
		Optional<Admin> admin = adminRepository.findById(adminId);
		if (admin.isPresent()) {
			Admin foundAdmin = admin.get();
			foundAdmin.setAdminName(newAdmin.getAdminName());
			foundAdmin.setPassword(newAdmin.getPassword());
			adminRepository.save(foundAdmin);
			return foundAdmin;
			
		}else
		return null;
	}

	public void deleteOneAdmin(Long adminId) {
		adminRepository.deleteById(adminId);
	}

	public Admin admin(String adminName, String password) {
		Admin admin = adminRepository.findAdminByAdminNameAndPassword(adminName,password);
		return admin;
	}

}
