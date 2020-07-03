requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        type: "line",
        height: 1000,

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
            },
        ],

        //editable: true,
        autoheight: true,
        autowidth: true,
        select: "multiselect",
        url: 'resource->/products',
        save: 'resource->/products',

        on: {
            onItemClick: function (id) {
                const params = {id: id.row, operation: 'details'};
                webix.proxy.resource.load($$('productEdit'), params);
            }
        }

    }
})