package com.panda.common;

/**
 * 公共相关常量
 *
 * @author: shq
 */
public final class CommonConstant {

    private CommonConstant() {

    }

    /**
     * 通用成功码
     */
    public static final int SUCCESS = 1;

    /**
     * 通用失败码
     */
    public static final int FAILURE = 2;

    /**
     * 提示信息：缺少必要参数或参数错误
     */
    public static final String MSG_ERROR_UNKNOWN = "系统未知错误";

    /**
     * 提示信息：缺少必要参数或参数错误
     */
    public static final String MSG_ERROR_PARAM = "缺少必要参数或参数错误";

    /**
     * 提示信息：参数范围错误
     */
    public static final String PARAM_RANGE_ERROR = "参数范围错误";

    /**
     * 提示信息：操作失败
     */
    public static final String MSG_ERROR_OPERATE = "操作失败";

    /**
     * 提示信息：非法访问
     */
    public static final String MSG_ERROR_ILLEGAL = "非法访问";


    /**
     * 提示信息：获取信息失败
     */
    public static final String MSG_ERROR_GET = "获取信息失败";

    /**
     * 提示信息：操作成功
     */
    public static final String MSG_SUCCSS_OPERATE = "操作成功";

    /**
     * 重新登录
     */
    public static final String MSG_UNKNOWN_USER = "请重新登录";

    /**
     * 提示信息：返回消息key
     */
    public static final String MSG_RETURN_KEY = "message";

    /**
     * 提示信息：返回消息code
     */
    public static final String MSG_RETURN_CODE = "code";
    /**
     * 提示信息：返回消息state
     */
    public static final String MSG_RETURN_STATE = "state";

    /**
     * 提示信息：返回数据data,key
     */
    public static final String RETURN_DATA_KEY = "data";
    /**
     * 服务端返回通用成功码
     */
    public static final int HTTP_SUCCESS = 200;
    /**
     * 接口服务版本
     */
    public static final String VERSION = "1.0.0";

    /**
     * MD5加密键组合
     */
    public static final String MD5_KEY = "ANT_CHINA";
    // 四元组统计常量

    public static final String CA_S = "_channel";

    public static final String CA_N = "_caname";

    public static final String CA_I = "_caid";

    public static final String CA_KW = "_keyword";

}