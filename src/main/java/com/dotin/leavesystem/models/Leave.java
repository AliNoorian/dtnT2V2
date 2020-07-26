package com.dotin.leavesystem.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "leave_table", schema = "lms")
public class Leave {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "leave_id",nullable = false)
    private int leaveId;

    @NotBlank(message="Leave Subject is required")
    @Column(name = "leave_subject",nullable = false)
    private String leaveSubject;

    @NotBlank(message="Leave Message is required")
    @Column(name = "leave_message",nullable = false)
    private String leaveMessage;

    @Column(name = "leave_start")
    @Temporal(TemporalType.DATE)
    private Date leaveFrom;

    @Column(name = "leave_end")
    @Temporal(TemporalType.DATE)
    private Date leaveTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_type")
    private CategoryElement leaveType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_status")
    private CategoryElement leaveStatus;


    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveSubject() {
        return leaveSubject;
    }

    public void setLeaveSubject(String leaveSubject) {
        this.leaveSubject = leaveSubject;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    public Date getLeaveFrom() {
        return leaveFrom;
    }

    public void setLeaveFrom(Date leaveFrom) {
        this.leaveFrom = leaveFrom;
    }

    public Date getLeaveTo() {
        return leaveTo;
    }

    public void setLeaveTo(Date leaveTo) {
        this.leaveTo = leaveTo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CategoryElement getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(CategoryElement leaveType) {
        this.leaveType = leaveType;
    }

    public CategoryElement getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(CategoryElement leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", leaveSubject='" + leaveSubject + '\'' +
                ", leaveMessage='" + leaveMessage + '\'' +
                ", leaveFrom=" + leaveFrom +
                ", leaveTo=" + leaveTo +
                ", employee=" + employee +
                ", leaveType=" + leaveType +
                ", leaveStatus=" + leaveStatus +
                '}';
    }
}
