package com.dotin.leavesystem.service;


import com.dotin.leavesystem.models.Leave;

import java.util.List;

public interface LeaveService {

     List<Leave> findAll();

     Leave findById(int Id);

     void save(Leave leave);

     void deleteById(int Id);
}
