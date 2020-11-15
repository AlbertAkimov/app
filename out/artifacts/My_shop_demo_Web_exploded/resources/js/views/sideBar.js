requirejs.config({
    baseURI: 'js'
})
const menu_data = [
    {
        id: "references_book", icon: "fas fa-bars", value: "Справочники", data: [
            {id: "products", value: "Номенклатура"},
            {id: "prices", value: "Цены"}
        ]
    },
    {
        id: "layouts", icon: "fas fa-bars", value: "Документы", data: [
            {id: "ref3", value: "test_3"},
            {id: "ref4", value: "test_4"}
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
                routie(this.getItem(id).id);
            }
        }
    }
})