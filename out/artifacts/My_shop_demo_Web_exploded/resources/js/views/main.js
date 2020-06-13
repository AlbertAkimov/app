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
            {   id: "isGroup",
                header: "Это группа",
                css: {"text-align": "canter"},
                width: 250,
                template: "#group#"
            },

            {   id: "productCategory",
                header: "Категория",
                css: {"text-align": "canter"},
                width: 250,
                template: "#productCategory.name#"
            },

            {   id: "parentId",
                header: "Категория",
                css: {"text-align": "canter"},
                width: 250,
                template: "#parentId#"
            },
        ],
        autoheight:true,
        autowidth:true,

        url: 'resource->/products',

        scheme:{
            $group:{
                by:"parentId"
            }
        }
    }
})