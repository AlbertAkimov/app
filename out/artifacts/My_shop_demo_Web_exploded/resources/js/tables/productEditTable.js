requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        id: 'productEdit',
        view: 'form',
        autoheight: true,
        autowidth: true,
        width: 500,
        elements: [

            {id: 'id', view: "counter", label: 'id'},
            {id: 'name', view: "text", label: 'Наименование'},
            {margin:5,
                cols: [
                    {
                        view: 'button', value: 'Сохранить', css:"webix_primary", type: 'form'
                    },
                    {
                        view: 'button', value: 'Отмена'
                    },
                ]
            }
        ],

        url: 'resource->/products/products_detail',
        save: 'resource->/products/products_detail',
    }
})