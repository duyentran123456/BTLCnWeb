package cnweb.dao;

import java.util.List;

import cnweb.mapper.RowMapper;

public interface GenericDAO<T> {
	
	List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) ;

	void update(String sql, Object... parameters) ;

	Integer insert(String sql, Object... parameters) ;

	int count(String sql, Object... parameters) ;
}
