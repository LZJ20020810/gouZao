package org.example.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

public abstract class BaseStudent<M extends BaseStudent<M>> extends Model<M> implements IBean {

    /**
     * id注释
     */
    public void setId(java.lang.Integer id) {
        set("id", id);
    }

    /**
     * id注释
     */
    public java.lang.Integer getId() {
        return getInt("id");
    }

    /**
     * name注释
     */
    public void setName(java.lang.String name) {
        set("name", name);
    }

    /**
     * name注释
     */
    public java.lang.String getName() {
        return getStr("name");
    }

    /**
     * age注释
     */
    public void setAge(java.lang.Integer age) {
        set("age", age);
    }

    /**
     * age注释
     */
    public java.lang.Integer getAge() {
        return getInt("age");
    }


    /**
     * grade注释
     */
    public void setGrade(java.lang.String grade) {
        set("grade", grade);
    }

    /**
     * grade注释
     */
    public java.lang.String getGrade() {
        return getStr("grade");
    }

}
