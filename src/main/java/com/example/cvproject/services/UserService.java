package com.example.cvproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cvproject.entities.User;
import com.example.cvproject.repos.UserRepository;

@Service
public class UserService {
	
	//service kısmında user controllerdan alınan verileri service üzerinden işlenmesi sağlanmaktadır.
	
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		;
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {//controlda bulunan getmapping ile bağlantılı olarak userların hepsini listeleme işlevi gerçekleştirme
		
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
		// 
		return userRepository.save(newUser);//controlda bulunan post işlemi yaparak database kayıt gerçekleştirmektedir.
	}

	public User getOneUser(Long userId) {//get mapping ile verilen id deki userı getirme işlemi
		
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {//put mapping ile güncelleme yapılmaktadır.foundUser değişkeni ile getirilen user bilgileri put işlemi ile tek tek güncllenmektedir.
		Optional<User> user = userRepository.findById(userId);
		 if(user.isPresent()) {
			 User foundUser = user.get();
			 foundUser.setUserName(newUser.getUserName());
			 foundUser.setPassword(newUser.getPassword());
			 foundUser.setCepNo(newUser.getCepNo());
			 foundUser.setEgitimBilgileri(newUser.getEgitimBilgileri());
			 foundUser.setTecrube(newUser.getTecrube());
			 foundUser.setMail(newUser.getMail());
			 foundUser.setName(newUser.getName());
			 foundUser.setSurName(newUser.getSurName());
			 foundUser.setBeceri(newUser.getBeceri());
			 userRepository.save(foundUser);
			 return foundUser;
		 }else
		 return null;
	}

	public void deletebyId(Long userId) {//delete mapping
		userRepository.deleteById(userId);
		
	}

	public User Login(String userName, String password) {//password ve username sorgula için post mapping işlemi ile sorgulama yapmaktadır.
		User user = userRepository.findUserByUserNameAndPassword(userName,password);
		return user;
				
	}

	
	
}
