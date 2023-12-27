package org.example.Student;

import com.jfinal.plugin.activerecord.Page;
import org.example.common.model.Student;

public class StudentService {
    private Student dao=new Student().dao();

    public Page<Student> paginate(int pageNumber,int pageSize){
        return dao.paginate(pageNumber,pageSize,"select *","from jfinalstudent order by id asc");
    }

    public Student findById(int id){
        return dao.findById(id);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }
}
