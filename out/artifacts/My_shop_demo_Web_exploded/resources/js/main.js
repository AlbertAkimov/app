requirejs.config({
    baseURI: 'js'
})

require([
    'views/products',
    'util/resourcesProxy',
    'buttons/buttonProduct',
    'tables/productEditTable',
    'views/sidebar'],function (
        products,
        resourcesProxy,
        buttonProduct,
        productEditTable,
        sidebar) {
    webix.ready(function () {
        webix.ui({
            container: "main",
            id: 'root',
            width: "auto",
            height: "auto",
            rows: [//buttonProduct,
                {
                    cols: [sidebar,
                        //products,
                        //productEditTable
                    ]
                }],
        });
    })
})
