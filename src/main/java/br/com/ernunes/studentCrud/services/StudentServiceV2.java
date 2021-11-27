package br.com.ernunes.studentCrud.services;

import br.com.ernunes.studentCrud.model.Student;
import br.com.ernunes.studentCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceV2 {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private EntityManager em;

    public Student save (Student student){
        student.setRegisterDate(new Date());
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
        s.setGender(student.getGender());
        return repository.save(s);
    }

    public void delete(long id) throws Exception{
        Student p = repository.findById(id).orElseThrow( () -> new Exception("Not Found!"));
        repository.delete(p);
    }

    public List<Student> listByName(String name){
        String hql = "from Student where firstName like: name order by firstName";
        Query query = em.createQuery(hql);
        query.setParameter("name", name + "%");
        List<Student> people = query.getResultList();
        return  people;
    }
}
