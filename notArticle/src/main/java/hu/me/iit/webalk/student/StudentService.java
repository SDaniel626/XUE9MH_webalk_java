package hu.me.iit.webalk.student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    StudentDto getById(Long id);
    Long save(StudentDto studentDto) throws TooManyStudentsException;
    void deleteById(Long id);
}
