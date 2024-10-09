package org.example.javaee_springboot_lab3;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class UserData {

        @NotEmpty(message = "CANNOT BE EMPTY")
    private String name;
    @Min(value = 18, message = "18 IS MINIMUM")
    private int age;
    private int id;


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}