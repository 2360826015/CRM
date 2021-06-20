package com.liuwohe.crm.settings.domain;

public class User {
    /*关于登录
    验证账号和密码
     User user = 执行sql  select * from tbl_user where loginAct=? loginPwd=?
     user对象为null 账号密码错误
     不为空  需要继续验证字段
     从user种获取字段
     expireTime 验证失效时间
     lockState  验证锁定状态
     allowIps   验证允许访问的IP地址
     */
    private String id;          //主键
    private String loginAct;    //登录账号
    private String name;
    private String loginPwd;    //密码
    private String email;
    private String expireTime;  //失效时间 yyyy-MM-dd HH:mm:ss 19位  yyyy-MM-dd 8位
    private String lockState;   //锁定状态0锁定，1启用
    private String deptno;
    private String allowIps;    //允许访问的IP地址
    private String createTime;  //创建时间
    private String createBy;    //创建人
    private String editTime;    //修改时间
    private String editBy;      //修改人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}
