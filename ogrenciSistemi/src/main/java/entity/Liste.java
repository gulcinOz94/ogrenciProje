package entity;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.apache.commons.io.FileUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class Liste {

	
	private ArrayList<Data> liste=new ArrayList<>();
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
	public Liste() {
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = sessionFactory.openSession();			
			transaction=session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
		    CriteriaQuery<Data> criteriaQuery = builder.createQuery(Data.class);
		    Root<Data> root = criteriaQuery.from(Data.class);		    
		    criteriaQuery.select(root);
			
			Query<Data> query = session.createQuery(criteriaQuery);
			liste  = (ArrayList<Data>) query.getResultList();
			

			transaction.commit();  
			    		
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}	   		
		        
}
    
	public ArrayList<Data> getListe() {
		return liste;
	}
	public void setListe(ArrayList<Data> liste) {
		this.liste = liste;
	}
	
	
	public void silIslemi(int id) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = sessionFactory.openSession();	
			Data data = session.find(Data.class, id);
			transaction=session.beginTransaction();
			session.remove(data);
			transaction.commit();
			
					
			int index=0;
			for(int i=0;i<liste.size();i++) {
				if(liste.get(i).getId()==id) {
					index=i;
					break;
				}
			}
			liste.remove(index);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Silme işlemi başarılı bir şekilde yapılmıştır."));
			
		} catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }		

	
}
	
	/*		
	public void silIslemi(String id) throws ClassNotFoundException, SQLException {
		Transaction transaction=null;    
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		try {
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.createSQLQuery("delete  from Data where id="+Integer.parseInt(id)).executeUpdate();
			transaction.commit();
			
			int index=0;
			for(int i=0;i<liste.size();i++) {
				if(liste.get(i).getId().equals(id)) {
					index=i;
					break;
				}
			}
			liste.remove(index);
			
			
		} catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }		

	
}*/
}

