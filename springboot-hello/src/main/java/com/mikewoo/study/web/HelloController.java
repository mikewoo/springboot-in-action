package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 Ieda Springboot 热部署
 1. 添加依赖和热部署插件
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-devtools</artifactId>
         <optional>true</optional>
     </dependency>
     <build>
         <plugins>
             <plugin>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-maven-plugin</artifactId>
                 <configuration>
                    <fork>true</fork>//该配置必须
                 </configuration>
             </plugin>
         </plugins>
     </build>
 2. 开启idea自动make功能
     （1） CTRL + SHIFT + A --> 查找make project automatically --> 选中
     （2） CTRL + SHIFT + A --> 查找Registry --> 找到并勾选compiler.automake.allow.when.app.running
 3. Chrome禁用缓存
     打开Chrome， 按F12（或Ctrl+Shift+J或Ctrl+Shift+I）， 选择NetWork --> Disable Cache(while DevTools is open)
 4. 重启IDEA
 至此，在idea中就可以愉快的修改代码了，修改后可以及时看到效果，无须手动重启和清除浏览器缓存。
 *
 * HelloController
 *
 * @auther Phantom Gui
 * @date 2018/6/8 14:48
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello springboot";
    }

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return "hello, " + name;
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") String id) {
        User user = new User(id, "Phantom", 28);
        return user;
    }


}
