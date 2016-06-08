package com.sucsoft.sample.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao <T extends Serializable>{
	
	protected Class<Object> tclass;
	
	@Resource
	protected SessionFactory session;

	public BaseDao(){
		
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
        Type genType = this.getClass().getGenericSuperclass();  
  
        if (!(genType instanceof ParameterizedType)) {  
        	tclass = Object.class;  
        }  
        //返回表示此类型实际类型参数的 Type 对象的数组。  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
  
        if ( 0 >= params.length ) {  
        	tclass = Object.class;  
        }  
        if (!(params[0] instanceof Class)) {  
        	tclass = Object.class;  
        }  
  
        tclass = (Class) params[0];
	}
	
	
	public List<T> queryAll(){
		String hql = "FROM " + tclass.getName()  ;
		return (List<T>)session.getCurrentSession().createQuery(hql).list();
	}
	
	public String add(T entity){
		return (String)session.getCurrentSession().save(entity);
	}
	
	public void del(String id){
		Session s = session.getCurrentSession();
		Object t = s.get(tclass, id);
		if( t != null ){
			s.delete(t);
		}
	}
	
	public T query(String id){
		return (T)session.getCurrentSession().get(tclass, id);
	}
	
	public Query createQuery(String query,Object... params){
		Query q = session.getCurrentSession().createQuery(query);
		if( params != null ){
			for( int i =0,len = params.length ; i < len ; i ++ ){
				q.setParameter(i + 1, params[i]);
			}
		}
			
		return q;
	}
	
	public Query createSqlQuery(String query,Object... params){
		Query q = session.getCurrentSession().createSQLQuery(query);
		if( params != null ){
			for( int i = 0,len = params.length; i < len ; i ++ ){
				q.setParameter(i+1, params[i]);
			}
		}
		return q;
	}
	
	public Class<Object> getSuperClassGenricType(final Class clazz, final int index) {  
        
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
        Type genType = clazz.getGenericSuperclass();  
  
        if (!(genType instanceof ParameterizedType)) {  
           return Object.class;  
        }  
        //返回表示此类型实际类型参数的 Type 对象的数组。  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
  
        if (index >= params.length || index < 0) {  
                     return Object.class;  
        }  
        if (!(params[index] instanceof Class)) {  
              return Object.class;  
        }  
  
        return (Class) params[index];  
    }  
}
