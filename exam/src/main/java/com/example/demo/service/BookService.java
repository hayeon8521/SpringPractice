package com.example.demo.service;

import java.util.List;

public interface BookService {
	public List<BookDTO> getList();
	
	public void insert(BookDTO bookDTO);
	
	public List<BookDTO> getListde();
}
