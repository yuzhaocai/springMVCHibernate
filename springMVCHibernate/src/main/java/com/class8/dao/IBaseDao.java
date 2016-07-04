package com.class8.dao;

import java.io.Serializable;
import java.util.List;

import com.class8.bean.Page;
import com.class8.bean.Pageable;

public interface IBaseDao<T,ID extends Serializable> {
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ID save(T entity);
	
	/**
	 * 批量保存
	 * @param entitys
	 * @return
	 */
	public Iterable<ID> save(Iterable<T> entitys);
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(T entity);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	public void delete(ID id);
	
	/**
	 * 根据对象删除
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 批量删除对象
	 * @param entitys
	 */
	public void delete(Iterable<? extends T> entities);
	
	/**
	 * 删除所有对象
	 */
	public void deleteAll();
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 根据ID获取对象
	 * @param id
	 * @return
	 */
	public T get(ID id);
	
	/**
	 * 根据ID加载对象
	 * @param id
	 * @return
	 */
	public T load(ID id);
	
	/**
	 * 根据对象时候存在
	 * @param id
	 * @return
	 */
	public boolean exists(ID id);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public long count();
	
	/**
	 * 根据hql语句查询总记录数
	 * @param hql
	 * @param values
	 * @return
	 */
	public long count(String countHql,Object...values);
	
	/**
	 * 根据sql语句查询总记录数
	 * @param sql
	 * @param values
	 * @return
	 */
	public long countBySql(String countSql,Object...values);
	
	/**
	 * 获取全部对象
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 分页获取全部对象
	 * @param page
	 * @param size
	 * @return
	 */
	public List<T> findAll(int page,int size);
	
	/**
	 * 根据hql语句分页获取对象
	 * @param hql
	 * @param page
	 * @param size
	 * @return
	 */
	public List<T> find(Pageable pageable,String hql,Object... values);
	
	/**
	 * 根据sql分页获取对象
	 * @param sql
	 * @param page
	 * @param size
	 * @return
	 */
	public List<T> findBySql(Pageable pageable,String sql,Object... values);
	
	/**
	 * 通过hql语句查询对象
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<T> find(String hql,Object... values);
	
	/**
	 * 通过sql语句查询对象
	 * @param sql
	 * @param values
	 * @return
	 */
	public List<T> findBySql(String sql,Object... values);
	
	/**
	 * 通过hql获取一个对象
	 * @param hql
	 * @param values
	 * @return
	 */
	public T findOne(String hql,Object... values);
	
	/**
	 * 通过sql获取一个对象
	 * @param sql
	 * @param values
	 * @return
	 */
	public T findOneBySql(String sql,Object... values);
	
	/**
	 * 通过hql语句执行数据库更新
	 * @param hql
	 * @param values
	 * @return
	 */
	public int executeUpdate(String hql,Object... values);
	
	/**
	 * 通过sql语句执行数据库更新
	 * @param sql
	 * @param values
	 * @return
	 */
	public int executeUpdateBySql(String sql,Object... values);
		
}
