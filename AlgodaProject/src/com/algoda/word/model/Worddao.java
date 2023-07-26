package com.algoda.word.model;

import java.util.List;
import java.util.Map;

import com.algoda.voc.model.Myvocdto;

public interface Worddao {
	public List<Worddto> selectListPage(Map<String,Object> map);
	
	
	public int selectCount(Map<String,Object> map);


	public void close();

	public int insertMyvoc(String insertingword,String id );
}
