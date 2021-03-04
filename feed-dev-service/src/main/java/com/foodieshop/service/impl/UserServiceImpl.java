package com.foodieshop.service.impl;

import com.foodieshop.bo.UserBo;
import com.foodieshop.mapper.UsersMapper;
import com.foodieshop.pojo.Users;
import com.foodieshop.service.UserService;
import com.imooc.enums.Sex;
import com.imooc.exception.UserException;
import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/3 14:32
 * @Modified By：
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String faceUrl = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    /**
     * 校验 用户名是否已经注册
     *
     * @param userName
     * @return
     */
    @Override
    public boolean isRegisteredUser(String userName) {
        Example userExample = new Example(Users.class);
        Example.Criteria userExampleCriteria = userExample.createCriteria();
        //andEqualTo 第一个参数对应的是pojo中的字段的名字
        userExampleCriteria.andEqualTo("username", userName);
        List<Users> users = usersMapper.selectByExample(userExample);
        return users != null && users.size() != 0;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public Users insertUser(UserBo userBo) {
        Users users = new Users();
        users.setUsername(userBo.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(userBo.getPassword()));
        } catch (Exception e) {
            throw new UserException("用户密码加密异常", e);
        }
        users.setBirthday(DateUtil.stringToDate("2020-10-12"));
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        users.setEmail("zzl@13.com");
        users.setSex(Sex.secret.type);
        users.setId(sid.nextShort());
        users.setFace(faceUrl);
        usersMapper.insert(users);

        return users;
    }

    /**
     * 登陆接口
     *
     * @param userBo
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users loginUser(UserBo userBo) {
        Users users = new Users();
        String userName = userBo.getUsername();
        String password;
        try {
            password = MD5Utils.getMD5Str(userBo.getPassword());
        } catch (Exception e) {
            throw new UserException("用户密码加密异常", e);
        }
        Example userExample = new Example(Users.class);
        Example.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andEqualTo("username", userName)
                .andEqualTo("password", password);
        return usersMapper.selectOneByExample(userExample);
    }
}
