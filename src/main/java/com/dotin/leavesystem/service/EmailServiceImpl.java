package com.dotin.leavesystem.service;

import com.dotin.leavesystem.dao.EmailDAO;
import com.dotin.leavesystem.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmailServiceImpl implements com.dotin.leavesystem.service.EmailService {

    private final EmailDAO emailDAO;

    @Autowired
    public EmailServiceImpl(EmailDAO emailDAO) {
        this.emailDAO = emailDAO;
    }

    @Override
    @Transactional
    public List<Email> findAll() {
        return emailDAO.findAll();
    }

    @Override
    @Transactional
    public Email findById(int Id) {
        return emailDAO.findById(Id);
    }

    @Override
    @javax.transaction.Transactional
    public void save(Email email) {
        emailDAO.save(email);
    }

    @Override
    @Transactional
    public void deleteById(int Id) {
        emailDAO.deleteById(Id);
    }
}
