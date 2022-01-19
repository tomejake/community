module.exports = {
devServer: {
        overlay: false,
        proxy: { // 이부분 추가
            '/board/*': {
                target: 'http://localhost:7070', // 요청할 서버 주소
                changeOrigin: true,
                pathRewrite: {'^/board':''},
                logLevel: 'debug', // 터미널에 proxy 로그가 찍힌다. 
                secure: false
            }
        }
    }
}