package com.panda.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 类功能简述：系统内部异常
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/7/26 11:31
 */
@Slf4j
public class PandaException extends CustomException {

    public PandaException(String message) {
        super(message);
    }
}
