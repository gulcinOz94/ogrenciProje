package entity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Data;
import util.HibernateUtil;



@ManagedBean
@RequestScoped
public class Kaydet {
		
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void kayitGonder(Data data) throws Exception {
			
		
		Session session = null;
		Transaction transaction = null;
		try {
			
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(data);
			//session.save(data);
			transaction.commit();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Kayit işlemi başarılı bir şekilde yapılmıştır."));
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
		
	}
}