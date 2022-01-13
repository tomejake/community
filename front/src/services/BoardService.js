import axios from 'axios';

const BOARD_API_BASE_URL = 'http://localhost:7070/board/list';

class BoardService{
    getBoard(){
        return axios.get(BOARD_API_BASE_URL);
    }
}

export default new BoardService();