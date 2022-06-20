package com.example.cvproject.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cvproject.entities.Admin;

import com.example.cvproject.services.AdminService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admins")


public class AdminController {

	private AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@PostMapping
	public Admin createAdmin(@RequestBody Admin newAdmin) {
		return adminService.saveOneAdmin(newAdmin);
	}
	
	@GetMapping("/{adminId}")
	public Admin getOneAdmin(@PathVariable Long adminId) {
		return adminService.getOneAdmin(adminId);
	}
	
	@PutMapping("/{adminId}")
	public Admin updateOneAdmin(@PathVariable Long adminId, @RequestBody Admin newAdmin) {
		return adminService.updateOneAdmin(adminId,newAdmin);
	}
	@DeleteMapping("/{adminId}")
	private void deleteOneAdmin(@PathVariable Long adminId) {
		adminService.deleteOneAdmin(adminId);

	}	
	
	@PostMapping("/adminlogin")
	public Object Admin(@RequestBody Admin newAdmin) {
		Admin response = adminService.admin(newAdmin.getAdminName(),newAdmin.getPassword());
		System.out.println("---------------------------------------------------------");
		System.out.println(response);
		 if(response!=null) {
			 return response;
		 }
		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	
	
}
