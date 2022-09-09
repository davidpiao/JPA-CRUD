package com.crud.backend;

import com.crud.backend.model.Major;
import com.crud.backend.model.User;
import com.crud.backend.repository.MajorRepository;
import com.crud.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MajorRepository majorRepository;

	//디비에 정보 넣기 위해서 사용한 run 메소드
	@Override
	public void run(String... args) throws Exception {
//		Major major= new Major();
//		major.setMajors("전산전자공학부");
//		major.setDetail_major("컴퓨터공학심화");
//		major.setYear(4);
//		major.setSemester(8);
//		majorRepository.save(major);
//
		User user = new User();
		user.setName("David");
		user.setStudentId("21700266");
		user.setEmailId("david@handong.ac.kr");
		user.setPassword("qwer");
//		user.setMajor(major);
		userRepository.save(user);
//
//		User user1 = new User();
//		user1.setName("Apple");
//		user1.setStudentId("2022");
//		user1.setEmailId("apple@apple.com");
//		user1.setMajor(major);
//		userRepository.save(user1);
	}
}
