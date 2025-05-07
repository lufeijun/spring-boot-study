package lufeijun.springboot.study.controller;


import com.lufeijun.App;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public String home() {
        return "hello world";
    }


    //
    @GetMapping("/local")
    public String local() {
        App app = new App();

        app.say();

        return "local";
    }

}
