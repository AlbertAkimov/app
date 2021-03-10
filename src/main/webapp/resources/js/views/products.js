requirejs.config({
    baseURI: 'js'
})

define(['buttons/buttonProduct', 'tables/productEditTable'], function (buttonProduct, productEditTable) {
    return {

        type: 'wide',

        cols: [{
        rows: [buttonProduct, {
            type: "line",
            id: 'products',
            view: "treetable",
            columns: [
                {
                    id: "id",
                    header: "id",
                    css: {"text-align": "canter"},
                    //width: 150,
                    template: "#id#",
                    hidden: true
                },

                {
                    id: "parentId",
                    header: "Родитель",
                    css: {"text-align": "canter"},
                    //width: 150,
                    template: "#parentId#",
                    hidden: true
                },

                {
                    id: "name", header: "Наименование",
                    //width: 250,
                    template: "{common.treetable()} #name#",
                    fillspace: true
                    //editor: 'text'
                },

                {
                    id: "typeProduct",
                    header: "Тип",
                    css: {"text-align": "canter"},
                    //width: 250,
                    template: "#typeProduct#"
                },

                {
                    id: "idUnit",
                    header: "id unit",
                    css: {"text-align": "canter"},
                    //width: 250,
                    template: "#unit.id#",
                    hidden: true
                },

                {
                    id: "nameUnit",
                    header: "Ед.Из",
                    css: {"text-align": "canter"},
                    //width: 250,
                    template: "#unit.unitName#",
                    hidden: true
                }
            ],

            url: 'resource->/products',
            //save: 'resource->/products',
            select: 'multiselect',

            on: {
                onItemClick: function (id) {

                    let selectedItem = $$("products").getItem(id.row);

                    if (selectedItem.name === "Новый элемент") { //todo убрать словие сделать поле isNew в таблице Products

                        $$("product_edit_form").setValues(
                            {
                                id:             selectedItem.id,
                                isGroup:        selectedItem.open,
                                isNew:          selectedItem.isNew,
                                name:           selectedItem.name,
                                parentId:       selectedItem.parentId,
                                typeProduct:    selectedItem.typeProduct,
                                status:         'ACTIVE'

                            }
                        )
                        $$("prices").clearAll();
                    } else {
                        $$("product_edit_form").refresh();

                        $$("product_edit_form").load({
                            $proxy: true,
                            load: function (view, params) {
                                webix.ajax().get("/products/" + id.row).then(function (value) {

                                    let result = value.json();
                                    let prices = result.prices;
                                    let barcode = result.barcode;

                                    if(barcode === null) {
                                        barcode = {
                                            id: "",
                                            code: "",
                                            imageBarcode: ""
                                        }
                                    }

                                    $$("product_edit_form").setValues(
                                        {
                                            id:             result.id,
                                            isGroup:        String(result.isGroup),
                                            isNew:          String(false),
                                            name:           result.name,
                                            parentId:       result.parentId,
                                            typeProduct:    result.typeProduct,
                                            idUnit:         result.unit.id,
                                            unitName:       result.unit.unitName,
                                            unitStatus:     result.unit.status,
                                            status:         result.status,
                                            levelGroup:     result.levelGroup,

                                            id_barcode:     barcode.id,
                                            code:           barcode.code
                                        }
                                    )

                                    // set barcode if there is

                                        $$("image_barcode").config.height = 30;
                                        $$("image_barcode").config.width = 50;
                                        $$("image_barcode").setValues(
                                            {
                                                path: "data:image/png;base64," + barcode.imageBarcode
                                            }
                                        )

                                    $$("prices").clearAll();

                                    for (let i = 0; i < prices.length; i++) {

                                        $$("prices").add(
                                            {
                                                id: prices[i].typePrice.id,
                                                id_price: prices[i].id,
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
