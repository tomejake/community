<template>
  <div class="box">
    <input type="text"><br>
    <input type="submit" value="전송">
  </div>
  <!-- <BoardComponent /> -->
</template>

<script>
// import BoardComponent from './components/BoardComponent.vue'
import axios from 'axios'

export default {
  name: 'App',
  data() {
    return {
      
    }
  },
  components: {
    //BoardComponent
  },
  methods: {
    sunbmitForm(){
      axios.post()
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.box {
  width: 500px;
  height: 500px;
  background: black;
  color: white;
}
</style>
