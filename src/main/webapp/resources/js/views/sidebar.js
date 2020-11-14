requirejs.config({
    baseURI: 'js'
})
const menu_data = [
    {
        id: "references_book", icon: "fas fa-bars", value: "Справочники", data: [
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

        view: "sidebar",
        //multipleOpen: true,
        data: menu_data,

        on: {
            onAfterSelect: function (id) {
                webix.message("Selected: " + this.getItem(id).value)
            }
        }
    }
})