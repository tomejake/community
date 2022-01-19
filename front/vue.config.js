module.exports = {
devServer: {
        overlay: false,
        port: 4000,
        contentBase: '.',
        proxy: { // 이부분 추가
            '^/board': {
                target: 'localhost:7070', // 요청할 서버 주소
                changeOrigin: true,
                logLevel: 'debug', // 터미널에 proxy 로그가 찍힌다. 
            }
        }
    }
}