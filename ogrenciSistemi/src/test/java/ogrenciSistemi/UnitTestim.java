package ogrenciSistemi;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Data;
import entity.DataBean;
import entity.Kaydet;
import entity.Liste;
import junit.*;


public class UnitTestim {
	
	
	@Test
	public void testKayit() {

		DataBean kayit=new DataBean();
		Data data=new Data("Gulo","BOZOK","05347865214","ANKARA","ÇANKAYA","yeni kayıt");
		kayit.setData(data);
		kayit.getData();
		kayit.save();
	
	}
		
	@Test
	public void testListe() {
		
		Liste liste=new Liste();
		ArrayList<Data> list=liste.getListe();
		System.out.println();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			
		}
		
	
	}
	
	
	
}
