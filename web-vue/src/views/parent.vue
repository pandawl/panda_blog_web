<!--  -->
<template>
  <div>
    i am parent
    <div class="swiper-container">
      <div class="swiper-wrapper">
        <div class="swiper-slide">slider1</div>
        <div class="swiper-slide">slider2</div>
        <div class="swiper-slide">slider3</div>
      </div>
      <div class="swiper-pagination"></div>
    </div>
  </div>
</template>

<script>
import Swiper from 'swiper'
import "swiper/dist/css/swiper.min.css";
import {reqUser} from '../api/index'
export default {
  data() {
    return {};
  },
  components: {},
  mounted(){
    //创建一个swiper实例对象
    new Swiper('.swiper-container',{
      loop: true,//循环
      //分页器
      pagination: {
        el: '.swiper-pagination'
      }
    }),
    reqUser(5)
  }
};
</script>
<style lang='scss' scoped> 
.swiper-container{
  background-color: aqua
}
</style>
