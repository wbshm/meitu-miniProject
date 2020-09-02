package com.meitu.search.constant;

/**
 * @ClassName CommonConstant
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 8:52
 */
public class CommonConstant {
    /**
     * 非法请求参数的提示信息
     */
    public static final String ERR_ILLEGAL_PARAM = "输入的参数有误";

    /**
     * 后台默认的页面大小
     */
    public static final int COMMON_PAGE_SIZE = 20;

    /**
     * 页码最小的值
     */
    public static final int COMMON_PAGE_NUM_MIN = 0;


    /**
     * 服务器成功返回用户请求的数据
     */
    public static final int STATUS_CODE_SUCCESS = 200;
    /**
     * 用户新建或修改数据成功
     */
    public static final int STATUS_CODE_SUCCESS_CREATED = 201;
    /**
     * 用户删除数据成功
     */
    public static final int STATUS_CODE_SUCCESS_NO_CONTENT = 204;
    /**
     * 用户请求的资源被永久删除，且不会再得到的。
     */
    public static final int STATUS_CODE_NOT_FOUND_GONE = 410;
    /**
     * 当创建一个对象时，发生一个验证错误
     */
    public static final int STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY = 422;
    /**
     * 服务器发生错误
     */
    public static final int STATUS_CODE_ERROR = 500;
}
