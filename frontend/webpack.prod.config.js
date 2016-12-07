var webpack = require("webpack");
var path = require("path");

var build_dir = path.resolve("../backend/src/main/webapp/static");

module.exports = {
    entry: [
        './client/client.js'
    ],
    output: {
        path: build_dir,
        filename: 'bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['react', 'es2015']
                }
            }
        ]
    }
}