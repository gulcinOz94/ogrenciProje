package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entity.Kaydet;
import entity.Data;
@SessionScoped
@ManagedBean
public class DataBean {

	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public DataBean() {
		this.data = new Data();
	}

	public String save() {
		Kaydet kayit=new Kaydet();
		try {
		kayit.kayitGonder(this.data);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success?faces-redirect=true";
	}
	
	
}