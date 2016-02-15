package main;

import java.util.Calendar;

import com.polytech.model.User;
import com.polytech.service.CommitOperation;
import com.polytech.service.Service;

public class Main {

	public static void main(String[] args) {

		User u = new User();
		u.setFirstName("Younes");
		u.setPassword("jojo");
		u.setBirthDate(Calendar.getInstance());
		u.setEmail("semghouni@gmail.com");
		u.setGender("male");
		u.setLastName("Semghouni");
		Service.commit(CommitOperation.Persist, u);

	}

}
