var webpack  = require("webpack");
var path = require("path");

module.exports = {    
    entry: {        
        button: __dirname + '/components/button/test.js'
    },
    output: {
        path: path.resolve('./dist'),
        filename: '[name].bundle.js',
        publicPath: '/'
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
