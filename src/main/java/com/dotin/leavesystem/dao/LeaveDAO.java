package com.dotin.leavesystem.dao;


import com.dotin.leavesystem.models.Leave;

import java.util.List;

public interface LeaveDAO {

     List<Leave> findAll();
     Leave findById(int Id);
     void save(Leave leave);
     void deleteById(int id);
}
