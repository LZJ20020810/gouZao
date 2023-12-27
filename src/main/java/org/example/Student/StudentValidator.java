package org.example.Student;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import org.example.common.model.Student;

public class StudentValidator extends Validator {
    @Override
    protected void validate(Controller controller) {
        validateRequiredString("student.name","nameMsg","请输入学生姓名");
        validateRequiredString("student.age","ageMsg","请输入学生年龄");
        validateRequiredString("student.grade","gradeMsg","请输入学生年级");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.keepModel(Student.class);

        String actionKey=getActionKey();
        if(actionKey.equals("/student/save")){
            controller.render("add.html");
        }else if(actionKey.equals("/student/update")){
            controller.render("edit.html");
        }
    }
}
