package com.nmvk.raghav.java;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class Simple implements Action, Closeable {
	
	class Drup 
	{
		final static int j = 2;
		public void wow()
		{
			x = 22;
		}
	}
	public int x;
	private static Simple instance = null;
	private Simple()
	{
		
	}
	
	public static void main(String[] args) {
		String s = "Raghav";
		System.out.println(s ==  new String("Raghav").intern());
		Action.printWow();
		Simple sm = new Simple();
	}
	
	public synchronized static Simple getInstance()
	{
		if(null == instance){
			instance = new Simple();
		}
		
		return instance;
	}

	@Override
	public boolean add(String e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
