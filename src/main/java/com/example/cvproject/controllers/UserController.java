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

import com.example.cvproject.entities.User;

import com.example.cvproject.services.UserService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")

public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	//get mapping işlemi ile userların hepsini databaseden liste olarak çekme işlemi gerçekleştiriliyor.
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();//mvc ye uymak için user getter setter komutlarını userservice e bağladık.
		
	}
	@PostMapping("/signup")//post mapping işlemi ile frontend kısmında bulunan signup portuna post yapmak için veri kaydetmek için database e post işlemi yapılıyor.
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);//sadece 1 user için tek seferde post işlemi
	}
	
	@GetMapping("/{userId}")//get mapping ile id si verilen user ı database üzerinden çekme işlemi
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUser(userId);
	}
	
	 @PutMapping("/update/{userId}")//put mapping işlemi olan user a id üzerinden put işlemi yaparak user ın güncellemesini sağlamaktadır.
	 public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		 return userService.updateOneUser(userId,newUser);
	 }
	 @DeleteMapping("/{userId}")//user id ye bağlı olan kullanıcı silme işlemi için 
	 public void deleteOneUser(@PathVariable Long userId) {
		 userService.deletebyId(userId);
	 }
	 
	 @PostMapping("/Login")//frontend kısmında login portunda kullanıcının girdiği password ve user name i database üzerinde post atarak kontrol etmek için
public Object login(@RequestBody User newUser) {
		 User response = userService.Login(newUser.getUserName(),newUser.getPassword());
		 System.out.println(response);
		 if(response!=null) {
			 return response;
		 }
		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	 }
	

	
	

}
