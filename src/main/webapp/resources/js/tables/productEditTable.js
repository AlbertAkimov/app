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

            {name: 'name', view: "text", label: 'Наименование'},
            {name: 'category',view: "text", label: 'Категория'},
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
        ]
    }
})