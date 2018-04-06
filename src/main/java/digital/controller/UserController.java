package digital.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable(value = "id") int id) {
        return "hello" + id;
    }
}
