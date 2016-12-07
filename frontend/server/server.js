var express = require("express");
var path = require("path");
var webpack = require("webpack");
var webpackDevMiddleware = require("webpack-dev-middleware");
var webpackHotMiddleware = require("webpack-hot-middleware");
var config = require("../webpack.config.js");
var app = express();
var compiler = webpack(config);
var port = 8000;
app.use(webpackDevMiddleware(compiler, {noInfo: true, publicPath: config.output.publicPath}));
app.use(webpackHotMiddleware(compiler));
app.use(express.static("./dist"));
app.use("/", function (req, res) {
    res.sendFile(path.resolve("client/index.html"));
});
app.use("/button", function(req, res) {
    res.sendFile(path.resolve("components/button/index.html"));
}); 
app.listen(port, function(error) {
  if (error) throw error;
  console.log("Express server listening on port", port);
});