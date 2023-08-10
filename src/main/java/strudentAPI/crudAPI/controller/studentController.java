package strudentAPI.crudAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import strudentAPI.crudAPI.model.student;
import strudentAPI.crudAPI.respository.studentRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class studentController {

    @Autowired
    private studentRepository studentrepository;

    @GetMapping(value = "/students")
    public List<student> getStudents(){
        return studentrepository.findAll();
    }

    @PostMapping(value = "/savestudents")
    public String saveStudents(@RequestBody student students){
        studentrepository.save(students);
        return "Estudiante registrado";
    }

    @PutMapping(value = "/updatestudents/{id}")
    public String updateStudents(@RequestBody student students, @PathVariable long id){
        student updateStudents = studentrepository.findById(id).get();

        updateStudents.setNombre(students.getNombre());
        updateStudents.setApellido(students.getApellido());
        updateStudents.setDocumento(students.getDocumento());

        studentrepository.save(updateStudents);

        return "Estudiante modificado";
    }

    @DeleteMapping(value = "/deletestudents/{id}")
    public String deleteStudent(@RequestBody student student, @PathVariable long id){
        student deleteStudent = studentrepository.findById(id).get();
        studentrepository.delete(deleteStudent);

        return "Estudiante eliminado";
    }
}
