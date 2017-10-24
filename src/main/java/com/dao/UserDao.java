package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author y15079
 * @create 2017-10-23 18:58
 * @desc
 **/
@Repository
public interface UserDao {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	int count();
}
