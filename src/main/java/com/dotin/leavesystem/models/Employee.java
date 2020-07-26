package com.dotin.leavesystem.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee", schema = "lms")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private int employeeId;


    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee employeeManager;

    @OneToMany(mappedBy = "employeeManager", cascade = CascadeType.ALL)
    private List<Employee> managerEmployeesList;

    @OneToMany(mappedBy = "senderEmployee", cascade = CascadeType.ALL)
    private List<Email> senderEmails;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "receiver",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "email_id"))
    private List<Email> receiverEmails;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Leave> leaves;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private CategoryElement employeeRole;



    public Employee() {
    }

    public Employee(String firstName, String lastName,
                    String emailAddress, Employee employeeManager,
                    List<Email> senderEmails, List<Email> receiverEmails,
                    List<Leave> leaves, CategoryElement employeeRole) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.employeeManager = employeeManager;
        this.senderEmails = senderEmails;
        this.receiverEmails = receiverEmails;
        this.leaves = leaves;
        this.employeeRole = employeeRole;


    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Employee getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(Employee employeeManager) {
        this.employeeManager = employeeManager;
    }

    public List<Email> getSenderEmails() {
        return senderEmails;
    }

    public void setSenderEmails(List<Email> senderEmails) {
        this.senderEmails = senderEmails;
    }

    public List<Email> getReceiverEmails() {
        return receiverEmails;
    }

    public void setReceiverEmails(List<Email> receiverEmails) {
        this.receiverEmails = receiverEmails;
    }

    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }

    public CategoryElement getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(CategoryElement employeeRole) {
        this.employeeRole = employeeRole;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", employeeManager=" + employeeManager +
                ", senderEmails=" + senderEmails +
                ", receiverEmails=" + receiverEmails +
                ", leaves=" + leaves +
                ", employeeRole=" + employeeRole +
                '}';
    }



}
