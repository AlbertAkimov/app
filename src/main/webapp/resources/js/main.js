requirejs.config({
    baseURI: 'js'
})

require([
    'views/products',
    'util/resourcesProxy',
    'buttons/buttonProduct',
    'tables/productEditTable'],function (products, resourcesProxy, buttonProduct, productEditTable) {
    webix.ready(function () {
        webix.ui({
            container: "main",
            id: 'root',
            rows: [buttonProduct,
                {
                    cols: [
                        products,
                        productEditTable
                    ]
                }],
        });
    })
})
