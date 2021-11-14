package hu.me.uni.iit.webalk.db.controller;



import hu.me.uni.iit.webalk.db.service.People;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PeopleCreateDto {

    public PeopleCreateDto(){

    }

    public PeopleCreateDto(People people){
        this.name= people.getName();
        this.age= people.getAge();
    }

    @NotEmpty
    private String name;
    @Size(min=18)
    private int age;


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

    public People toPeople(){
        return new People(null,age,name);
    }
}
