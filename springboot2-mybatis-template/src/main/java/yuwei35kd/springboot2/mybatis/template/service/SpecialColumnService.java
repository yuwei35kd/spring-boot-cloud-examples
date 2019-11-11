package yuwei35kd.springboot2.mybatis.template.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import yuwei35kd.springboot2.mybatis.template.dao.SpecialColumnDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SpecialColumnService {
    @Resource
    private SpecialColumnDao specialColumnDao;
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> list() {
        //return specialColumnDao.list();
        return jdbcTemplate.queryForList("select `a`,`b`,`c.d`from special");
    }
}
