requirejs.config({
    baseURI: 'js'
})

define(function () {
    return new webix.DataCollection({url: '/units'})
})