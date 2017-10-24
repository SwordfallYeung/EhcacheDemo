package com.service;

import com.model.User;

/**
 * @author y15079
 * @create 2017-10-23 19:00
 * @desc
 **/
public interface UserService {

	int deleteUser(String id);

	int insert(User record);

	int insertTest(User record);

	User findUser(String id);

	int updateUser(User record);

	int count();
}
