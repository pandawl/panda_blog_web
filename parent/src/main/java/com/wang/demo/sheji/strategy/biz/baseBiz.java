package com.wang.demo.sheji.strategy.biz;

import com.wang.demo.sheji.strategy.check.FileCheck;
import com.wang.demo.sheji.strategy.parse.FileParse;

/**
 * @Auther: wl
 * @Date: 2019/6/19 11:12
 * @Description:
 */
public class baseBiz {
   //解析
    FileParse fileParse;
   //对账
    FileCheck fileCheck;

   public void parse(){
       fileParse.parse();
   }

   public void check(){
       fileCheck.fileCheck();
   }

    public FileParse getFileParse() {
        return fileParse;
    }

    public void setFileParse(FileParse fileParse) {
        this.fileParse = fileParse;
    }

    public FileCheck getFileCheck() {
        return fileCheck;
    }

    public void setFileCheck(FileCheck fileCheck) {
        this.fileCheck = fileCheck;
    }
}
