requirejs.config({
    baseURI: 'js'
})

define(['tables/typePriceDialog', 'tables/unitDialog'], function (typePriceDialog, unitDialog) {
    return {
        view: 'form',
        id: 'product_edit_form',
        //width: 870,
        //height: 900,
        minWidth: 500,
        url: 'resource->/products',
        save: 'resource->/products',
        elements:
            [
                {
                    rows:[
                        {template: "Карточка товара", type: "section"},
                        {view: 'label', label: 'Идентификатор'},
                        {view: 'text', name: 'id'},
                        {view: 'label', label: 'Идентификатор родителя'},
                        {view: 'text', name: 'parentId'},
                        {view: 'label', label: 'Уровень группировки'},
                        {view: 'text', name: 'levelGroup'},
                        {view: 'label', label: 'Это группа'},
                        {view: 'text', name: 'isGroup'},
                        {view: 'label', label: 'Это новый'},
                        {view: 'text', name: 'isNew'},
                        {view: 'label', label: 'Статус оборота'},
                        {view: 'combo', name: 'status', value: 'Товар', options:['ACTIVE', 'NOT_ACTIVE', 'DELETED']},
                        {view: 'label', label: 'Наименование'},
                        {view: 'text', name: 'name'},
                        {view: 'label', label: 'Тип номенклатуры'},
                        {view: 'combo', name: 'typeProduct', value: 'Товар', options:['ТОВАР', 'УСЛУГА', 'БЛЮДО', 'КОМПЛЕКС']}
                    ]
                },

                {
                    rows: [
                        {template: "Единица измерения", type: "section"},
                        {view: 'label', label: 'Идентификатор единицы'},
                        {view: 'text', name: 'idUnit'},
                        {view: 'label', label: 'Статус оборота единицы'},
                        {view: 'combo', name: 'unitStatus', value: 'Товар', options:['ACTIVE', 'NOT_ACTIVE', 'DELETED']},
                        {view: 'label', label: 'Наименование единицы измерения'},
                        {
                            view: 'combo', name: 'unitName',
                            click: function () {

                                webix.ui(
                                    {
                                        view: 'window',
                                        head: 'Выбор Ед.Из',
                                        width: 400,
                                        position: 'center',
                                        modal: true,
                                        //parentTable: this,
                                        //cell: id,
                                        body: unitDialog
                                    }).show()
                            }
                        },
                    ]
                },

                {
                    rows: [
                        {template: "Штрихкод", type: "section"},
                        {view: 'label', label: 'Идентификатор штрихкода'},
                        {view: 'text', name: 'id_barcode'},
                        {
                            cols: [
                                {view: 'label', label: 'Штрихкод'},
                                {view: 'text', name: 'code'},
                                {
                                    view: 'button', value: 'Новай штрихкод', inputWidth:150, align:"right",
                                    click: function() {
                                        generateBarcode("product_edit_form");
                                    }
                                }
                            ]
                        },
                        {
                            view: 'template', id: 'image_barcode', height: 45, width: 40, data: {
                                path: ""
                            },
                            template: "<img src='#path#'/>"
                        },

                    ]
                },

                {
                    cols:
                        [
                            {view: 'button', value: 'добавить цену',
                                click: function () {
                                    $$("prices").add({name: 'выберите тип цены'});
                                }},
                            {view: 'button', value: 'удалить цену',
                                click: function () {}}
                        ]
                },


                {view: 'datatable', id: 'prices', editable: true, maxHeight: 200, columns:[
                        {id: "id", header: "id", width:150, editor: 'text', hidden: true},
                        {id: "id_price", header: "id_price", width:150, hidden: true},
                        {id: "name", header: "Тип цены", editor: 'text', fillspace: true},
                        {id: "price", header: "Цена", editor: 'text'},

                    ],
                    on: {
                        onItemClick: function (id) {

                            if (id.column === 'name') {
                                webix.ui(
                                    {
                                        view: 'window',
                                        head: 'Тип цен',
                                        width: 400,
                                        position: 'center',
                                        modal: true,
                                        parentTable: this,
                                        cell: id,
                                        body: typePriceDialog
                                    }).show()
                                //})
                            }
                        }
                    }
                },
                {
                    view: 'button', value: 'Сохранить', width: 100,
                    click: function () {

                        let param = {
                            id: '',
                            operation: '',
                            data: ''
                        }

                        const obj = $$("product_edit_form");
                        let values = obj.getValues();

                        values.parentId = Number(values.parentId);

                        values.isGroup = values.isGroup === "true";

                        let price = $$('prices').serialize();
                        let prices = [];
                        let isNew = values.isNew;
                        let levelGroup = 0;

                        if (values.parentId !== 0 && values.isGroup)
                            levelGroup = 2;
                        else if(values.parentId === 0 && values.isGroup)
                            levelGroup = 1;
                        else
                            levelGroup = 0;

                        Object.assign(values, {levelGroup: levelGroup})

                        delete values['isNew'];

                        if (price.length >= 1) {
                            for (let i = 0; i <= price.length - 1; i++) {

                                let result = new Object({
                                    product: {
                                        id: values.id,
                                        parentId: values.parentId,
                                        isGroup: values.isGroup,
                                        levelGroup: values.levelGroup,
                                        name: values.name,
                                        typeProduct: values.typeProduct,
                                        status: 'ACTIVE'

                                    },
                                    price: Number(price[i].price),
                                    id: Number(price[i].id_price),
                                    status: 'ACTIVE',
                                    typePrice:
                                        {
                                            id: Number(price[i].id),
                                            name: price[i].name
                                        } // todo id таблицы price переименовать на id_type_price

                                })

                                prices.push(result);
                            }

                            Object.assign(values, {prices: prices});

                        }
                        let unit = {
                            id: values.idUnit,
                            unitName: values.unitName,
                            status: values.unitStatus
                        }

                        let barcode;

                        if(values.code !== "") {

                            barcode = {
                                id: values.id_barcode,
                                code: values.code,
                                typeBarcode: 'EAN13',
                                status: 'ACTIVE'
                            }
                        }else barcode = null;

                        delete values.idUnit;
                        delete values.unitName;
                        delete values.unitStatus;
                        delete values.id_barcode;
                        delete values.code;
                        delete values.isNew;

                        Object.assign(values, {unit: unit})
                        Object.assign(values, {barcode: barcode})

                        if (isNew === "true") {
                            param.id = values.id;
                            param.operation = 'insert';
                            param.data = values;

                        } else {
                            param.id = values.id;
                            param.operation = 'update';
                            param.data = values;
                        }

                        webix.proxy.resource.save(obj, param);
                    }
                }
            ]
    }
})