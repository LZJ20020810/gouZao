package org.example.Student;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import org.example.common.model.Student;

@Path("/student")
@Before(StudentInterceptor.class)
public class StudentController extends Controller {
    @Inject
    StudentService studentService;

    public void index(){
        setAttr("studentPage",
                studentService.paginate(getParaToInt(0,1),10));
        render("student.html");
    }

    public void add(){

    }

    @Before(StudentValidator.class)
    public void save(){
        getBean(Student.class).save();
        redirect("/student");
    }

    public void edit(){
        setAttr("student",studentService.findById(getParaToInt()));
    }

    @Before(StudentValidator.class)
    public void update(){
        getBean(Student.class).update();
        redirect("/student");
    }

    public void delete(){
        studentService.deleteById(getParaToInt());
        redirect("/student");
    }

    public void check(){
        int id=Integer.parseInt(getPara("id"));
        System.out.println("id   "+id);
        Student student=studentService.findById(id);
        System.out.println("student  "+student);
        setAttr("student",student);
        render("one.html");
    }
}
