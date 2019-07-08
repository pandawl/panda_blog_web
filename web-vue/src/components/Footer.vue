<template>
  <footer>
    <div class="line">
      <span></span>
      <div class="author"></div>
    </div>
    <div class="box">
      <div class="wxbox">
        <ul>
          <li>
            <img src="../../static/images/wx.jpg" />
            <span>微信公众号</span>
          </li>
          <li>
            <img src="../../static/images/wll.jpg" />
            <span>我的微信</span>
          </li>
        </ul>
      </div>
      <div class="endnav">
        <p>
          <b>站点声明：</b>
        </p>
        <p>1、本站个人博客模板，均为本人设计，个人可以使用，但是未经许可不得用于任何商业目的。</p>
        <p>
          2、所有文章未经授权禁止转载、摘编、复制或建立镜像，如有违反，追究法律责任。举报邮箱：
          <a
            href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=LRocHRUcGBwfG21cXANOQkA"
            target="_blank"
          >710815126@qq.com</a>
        </p>
        <p>
          Copyright ©
          <a href="http://www.wangleihh.cn" target="_blank">www.wangleihh.cn"</a> All Rights Reserved. 备案号：
          <a href="http://www.miitbeian.gov.cn/" target="_blank">京ICP备19027302号</a>
        </p>
        <div class="info">
           <p>
               青葱岁月 我装饰过谁的梦 流年往事 谁又影响了我的整个生命  
           </p>
        </div>
      </div>
    </div>
    <a href="#">
      <div class="top"></div>
    </a>
  </footer>
</template>

<script>
export default {
  name: "Footer"
};
</script>
 
<style scoped>
.line {
  width: 10em;
  float: left;
  position: relative;
  height: 14em;
  margin: 0 auto;
}
.line span {
  position: absolute;
  left: 5em;
  margin: -30px 0 1.5em;
  display: block;
  width: 0.5em;
  height: 6.25em;
  border-right: 0.125em solid #fff;
}
.author{
       position: absolute;
    top: 1em;
    left: 2em;
    margin: 0 0 1.5em;
}
.author:hover {
  -webkit-transform: rotateZ(360deg);
  -moz-transform: rotateZ(360deg);
  -o-transform: rotateZ(360deg);
  -ms-transform: rotateZ(360deg);
  transform: rotateZ(360deg);
}
.author{
    width: 6.875em;
    height: 6.875em;
    margin: 0 auto;
    background: no-repeat url(../../static/images/111.jpg) left top;
    -webkit-background-size: 6.875em 6.875em;
    -moz-background-size: 6.875em 6.875em;
    background-size: 6.875em 6.875em;
    border-radius: 3.4375em;
    -webkit-transition: -webkit-transform 2s ease-out;
    -moz-transition: -moz-transform 2s ease-out;
    -o-transition: -o-transform 2s ease-out;
    -ms-transition: -ms-transform 2s ease-out;
    transition: transform 2s ease-out;
}
.info{
       font-family: "covered_by_your_graceregular";
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    font-size: 200%;
    line-height: 1.3em;
    margin: 0 auto;
    color: #fff;
}
</style>