package com.dotin.leavesystem.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "email", schema = "lms")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id", nullable = false)
    private int emailId;


    @Column(name = "subject_mail")
    private String subject;


    @Column(name = "message")
    private String message;


    @Column(name = "attachment")
    private String attachment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Employee senderEmployee;

    @ManyToMany(mappedBy = "receiverEmails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> recievers;


    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Employee getSenderEmployee() {
        return senderEmployee;
    }

    public void setSenderEmployee(Employee senderEmployee) {
        this.senderEmployee = senderEmployee;
    }

    public List<Employee> getRecievers() {
        return recievers;
    }

    public void setRecievers(List<Employee> recievers) {
        this.recievers = recievers;
    }


    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", attachment='" + attachment + '\'' +
                ", senderEmployee=" + senderEmployee +
                ", recievers=" + recievers +
                '}';
    }

}
