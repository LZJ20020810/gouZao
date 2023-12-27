package org.example.common.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

public class _MappingKit {
    public static void mapping(ActiveRecordPlugin activeRecordPlugin){
        activeRecordPlugin.addMapping("jfinalstudent","id", Student.class);
    }
}
