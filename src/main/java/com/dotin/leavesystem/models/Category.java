package com.dotin.leavesystem.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category", schema = "lms")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category_entity", cascade = CascadeType.ALL)
    private List<CategoryElement> categoryElements;

    public Category() {
    }

    public Category(String categoryName,
                    List<CategoryElement> categoryElements) {
        super();
        this.categoryName = categoryName;
        this.categoryElements = categoryElements;

    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<CategoryElement> getCategoryElements() {
        return categoryElements;
    }

    public void setCategoryElements(List<CategoryElement> categoryElements) {
        this.categoryElements = categoryElements;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryElements=" + categoryElements +
                '}';
    }

}
