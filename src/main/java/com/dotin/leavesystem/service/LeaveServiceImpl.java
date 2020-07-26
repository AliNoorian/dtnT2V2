package com.dotin.leavesystem.service;

import com.dotin.leavesystem.dao.LeaveDAO;
import com.dotin.leavesystem.models.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LeaveServiceImpl implements com.dotin.leavesystem.service.LeaveService {

    private final LeaveDAO leaveDAO;

    @Autowired
    public LeaveServiceImpl(LeaveDAO leaveDAO) {
        this.leaveDAO = leaveDAO;
    }

    @Override
    @Transactional
    public List<Leave> findAll() {
        return leaveDAO.findAll();
    }

    @Override
    @Transactional
    public Leave findById(int Id) {
        return leaveDAO.findById(Id);
    }

    @Override
    @Transactional
    public void save(Leave leave) {
        leaveDAO.save(leave);
    }

    @Override
    @Transactional
    public void deleteById(int Id) {
        leaveDAO.deleteById(Id);
    }
}
