package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author y15079
 * @create 2017-10-23 19:01
 * @desc
 **/
@Service("systemLogService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public int deleteUser(String id) {
		return userDao.deleteByPrimaryKey(id);
	}

    //这里清除的是指定缓存，也就是count方法中
	//执行了inserSQL语句，并remove了count（）方法上的缓存，
	@CacheEvict(value="myCache",key="0",beforeInvocation = true)
	public int insert(User record) {
		return userDao.insertSelective(record);
	}

	public int insertTest(User record) {
		return userDao.insert(record);
	}

	@Cacheable(value = "myCache",key="#id")
	public User findUser(String id) {
		return userDao.selectByPrimaryKey(id);
	}

	public int updateUser(User record) {
		return userDao.updateByPrimaryKeySelective(record);
	}

	//
	@Cacheable(value = "myCache",key = "0")
	public int count() {
		int num= userDao.count();
		return num;
	}
}
