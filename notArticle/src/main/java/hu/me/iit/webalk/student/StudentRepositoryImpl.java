package hu.me.iit.webalk.student;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepositoryImpl implements StudentRepository {
    private final List<StudentDto> students = new ArrayList<>();

    public int findStudentById (Long id){
        int found = -1;
        for (int i=0;i<students.size();i++){
            if(students.get(i).getID().equals(id)){
                found = i;
                break;
            }
        }

        return found;
    }

    @Override
    public List<StudentDto> findAll() {
        return students;
    }

    @Override
    public StudentDto getById(Long id) {
        int found = findStudentById(id);
        return found == -1 ? null : students.get(found);
    }

    @Override
    public Long save(StudentDto studentDto) throws TooManyStudentsException {
        int found = findStudentById(studentDto.getID());
        if(found != -1){
            StudentDto foundStudent = students.get(found);
            foundStudent.setName(studentDto.getName());
            foundStudent.setMajor(studentDto.getMajor());
            foundStudent.setAge(studentDto.getAge());
        } else {
            students.add(studentDto);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        int found = findStudentById(id);
        if(found != -1){
            students.remove(found);
        }
    }
}
