package yuwei35kd.springboot2.mybatis.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yuwei35kd.springboot2.mybatis.template.service.SpecialColumnService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class SpecialColumnController {

    @Resource
    private SpecialColumnService specialColumnService;

    @GetMapping("/special/list")
    public List<Map<String,Object>> list(){
        return specialColumnService.list();
    }
}
