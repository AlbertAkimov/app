requirejs.config({
    baseURI: 'js'
})

function buildRoute(view) {
    return function() {
        webix.ui({
            id: 'root',
            rows: [
                view
            ]
        }, $$('root'))
    }
}

require([
    'views/products',
    'util/resourcesProxy',
    'views/sidebar',
    'views/toolbar',
    'views/typePrice',
    'views/units'],function (
        products,
        resourcesProxy,
        sidebar,
        toolbar,
        typePrice,
        units) {
    webix.ready(function() {
        webix.ui({
            container: 'main',
            width: 'auto',
            height: 'auto',
            rows: [
                toolbar,
                {
                    cols: [sidebar, {rows: [{id: 'root'}]}]
                }
            ]
        })
    })
    routie({
        'products': buildRoute(products),
        'typePrice' : buildRoute(typePrice),
        'units' : buildRoute(units)
    })
})
