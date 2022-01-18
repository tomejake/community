<template>
<div class="container"></div>
<h1 class="text-center">Board List</h1>
<table>
    <thead>
    <th>#</th>
    <th>서비스 분류</th>
    <th>제목</th>
    <th>작성 날짜</th>
    </thead>
    <tbody>
        <tr v-for="item in board" :key="item.idx">
        <td>{{item.idx}}</td>
        <td>{{item.boardType}}</td>
        <td>{{item.title}}</td>
        <td>{{item.createDate}}</td>
        </tr>
    </tbody>
</table>

</template>

<script>
import BoardService from '../services/BoardService.js'

export default {
    name: 'BoardComponent',
    data(){
        return {
            board : []
        }
    },
    methods: {
        getBoard(){
        BoardService.getBoard().then((response) => {
                this.board = response.data.content;
            });
        }
    },
    created() {
        this.getBoard();
    }
}
</script>