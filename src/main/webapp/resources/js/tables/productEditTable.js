requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
/*        id: 'product_property',
        view: 'property',
        detailsUrl: '/products',
        autoheight: true,
        autowidth: true,
        width: 500,
        countPrice: 0,

        elements: [
            {label: 'Основные реквизиты', type: 'label'},
            {label: 'ID', type: 'text', id: 'id'},
            {label: 'Имя', type: 'text', id: 'name'},
            {label: 'Тип', type: 'text', id: 'typeProduct'},
            {label: 'Цены', type: 'label'}

        ],*/

        view: 'form',
        id: 'product_edit_form',
        width: 600,
        elements:
            [
                {view: 'text', label: 'ID', name: 'id'},
                {view: 'text', label: 'Наименование', name: 'name'},
                {view: 'text', label: 'Тип', name: 'typeProduct'},
                {view: 'datatable', id: 'prices', columns:[
                        {id: "name", header: "Тип цены", width:200},
                        {id: "price", header: "Цена", width:400}
                    ]}
            ]
    }
})