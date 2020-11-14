requirejs.config({
    baseURI: 'js'
})
const menu_data = [
    {
        id: "references_book", icon: "", value: "Справочники", data: [
            {id: "ref1", value: "Номенклатура"},
            {id: "ref2", value: "Цены"}
        ]
    },
    {
        id: "layouts", icon: "fas fa-bars", value: "Документы", data: [
            {id: "ref3", value: "Продажа"},
            {id: "ref4", value: "Склад"}
        ]
    }
];

define(function () {
    return {
        rows: [
            { view: "toolbar", padding:3, elements: [
                    { view: "icon", icon: "fas fa-bars", click: function(){
                            $$("$sidebar1").toggle();
                        }
                    },
                    { view: "label", label: "Albert Corporation"},
                    {},
                    { view: "icon", icon: "fas fa-envelope",  badge:4},
                    { view: "icon", icon: "fas fa-bell",  badge:10}
                ]
            },
            { cols:[
                    {
                        view: "sidebar",
                        multipleOpen:true,
                        data: menu_data,

                        on:{
                            onAfterSelect: function(id){
                                //webix.message("Selected: "+this.getItem(id).value)
                                $$('products').show();
                            }
                        }
                    },
                    { template: ""}
                ]}
        ]
    }
})