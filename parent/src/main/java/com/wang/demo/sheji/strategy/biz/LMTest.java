package com.wang.demo.sheji.strategy.biz;

import com.wang.demo.sheji.strategy.check.impl.FileCheckLMImpl;
import com.wang.demo.sheji.strategy.check.impl.FileCheckZYmpl;
import com.wang.demo.sheji.strategy.parse.impl.FileParseLMImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: wl
 * @Date: 2019/6/19 11:19
 * @Description:
 */
@Slf4j
public class LMTest extends baseBiz{

    public LMTest(){
        fileParse = new FileParseLMImpl();
        fileCheck = new FileCheckLMImpl();
    }

    public static void main(String[] args) {
        LMTest test = new LMTest();
        test.check();
        test.setFileCheck(new FileCheckZYmpl());
        test.parse();
        test.check();
    }
}


