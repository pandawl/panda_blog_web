<template>
 <aside class="left-menus-panda">

    <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
          <el-button slot="append" icon="el-icon-search" class="index-select-button-panda"></el-button>
        </el-input>
    <div class="widget widget_text" style="height: 115px;margin-bottom: 0px">
        <iframe src="http://www.seniverse.com/weather/weather.aspx?uid=U35799536E&cid=CHBJ000000&l=&p=SMART&a=1&u=C&s=13&m=
        0&x=1&d=0&fc=&bgc=2E93D9&bc=&ti=0&in=1&li=" frameborder="0" scrolling="no" width="349" height="115"
                allowTransparency="true"></iframe>
    </div>

    <div class="widget d_tag">
        <div class="title"><h2>分类</h2></div>
        <div class="d_tags" id="fenlei" style="height: auto">
            <a href="${pageContext.request.contextPath}/life.html">生活笔记</a>
        </div>
    </div>


    <div class="widget d_postlist">
        <div class="title"><h2>猜你喜欢</h2></div>
        <ul class="guessyourlike">
        </ul>
    </div>


    <div class="widget widget_text">
        <div class="title"><h2>新浪微博</h2></div>
        <div class="textwidget">
            <iframe width="100%" height="550" class="share_self" frameborder="0" scrolling="no"
                    src="http://widget.weibo.com/weiboshow/index.php?language=&width=0&height=550&fansRow=2&ptype=1&speed=0&skin=1&isTitle=0&noborder=0&isWeibo=1&isFans=1&uid=1925306000&verifier=5d4515d6&dpc=1"></iframe>
        </div>
    </div>
    <div class="widget widget_links">
        <div class="title"><h2>友情链接</h2></div>
        <ul class="xoxo blogroll" style="width: 332px;">
            <li><a href="http://www.99banzou.com" target="_blank">99伴奏网</a></li>
            <li><a href="http://www.anotherhome.net" target="_blank">Anotherhome</a></li>
            <li><a href="http://zhouchenwen.com" rel="acquaintance" target="_blank">ColdCoder</a></li>
            <li><a href="http://www.spotty.com.cn/" target="_blank">DevNews</a></li>
            <li><a href="http://www.findspace.name" target="_blank">Findspace</a></li>
            <li><a href="http://blog.hickwu.com/" target="_blank">Hick</a></li>
        </ul>
    </div>


    <div class="widgetRoller">
        <div class="widget widget_divTags" id="divTags">
            <div class="title"><h2>标签云</h2></div>
            <ul class="widget_divTags_inner">
                <div class="tags-box">
                </div>
            </ul>
        </div>
    </div>
</aside>
</template>
<script>
import '../assets/css/jingmi.css'
import axios from 'Axios'
export default {
  name: 'LeftSide',
  props: {

  },
  data () {
    return {
    }
  },
  methods: {

  }
}
</script>

<style scoped>

</style>
