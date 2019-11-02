package yuwei35kd.springboot2.mybatis.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuwei35kd.springboot2.mybatis.template.model.User;
import yuwei35kd.springboot2.mybatis.template.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/add/{baseTable}")
    public int addUser(User user, @PathVariable String baseTable) {
        return userService.addUser(user, baseTable);
    }

    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            String baseTable) {
        return userService.findAllUser(pageNum, pageSize, baseTable);
    }
}
