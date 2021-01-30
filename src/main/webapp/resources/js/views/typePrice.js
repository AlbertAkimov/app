requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        rows:[
            {
                view: "toolbar",
                elements: [
                    {
                        view: "button",
                        value: "Добавить",
                        width: 100,
                        click: function () {
                           $$('typePrice').add({
                               id: '',
                               name: 'Введите наименоавние'
                           })
                        }
                    },
                    {
                        view: "button",
                        value: "Удалить",
                        width: 100,
                        click: function () {
                            $$('typePrice').remove($$('typePrice').getSelectedId().id);
                        }
                    }
                ]
            },

            {
                id: 'typePrice',
                view: 'datatable',
                url: 'resource->/typePrice',
                save: 'resource->/typePrice',
                editable:true,
                editaction: "custom",
                select: 'multiselect',

                on: {
                    onItemClick: function(id){
                        this.editColumn(id);
                    }
                },

                columns: [
                    {
                        id: "id",
                        header: "id",
                        css: {"text-align": "canter"},
                        width: 150,
                        template: "#id#"

                    },

                    {
                        id: "name",
                        header: "Наименование",
                        width: 250,
                        editor:"text"
                    },
                    {view: 'combo', label: 'Статус', name: 'status', value: 'Товар', options:['ACTIVE', 'NOT_ACTIVE', 'DELETED']},
                ]
            }
        ]

    }
})