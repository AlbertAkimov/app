requirejs.config({
    baseURI: 'js'
})

require([
    'views/sideBar'],function (sideBar) {
    webix.ready(function () {
        webix.ui({
            container: "main",
            id: 'root',
            rows: [sideBar]
        });
    })
})
