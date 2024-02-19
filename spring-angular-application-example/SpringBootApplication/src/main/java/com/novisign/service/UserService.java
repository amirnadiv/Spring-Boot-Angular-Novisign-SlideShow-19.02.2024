package com.novisign.service;

import java.util.List;

import com.novisign.model.UserEntity;

public interface UserService {

	public UserEntity insert(UserEntity userEntityVO);

	public List<UserEntity> findAll();

	public void delete(int id);

	public UserEntity findById(int id);

	public UserEntity updateUser(int id, UserEntity userEntityVO);
}
