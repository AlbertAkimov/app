requirejs.config({
    baseURI: 'js'
})

require(['views/main'],function (main) {
    webix.ready(function () {
        webix.ui({
            container: "main",
            id: 'root',
            rows: [main]
        });
    })
})
