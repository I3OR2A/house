package com.mooc.house.biz.service;

import java.util.List;

import com.google.common.collect.Lists;
import com.mooc.house.biz.mapper.UserMapper;
import com.mooc.house.common.utils.BeanHelper;
import com.mooc.house.common.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooc.house.common.model.User;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


  @Autowired
  private FileService fileService;

  @Autowired
  private UserMapper userMapper;

  public List<User> getUsers() {
    return userMapper.selectUsers();
  }

  /**
   * 1.插入数据库，非激活;密码加盐md5;保存头像文件到本地 2.生成key，绑定email 3.发送邮件给用户
   *
   * @param account
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public boolean addAccount(User account) {
    account.setPasswd(HashUtils.encryPassword(account.getPasswd()));
    List<String> imgList = fileService.getImgPaths(Lists.newArrayList(account.getAvatarFile()));
    if (!imgList.isEmpty()) {
      account.setAvatar(imgList.get(0));
    }
    BeanHelper.setDefaultProp(account, User.class);
    BeanHelper.onInsert(account);
    account.setEnable(0);
    userMapper.insert(account);
    registerNotify(account.getEmail());
    return true;
  }

}
