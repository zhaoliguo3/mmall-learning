package com.mmall.common;

/**常量类
 * @author Donqiuxote
 * @data 2018/3/28 13:10
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    //通过内部接口类把常量进行分组  类似枚举
    public interface Role{
        int ROLE_CUSTOMER = 0;
        int ROLE_ADMIN = 1;
    }
}
