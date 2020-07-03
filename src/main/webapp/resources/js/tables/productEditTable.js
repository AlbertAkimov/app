requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        id: 'product_property',
        view: 'property',
        detailsUrl: '/products',
        autoheight: true,
        autowidth: true,
        width: 500,

        elements: [
            {label: 'Основные реквизиты', type: 'label'},
            {label: 'Идентификатор', type: 'text', id: 'id'},
            {label: 'Имя', type: 'text', id: 'name'},
            {label: 'Тип товара', type: 'text', id: 'category'}
        ],
    }
})