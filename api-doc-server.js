const express = require('express')
const app = express()

app.use(express.static('src/main/resources/public/api-doc'));

app.listen(9002, function () {
  console.log('API Doc running on 9002 port!')
})
