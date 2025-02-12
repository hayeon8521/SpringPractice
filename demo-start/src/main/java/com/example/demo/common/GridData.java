package com.example.demo.common;

import java.util.List;

import lombok.Data;

@Data
public class GridData<T> {
	//LIST로 주건 MAP으로주건 아무때나 받을수있음
	List<T> createdRows;
	List<T> deletedRows;
	List<T> updatedRows;
}
