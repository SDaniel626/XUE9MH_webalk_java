package hu.me.iit.webalk.student;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {
    private final int maxStudentNumber = 5;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDto getById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Long save(StudentDto studentDto) throws TooManyStudentsException {
        if(studentRepository.findAll().size() >= maxStudentNumber){
            throw new TooManyStudentsException();
        }

        return studentRepository.save(studentDto);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
