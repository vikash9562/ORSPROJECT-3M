package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.userDto;
import in.co.rays.model.UserModel;

public class UserTest {
	
	public static void main(String[] args) throws Exception{
		
		//testadd();
		//testupdate();
		//testdelete();
		testsearch();
	}

	private static void testsearch()throws Exception {
		
		String dob = "2002-02-02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		userDto dto = new userDto();
		UserModel model = new UserModel();
		
		dto.setDob(sdf.parse(dob));
		
		ArrayList<userDto> list = (ArrayList<userDto>) model.search(dto, 0, 1);
		
		for (userDto Dto : list) {
			
			System.out.println(Dto.getId());
			System.out.println(Dto.getFirstName());
			System.out.println(Dto.getLastName());
			System.out.println(Dto.getLogin());
			System.out.println(Dto.getPassword());
			System.out.println(dto.getAddress());
			System.out.println(Dto.getDob());
			
		}
		
		
	
		
	}

	private static void testdelete()throws Exception {
		
		userDto dto = new userDto();
		UserModel model = new UserModel();
		
		model.delete(dto);
		
	}

	private static void testupdate()throws Exception {
		
		userDto dto = new userDto();
		UserModel model = new UserModel();
		
		model.update(dto);
		
		
	}

	private static void testadd()throws Exception {
		
		userDto dto = new userDto();
		UserModel model = new UserModel();
		
		model.add(dto);	
		
	}

}
