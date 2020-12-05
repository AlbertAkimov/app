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
                            $$('units').add({
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
                            $$('units').remove($$('units').getSelectedId().id);
                        }
                    }
                ]
            },

            {
                id: 'units',
                view: 'datatable',
                url: 'resource->/units',
                save: 'resource->/units',
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
                        id: "unitName",
                        header: "Наименование",
                        width: 250,
                        editor:"text"
                    }
                ]
            }
        ]

    }
})