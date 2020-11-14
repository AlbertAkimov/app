requirejs.config({
    baseURI: 'js'
})

require([
    'views/products',
    'util/resourcesProxy',
    'buttons/buttonProduct',
    'tables/productEditTable',
    'views/sidebar',
    'views/toolbar'],function (
        products,
        resourcesProxy,
        buttonProduct,
        productEditTable,
        sidebar,
        toolbar) {
    webix.ready(function () {
        webix.ui({
            container: "main",
            id: 'root',
            width: "auto",
            height: "auto",
            rows: [toolbar,
                {cols: [sidebar
                        ,
                        {rows: [buttonProduct,products]},
                        productEditTable
                    ]
                }],
        });
    })
})
