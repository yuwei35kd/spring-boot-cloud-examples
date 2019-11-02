package yuwei35kd.springboot2.mybatis.template.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuwei35kd.springboot2.mybatis.template.dao.UserDao;
import yuwei35kd.springboot2.mybatis.template.model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    public int addUser(User user,String baseTable) {
        return userDao.insert(user,baseTable);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public PageInfo<User> findAllUser(int pageNum, int pageSize,String baseTable) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userDao.selectUsers(baseTable);
        PageInfo result = new PageInfo(userDomains);
        return result;
    }
}
