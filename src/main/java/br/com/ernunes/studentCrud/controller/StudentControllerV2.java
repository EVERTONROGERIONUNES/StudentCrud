package br.com.ernunes.studentCrud.controller;

import br.com.ernunes.studentCrud.model.Student;
import br.com.ernunes.studentCrud.services.StudentServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v2")
public class StudentControllerV2 {

    @Autowired
    private StudentServiceV2 service;

    @PostMapping
    public Student save(@RequestBody Student student){
        return service.save(student);
    }

    @GetMapping
    public List<Student> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student student) throws Exception{
        return service.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") long id) throws Exception{
        service.delete(id);
    }

    @GetMapping("/query/{name}")
    public List<Student> listByName(@PathVariable("name") String name){
        return service.listByName(name);
    }

}
