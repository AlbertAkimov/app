requirejs.config({
    baseURI: 'js'
})

require(['views/main', 'util/resourcesProxy'],function (main, resourcesProxy) {
    webix.ready(function () {
        webix.ui({
            container: "main",
            id: 'root',
            rows: [main]
        });
    })
})
