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
                id: "typeProduct",
                header: "Тип",
                css: {"text-align": "canter"},
                width: 250,
                template: "#typeProduct#"
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

                $$("product_edit_form").load({
                    $proxy: true,
                    load: function (view, params) {
                        webix.ajax().get("/products/" + id.row).then(function (value) {

                            let result = value.json();
                            let prices = result.prices;

                            $$("product_edit_form").setValues(
                                {
                                    id: result.id,
                                    name: result.name,
                                    typeProduct: result.typeProduct
                                }
                            )

                            //$$("prices").parse(prices);
                            $$("prices").clearAll();

                            for (let i = 0; i < prices.length; i++) {

                                $$("prices").add(
                                    {
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
})