package com.panda.common.util;

import org.springframework.util.StringUtils;

/**
 * 后台返回前台信息枚举类
 */
public enum ResultMessage {
    OPT_SUCCESS("操作成功"), //增删改查等操作成功
    OPT_FAILURE("操作失败"), //增删改查等操作失败
    PROGRAM_EXCEPTION("程序异常，请联系管理员"),//程序有异常抛出
    PARAM_ERORR("输入信息有误"),//参数校验失败 后面跟具体原因如（,A参数长度过长）
    UNIQUE("校验通过"),//唯一性检查通过
    NOT_UNIQUE("数据重复");//唯一性检查不通过

    private String msg;

    public String getMsg() {
        return msg;
    }

    public String getMsg(String extendMsg) {
        if(!StringUtils.isEmpty(extendMsg)){
            return msg + "," +extendMsg;
        }

        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultMessage(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args){
        System.out.println(ResultMessage.PROGRAM_EXCEPTION.getMsg("aaa"));
        System.out.println(ResultMessage.PROGRAM_EXCEPTION.getMsg());
    }
}
