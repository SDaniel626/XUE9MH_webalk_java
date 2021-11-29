package hu.me.iit.webalk.student;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "student")
public class MainController {
    private final StudentService studentService;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDto> allStudents() {
        return studentService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto getStudentById(@PathVariable("id") Long id){
        return studentService.getById(id);
    }

    @PostMapping(path = "")
    public void newStudent(@RequestBody @Valid StudentDto studentDto) throws TooManyStudentsException {
        studentService.save(studentDto);
    }

    @PutMapping(path = "/")
    public void replaceStudent(@RequestBody @Valid StudentDto studentDto) throws TooManyStudentsException {
        studentService.save(studentDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }
}
