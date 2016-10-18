package com.nmvk.raghav.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -978689604705426827L;

	public int avery;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Serial s = new Serial();
		s.avery = 112;
		
		FileOutputStream fis = new FileOutputStream("outdata");
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		
		FileInputStream fos = new FileInputStream("outdata");
		ObjectInputStream ois = new ObjectInputStream(fos);
		Serial d = (Serial) ois.readObject();
		
		System.out.println(d.avery);
	}

}
