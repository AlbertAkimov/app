
requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        type: "line",
        height: 1000,
        rows: [
            {
                view: "toolbar", elements: [
                    {
                        view: "button",
                        value: "Добавить",
                        width: 100,
                        click: function () {
                            var tree = $$("products");
                            var parent = tree.getSelectedId() || 0;
                            tree.add({name: ""}, 0, parent);
                            tree.open(parent);
                        }
                    },
                    {
                        view: "button",
                        value: "Удалить",
                        width: 100,
                        click: function () {
                            var tree = $$("products");
                            var id = tree.getSelectedId();
                            if (id)
                                tree.remove(id);
                        }
                    },
                    {
                        view: "button",
                        value: "Обновить",
                        width: 100,
                        click: function () {

                        }
                    },
                ]
            },
            {
                cols: [
                    {
                        id: 'products',
                        view: "treetable",
                        columns: [
                            {
                                id: "id",
                                header: "id",
                                css: {"text-align": "canter"},
                                width: 100,
                                template: "#id#"
                            },
                            {
                                id: "name", header: "Наименование", width: 250,
                                template: "{common.treetable()} #name#"
                                //editor: 'text'
                            },

                            {
                                id: "category",
                                header: "Категория",
                                css: {"text-align": "canter"},
                                width: 250,
                                template: "#productCategory.name#"
                            }
                        ],

                        //editable: true,
                        autoheight: true,
                        autowidth: true,
                        select: "multiselect",
                        url: 'resource->/products',
                        save: 'resource->/products',

                        on: {
                            onItemClick: function (id) {
                                var params =  {id: id.row};
                                var varView = $$('products');
                                var result = webix.proxy.resource.load(varView, params);
                                console.log(result);
                            }
                        }
                    },
                    {
                        id: 'editProducts',
                        view: 'form',
                        autoheight: true,
                        autowidth: true,
                        width: 500,
                        elements: [

                            {id: 'name', view: "text", label: 'Наименование'},
                            {id: 'category',view: "text", label: 'Категория', template: "#productCategory.name#"},
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
                ]
            }

        ]
    }
})