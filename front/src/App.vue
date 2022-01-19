<template>
  <div class="box">
    <form @submit.prevent="submitForm">
      <label for="name">이름</label>
      <input type="text" id="name" v-model="name">
      <input type="submit" value="전송">
    </form>
    <p>{{logMessage}}</p>
  </div>
  <BoardComponent />
</template>

<script>
import BoardComponent from './components/BoardComponent.vue'
import {registUser} from './services/UserSignService.js'

export default {
  name: 'App',
  data() {
    return {
      name: '',
      logMessage: ''
    }
  },
  components: {
    BoardComponent
  },
  methods: {
    async submitForm() {
      // API 요청시 전달할 userData 객체
      const userData = {
        name: this.name,
      };
      await registUser(userData);
      this.logMessage = userData.name;
    },
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
