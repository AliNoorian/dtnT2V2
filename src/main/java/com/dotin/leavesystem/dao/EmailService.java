package com.dotin.leavesystem.dao;


import com.dotin.leavesystem.models.Email;

import java.util.List;

public interface EmailService {

     List<Email> findAll();
     Email findById(int Id);
     void save(Email email);
     void deleteById(int id);
}
