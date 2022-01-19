<template>
  <div class="box">
    <form @submit.prevent="submitForm">
      <label for="userid">아이디</label>
      <input type="text" id="userid" v-model="userid">
      <input type="submit" value="전송">
    </form>
    <p>{{logMessage}}</p>
  </div>
  <!-- <BoardComponent /> -->
</template>

<script>
// import BoardComponent from './components/BoardComponent.vue'
import {registerUser} from './services/UserSignService.js'

export default {
  name: 'App',
  data() {
    return {
      userid: '',
      logMessage: ''
    }
  },
  components: {
    //BoardComponent
  },
  methods: {
    async submitForm() {
      // API 요청시 전달할 userData 객체
      const userData = {
        userid: this.userid,
      };
      const { data } = await registerUser(userData);
      
      this.logMessage = `${data.username} 님이 가입되었습니다.`;
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
  margin-top: 60px;
}
.box {
  width: 500px;
  height: 500px;
}
</style>
