<template>
  <div class="head_aricle detail_width">
    <div class="left">
      <div style="font-size:26px;font-famil:隶书;text-align:center;margin:20px">最新版 Spring Boot2 教程合集</div>
      <div id="timeline">
        <article>
          <div class="inner">
            <a target="_blank" href="http://www.javaboy.org/2019/0412/springboot-init.html">
              <span class="date">
                <span class="day">23</span>
                <span class="month">7月</span>
                <span class="year">2019</span>
              </span>

              <h2>创建一个 Spring Boot 项目，你会几种方法？</h2>
              <p class="description">
                现在 Spring Boot 最新稳定版是 2.1.5 ，松哥想针对此写一个系列教程，专门讲 Spring Boot2
                中相关的知识点。这个系列，就从本篇开始吧。
              </p>
            </a>
          </div>
        </article>
        <article>
          <div class="inner">
            <span class="date">
              <span class="day">23</span>
              <span class="month">7月</span>
              <span class="year">2019</span>
            </span>
            <h2>日志</h2>
            <p class="description">使用jmeter对接口进行压力测试</p>
          </div>
        </article>
        <article>
          <div class="inner">
            <span class="date">
              <span class="day">23</span>
              <span class="month">7月</span>
              <span class="year">2019</span>
            </span>
            <h2>日志</h2>
            <p class="description">使用jmeter对接口进行压力测试</p>
          </div>
        </article>
        <article>
          <div class="inner">
            <span class="date">
              <span class="day">23</span>
              <span class="month">7月</span>
              <span class="year">2019</span>
            </span>
            <h2>日志</h2>
            <p class="description">使用jmeter对接口进行压力测试</p>
          </div>
        </article>
        <article>
          <div class="inner">
            <span class="date">
              <span class="day">23</span>
              <span class="month">7月</span>
              <span class="year">2019</span>
            </span>
            <h2>日志</h2>
            <p class="description">使用jmeter对接口进行压力测试</p>
          </div>
        </article>
        <article>
          <div class="inner">
            <span class="date">
              <span class="day">23</span>
              <span class="month">7月</span>
              <span class="year">2019</span>
            </span>
            <h2>日志</h2>
            <p class="description">使用jmeter对接口进行压力测试</p>
          </div>
        </article>
      </div>
    </div>
    <Rbox></Rbox>
  </div>
</template>

<script>
import Rbox from "../../components/rbox/Rbox";
export default {
  name: "",

  components: { Rbox },
  props: {},
  data() {
    return {};
  },
  watch: {},
  computed: {},
  methods: {},
  created() {},
  mounted() {}
};
</script>
 
<style scoped>
.left {
  float: left;
  width: 75%;
  background-color:white;
  border-radius: 3px
}
.head_aricle {
  width: 80%;

  margin: auto;
  margin-top: 10px;
  overflow: hidden;
}
#timeline {
  width: 80%;
  margin: 20px auto;
  position: relative;
}
#timeline:before {
  content: "";
  display: block;
  position: absolute;
  left: 50%;
  top: 0;
  margin: 9px 0 0 -1px;
  width: 2px;
  height: 100%;
  background: rgba(37, 48, 59, 0.7);
}
#timeline article {
  width: 100%;
  margin: 0 0 20px 0;
  position: relative;
 
}
#timeline article:after {
  content: "";
  display: block;
  clear: both;
}
#timeline article div.inner {
  width: 40%;
  float: left;
  margin: 5px 0 0 0;
  border-radius: 6px;
  
  
}
  .inner .description {
            border: 1px solid #dedede;
        }
#timeline article div.inner span.date {
  display: block;
  width: 60px;
  height: 50px;
  padding: 5px 0;
  position: absolute;
  top: 0;
  left: 50%;
  margin: 8px 0 0 -32px;
  border-radius: 100%;
  font-size: 12px;
  font-weight: 900;
  text-transform: uppercase;
  background: #25303b;
  color: rgba(255, 255, 255, 0.5);
  border: 2px solid rgba(255, 255, 255, 0.2);
  box-shadow: 0 0 0 7px #25303b;
}
#timeline article div.inner span.date span {
  display: block;
  text-align: center;
}
#timeline article div.inner span.date span.day {
  font-size: 10px;
}
#timeline article div.inner span.date span.month {
  font-size: 18px;
}
#timeline article div.inner span.date span.year {
  font-size: 10px;
}
#timeline article div.inner h2 {
  padding: 15px;
  margin: 0;
  color: #fff;
  font-size: 20px;
  text-transform: none;
  letter-spacing: -1px;
  border-radius: 6px 6px 0 0;
  position: relative;
}
#timeline article div.inner h2:after {
  content: "";
  position: absolute;
  top: 20px;
  right: -5px;
  width: 10px;
  height: 10px;
  -webkit-transform: rotate(-45deg);
}
#timeline article div.inner p {
  padding: 15px;
  margin: 0;
  font-size: 14px;
  background: #fff;
  color: #656565;
  border-radius: 0 0 6px 6px;
}
#timeline article:nth-child(2n + 2) div.inner {
  float: right;
}
#timeline article:nth-child(2n + 2) div.inner h2:after {
  left: -5px;
}
#timeline article:nth-child(5n + 1) div.inner h2 {
  background: #e74c3c;
}
#timeline article:nth-child(5n + 1) div.inner h2:after {
  background: #e74c3c;
}
#timeline article:nth-child(5n + 2) div.inner h2 {
  background: #2ecc71;
}
#timeline article:nth-child(5n + 2) div.inner h2:after {
  background: #2ecc71;
}
#timeline article:nth-child(5n + 3) div.inner h2 {
  background: #e67e22;
}
#timeline article:nth-child(5n + 3) div.inner h2:after {
  background: #e67e22;
}
#timeline article:nth-child(5n + 4) div.inner h2 {
  background: #1abc9c;
}
#timeline article:nth-child(5n + 4) div.inner h2:after {
  background: #1abc9c;
}
#timeline article:nth-child(5n + 5) div.inner h2 {
  background: #9b59b6;
}
#timeline article:nth-child(5n + 5) div.inner h2:after {
  background: #9b59b6;
}
</style>
