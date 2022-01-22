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
    <tfoot>
        <button></button>
    </tfoot>
</table>
<ul>
    <li>&laquo;</li>
    <li @click="prePage">&lsaquo;</li>
    <li @click="getBoard(i+firstPage)" v-for="i in lastPage" :key="i">
        {{i+firstPage}}
    </li>
    <li @click="nextPage()">&rsaquo;</li>
    <li>&raquo;</li>
</ul>
</template>

<script>
import BoardService from '../services/BoardService.js'

export default {
    name: 'BoardComponent',
    data(){
        return {
            board: [],
            totalPages: 0,
            firstPage: 0,
            lastPage: 10,
            thisPage: 1
        }
    },
    methods: {
        getBoard(i) {
            BoardService.getBoard(i-1).then((response) => {
                this.board = response.data.content;
                this.totalPages = response.data.totalPages;
                this.thisPage = i;
            });
        },
        prePage(){
            if(this.firstPage != 0){
                this.firstPage -= 10;
            }
        },
        nextPage(){
            if(this.totalPages >= this.firstPage+11){
                this.firstPage += 10;
            }
        }
    },
    created() {
        this.getBoard(1);
    }
}
</script>

<style>
td {
    padding: 20px;
}

li {
    list-style-type: none;
    float: left;
    margin-left: 20px;
    cursor: pointer;
}
</style>