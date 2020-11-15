requirejs.config({
    baseURI: 'js'
})

define(['buttons/buttonProduct', 'tables/productEditTable'], function (buttonProduct, productEditTable) {
    return {
        id: 'test_1',
        width: "auto",
        height: "auto",

        cols: [{
        rows: [buttonProduct, {
            type: "line",
            //height: 1000,

            width: "auto",
            height: "auto",

            id: 'products',
            view: "treetable",
            columns: [
                {
                    id: "id",
                    header: "id",
                    css: {"text-align": "canter"},
                    width: 250,
                    template: "#id#"
                },

                {
                    id: "parentId",
                    header: "Родитель",
                    css: {"text-align": "canter"},
                    width: 250,
                    template: "#parentId#"
                },

                {
                    id: "name", header: "Наименование", width: 250,
                    template: "{common.treetable()} #name#"
                    //editor: 'text'
                },

                {
                    id: "typeProduct",
                    header: "Тип",
                    css: {"text-align": "canter"},
                    width: 250,
                    template: "#typeProduct#"
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

                    let selectedItem = $$("products").getItem(id.row);

                    if (selectedItem.name === "Новый элемент") {

                        $$("product_edit_form").setValues(
                            {
                                id: selectedItem.id,
                                isGroup: selectedItem.open,
                                isNew: selectedItem.isNew,
                                name: selectedItem.name,
                                parentId: selectedItem.parentId,
                                typeProduct: selectedItem.typeProduct
                            }
                        )
                        $$("prices").clearAll();
                    } else {

                        $$("product_edit_form").load({
                            $proxy: true,
                            load: function (view, params) {
                                webix.ajax().get("/products/" + id.row).then(function (value) {

                                    let result = value.json();
                                    let prices = result.prices;

                                    $$("product_edit_form").setValues(
                                        {
                                            id: result.id,
                                            isGroup: result.group,
                                            isNew: '0',
                                            name: result.name,
                                            parentId: result.parentId,
                                            typeProduct: result.typeProduct
                                        }
                                    )

                                    $$("prices").clearAll();

                                    for (let i = 0; i < prices.length; i++) {

                                        $$("prices").add(
                                            {
                                                id: prices[i].typePrice.id,
                                                name: prices[i].typePrice.name,
                                                price: prices[i].price.toString()
                                            }
                                        )
                                    }

                                })
                            }
                        });
                    }
                }
            }
        }], }, productEditTable] // колонки
    }
})
