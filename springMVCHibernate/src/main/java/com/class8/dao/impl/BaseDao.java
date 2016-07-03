package com.class8.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.class8.bean.Page;
import com.class8.bean.Pageable;
import com.class8.dao.IBaseDao;

public class BaseDao<T,ID extends Serializable> implements IBaseDao<T,ID> {
	
	private Class<T> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public BaseDao(){
		Type genType = this.getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
        entityClass = (Class<T>) params[0];  
	}
	
	/**
	 * 获取Session对象
	 * @return
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ID save(T entity){
		return (ID) getSession().save(entity);
	}
	
	/**
	 * 批量保存
	 * @param entitys
	 * @return
	 */
	public Iterable<ID> save(Iterable<T> entitys){
		//TODO
		return null;
	}
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(T entity){
		getSession().saveOrUpdate(entity);
	}
	
	/**
	 * 根据Id删除对象
	 * @param id
	 */
	public void delete(ID id){
		getSession().delete(get(id));
	}
	
	/**
	 * 删除对象
	 * @param entity
	 */
	public void delete(T entity){
		getSession().delete(entity);
	}
	
	/**
	 * 批量删除
	 * @param entities
	 */
	public void delete(Iterable<? extends T> entities){
		//TODO
	}
	
	/**
	 * 删除所有对象
	 */
	public void deleteAll(){
		//TODO
	}
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity){
		getSession().update(entity);
	}
	
	/**
	 * 根据Id获取对象
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(ID id){
		return (T) getSession().get(this.entityClass, id);
	}
	
	/**
	 * 根据Id加载对象(返回的为代理对象)
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T load(ID id){
		return (T) getSession().load(this.entityClass, id);
	}
	
	/**
	 * 判断对象是否存在
	 * @param id
	 * @return
	 */
	public boolean exists(ID id){
		return get(id) != null;
	}
	
	/**
	 * 获取对象的总数
	 * @return
	 */
	public long count(){
		Criteria criteria = getSession().createCriteria(entityClass);
        return Integer.valueOf(criteria.setProjection(Projections.rowCount())  
                .uniqueResult().toString());  
	}
	
	/**
	 * 根据hql语句获取对象总数
	 * @param hql
	 * @param values
	 * @return
	 */
	public long count(String countHql, Object... values){
		Query query = this.createQuery(countHql, values);
		return (long) query.uniqueResult();
	}
	
	/**
	 * 根据sql语句获取分页的总数
	 * @param sql
	 * @param values
	 * @return
	 */
	public long countBySql(String countSql,Object... values){
		SQLQuery sqlQuery = this.createSQLQuery(countSql, values);
		return (long) sqlQuery.uniqueResult();
	}
	
	/**
	 * 获取全部对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		Query query = getSession().createQuery(" from " + this.entityClass.getSimpleName());
		return query.list();
	}
	
	/**
	 * 分页查询全部对象
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<T> findAll(Pageable pageable){
		//TODO
		return null;
	}
	
	/**
	 * 根据hql分页查询对象
	 * @param hql
	 * @param page
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(Pageable pageable,String hql,Object... values){
		Query query = this.createQuery(hql, values); 
		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<T> result = query.list();
		return result;
	}
	
	/**
	 * 根据sql分页查询对象
	 * @param sql
	 * @param page
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findBySql(Pageable pageable,String sql,Object... values){
		SQLQuery sqlQuery = this.createSQLQuery(sql, values); 
		sqlQuery.setFirstResult(pageable.getOffset());
		sqlQuery.setMaxResults(pageable.getPageSize());
		sqlQuery.addEntity(entityClass);
		List<T> result = sqlQuery.list();
		return result;
	}
	
	/**
	 * 通过hql语句进行查询
	 * @param hql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql,Object... values){
		return createQuery(hql,values).list();
	}
	
	/**
	 * 通过sql语句进行查询
	 * @param sql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findBySql(String sql,Object... values){
		SQLQuery sqlQuery = createSQLQuery(sql, values);
		//设置查询实体
		sqlQuery.addEntity(entityClass);
		return sqlQuery.list();
	}
	
	/**
	 * 通过hql语句获取唯一结果对象
	 * @param hql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T findOne(String hql,Object... values){
		Query query = createQuery(hql, values);
		return (T) query.uniqueResult();
	}
	
	/**
	 * 通过sql获取唯一结果对象
	 * @param sql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T findOneBySql(String sql,Object... values){
		SQLQuery sqlQuery = createSQLQuery(sql, values);
		sqlQuery.addEntity(entityClass);
		return (T) sqlQuery.uniqueResult();
	}
	
	/**
	 * 通过hql语句执行数据库更新
	 * @param hql
	 * @param values
	 */
	public int executeUpdate(String hql,Object... values){
		return createQuery(hql, values).executeUpdate();
	}
	
	/**
	 * 通过sql语句执行数据库更新
	 * @param sql
	 * @param values
	 * @return
	 */
	public int executeUpdateBySql(String sql,Object... values){
		return createSQLQuery(sql, values).executeUpdate();
	}
	
	/**
	 * 创建Query查询对象
	 * @param hql
	 * @param values
	 * @return
	 */
	private Query createQuery(String hql,Object... values){
		Query query = getSession().createQuery(hql);
		setQueryParameters(query, values);
		return query;
	}
	
	//TODO Page查询？
	
	/**
	 * 创建SQLQuery查询对象
	 * @param sql
	 * @param values
	 * @return
	 */
	private SQLQuery createSQLQuery(String sql,Object... values){
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		setQueryParameters(sqlQuery, values);
		return sqlQuery;
	} 
	
	/**
	 * 填充查询语句的参数值
	 * @param query
	 * @param values
	 */
	private void setQueryParameters(Query query,Object... values){
		if(values != null){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
	}

	@Override
	public List<T> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}
