define(function () {
    return {
        view:"treetable",
        columns:[
            {   id: "id",
                header: "id",
                css: {"text-align": "canter"},
                width: 100,
                template: "#id#"
            },
            {
                id: "name", header: "Наименование", width: 250,
                template: "{common.treetable()} #name#",
                open: true
            },

            {   id: "category",
                header: "Категория",
                css: {"text-align": "canter"},
                width: 250,
                template: "#category#"
            }
        ],

        autoheight:true,
        autowidth:true,

        url: 'resource->/products/tree'
    }
})