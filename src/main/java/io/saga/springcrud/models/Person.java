package io.saga.springcrud.models;

import javax.validation.constraints.*;


public class Person {
    public Person(){

    }

    private int id;

    @NotEmpty(message = "name field can't be empty")
    @Size(min=2, max =15, message = "name should have more 2,and less 15 letters")
    private String name;

    @Min(value = 0,message = "Wrong age!")
    private int age;

    @NotEmpty(message = "email filed shouldn't be empty")
    @Email(message = "Write correct email f.e: some-email@mail.io")
    private String email;
    @Pattern(regexp = "[A-Z,a-z]\\w+,[A-Z]\\w+,\\d{6}",message = "Please write correct address: Country, City,Postcode (6 digits)")
    private String address;
    //Country,City,Postcode.

    public Person(int id, String name,int age, String email,String address) {
        this.id = id;
        this.name = name;
        this.age=age;
        this.email=email;
        this.address=address;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
}
