package br.com.ernunes.studentCrud.services;

import br.com.ernunes.studentCrud.model.Student;
import br.com.ernunes.studentCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceV1 {

    @Autowired
    private StudentRepository repository;
    public Student save (Student student){
        return repository.save(student);
    }

    public Student findById(long id) throws Exception{
        return repository.findById(id).orElseThrow( () -> new Exception("Not Found!"));
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Student update(Student student) throws Exception{
        Student s = repository.findById(student.getId()).orElseThrow( () -> new Exception("Not Found!"));
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setInstitution(student.getInstitution());
        s.setCourse(student.getCourse());
        return repository.save(s);
    }

    public void delete(long id) throws Exception{
        Student p = repository.findById(id).orElseThrow( () -> new Exception("Not Found!"));
        repository.delete(p);
    }

}
