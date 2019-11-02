package yuwei35kd.springboot2.mybatis.template.dao;

import org.apache.ibatis.annotations.Param;
import yuwei35kd.springboot2.mybatis.template.model.User;

import java.util.List;

public interface UserDao {
    int insert(@Param("user") User user, @Param("baseTable") String baseTable);

    List<User> selectUsers(@Param("baseTable") String baseTable);
}
