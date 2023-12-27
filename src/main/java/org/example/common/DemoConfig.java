package org.example.common;

import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import org.example.common.model._MappingKit;

public class DemoConfig extends JFinalConfig {

    static Prop p;

    //项目的启动类函数
    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class);
    }

    //寻找配置文件的配置函数方法
    static void loadConfig(){
        if(p==null){
            p= PropKit.useFirstFound("demo-config-pro.txt","demo-config-dev.txt");
        }
    }

    @Override
    public void configConstant(Constants constants) {
        loadConfig();

        constants.setDevMode(p.getBoolean("devMode",false));

        constants.setInjectDependency(true);

        constants.setInjectSuperClass(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.scan("org.example.");
    }

    @Override
    public void configEngine(Engine engine) {
        engine.addSharedFunction("/common/_layout.html");
        engine.addSharedFunction("/common/_paginate.html");
    }

    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin druidPlugin=new DruidPlugin(p.get("jdbcUrl"),p.get("user"),p.get("password"));
        plugins.add(druidPlugin);

        ActiveRecordPlugin activeRecordPlugin=new ActiveRecordPlugin(druidPlugin);
        _MappingKit.mapping(activeRecordPlugin);
        plugins.add(activeRecordPlugin);
    }

    public static DruidPlugin createDruidPlugins(){
        loadConfig();

        return new DruidPlugin(p.get("jdbcUrl"),p.get("user"),p.get("password"));
    }


    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
