const { createProxyMiddleware } = require('http-proxy-middleware')

module.exports = function (app) {
  app.use(createProxyMiddleware('/api', {
    target: 'http://localhost:8080/o/liferay-headless-dem/v1.0',
    secure: false,
    changeOrigin: true,
    pathRewrite: {
      "^/api": "/"
    }
  }))
  app.listen(3000)
}
