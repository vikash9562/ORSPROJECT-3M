package in.co.rays.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import in.co.rays.dto.userDto;

public class UserModel {
	
	public long add(userDto dto)throws Exception {
		
		String dob = "2002-02-02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		dto.setId(1);
		dto.setFirstName("jays");
		dto.setLastName("ram");
		dto.setLogin("jay@gmail.com");
		dto.setPassword("jay@123");
		dto.setAddress("sihore");
		dto.setDob(sdf.parse(dob));
		
		session.save(dto);
		tx.commit();
		tx.rollback();
		session.close();
		return dto.getId();
		
	}
	
	public void update(userDto dto)throws Exception {
		
		String dob = "2002-02-02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		dto.setId(2);
		dto.setFirstName("kiran");
		dto.setLastName("ram");
		dto.setLogin("jay@gmail.com");
		dto.setPassword("jay@123");
		dto.setAddress("sihore");
		dto.setDob(sdf.parse(dob));
		
		session.update(dto);
		tx.commit();
		tx.rollback();
		session.close();
		
	}
	
	public void delete(userDto dto)throws Exception {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		dto.setId(1);
		
		
		session.delete(dto);
		tx.commit();
		tx.rollback();
		session.close();
		
		
	}
	
	public List search(userDto dto, int pageNo, int pageSize)throws Exception {
		
		String dob = "2002-02-02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		ArrayList<userDto> list = null;
		Criteria c = session.createCriteria(userDto.class);
		
		if (dto != null && dto.getDob().getTime() > 0) {
			c.add(Restrictions.eq("dob", dto.getDob()));
			
		}if (pageSize > 0) {
			pageNo = (pageNo - 1)* pageSize;
			
			c.setFirstResult(pageNo);
			c.setMaxResults(pageSize);
			
			list = (ArrayList<userDto>)c.list();
			
		}
		
		
		return list;
		
	}

}
