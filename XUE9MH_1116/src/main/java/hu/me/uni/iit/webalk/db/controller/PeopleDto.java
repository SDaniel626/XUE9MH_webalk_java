package hu.me.uni.iit.webalk.db.controller;



import hu.me.uni.iit.webalk.db.service.People;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class PeopleDto {

    public PeopleDto(){

    }

    public PeopleDto(People people){
        this.id= people.getId();
        this.name= people.getName();
        this.age= people.getAge();
    }

    private long id;
    @NotEmpty
    private String name;
    @Min(18)
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People toPeople() {
        return new People(id,age,name);
    }
}
