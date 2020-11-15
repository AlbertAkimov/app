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
    'views/toolbar'],function (
        products,
        resourcesProxy,
        sidebar,
        toolbar) {
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
    })
})
