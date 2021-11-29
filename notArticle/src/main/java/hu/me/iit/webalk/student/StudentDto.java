package hu.me.iit.webalk.student;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;


public class StudentDto {
    @NotNull
    private Long ID;
    @NotBlank
    private String name;
    @NotBlank
    private String major;
    @Min(18)
    private Integer age;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(ID, that.ID) && Objects.equals(name, that.name) && Objects.equals(major, that.major) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID,name,major,age);
    }
}
