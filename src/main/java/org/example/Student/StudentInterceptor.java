package org.example.Student;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class StudentInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before invoking:"+invocation.getActionKey());
        invocation.invoke();
        System.out.println("After invoking:"+invocation.getActionKey());
    }
}
