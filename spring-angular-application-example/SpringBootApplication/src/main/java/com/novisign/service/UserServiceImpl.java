package com.novisign.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novisign.model.UserEntity;
import com.novisign.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserEntity insert(UserEntity userEntityVO) {
    return this.userRepository.save(userEntityVO);
  }

  @Override
  public List<UserEntity> findAll() {

    return (List<UserEntity>) this.userRepository.findAll();
  }

  @Override
  public void delete(int id) {
    this.userRepository.deleteById(id);
  }

  @Override
  public UserEntity findById(int id) {
    return this.userRepository.findById(id).get();
  }

  @Override
  public UserEntity updateUser(int id, UserEntity userEntityVO) {
    userEntityVO.setId(id);
    return this.userRepository.save(userEntityVO);
  }

}
