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

    @OneToMany(mappedBy = "employee_role", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "leave_type", cascade = CascadeType.ALL)
    private List<Leave> typeVacations;

    @OneToMany(mappedBy = "leave_status", cascade = CascadeType.ALL)
    private List<Leave> statusVacations;





}
