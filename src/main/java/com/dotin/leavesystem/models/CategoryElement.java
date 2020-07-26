package com.dotin.leavesystem.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_element", schema = "lms")
public class CategoryElement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_element_id", nullable = false)
    private int categoryElementId;


    @Column(name = "english_name")
    private String englishTypeName;

    @Column(name = "persian_name")
    private String persianTypeName;


    @Column(name = "staff_id")
    private String staffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "employeeRole", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "leaveType", cascade = CascadeType.ALL)
    private List<Leave> leaveType;

    @OneToMany(mappedBy = "leaveStatus", cascade = CascadeType.ALL)
    private List<Leave> leaveStatus;





}
