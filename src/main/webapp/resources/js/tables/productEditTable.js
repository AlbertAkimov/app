requirejs.config({
    baseURI: 'js'
})

define(['tables/typePriceDialog', 'tables/unitDialog'], function (typePriceDialog, unitDialog) {
    return {
        view: 'form',
        id: 'product_edit_form',
        width: 870,
        height: 900,
        url: 'resource->/products',
        save: 'resource->/products',
        elements:
            [
                {
                    rows:[
                        {template: "Номенклатура", type: "section"},
                        {view: 'text', label: 'ID', name: 'id'},
                        {view: 'text', label: 'Родитель', name: 'parentId'},
                        {view: 'text', label: 'Уровень группировки', name: 'levelGroup'},
                        {view: 'text', label: 'Это группа', name: 'isGroup'},
                        {view: 'text', label: 'Это новый элемент', name: 'isNew'},
                        {view: 'text', label: 'Наименование', name: 'name'},
                        {view: 'combo', label: 'Тип', name: 'typeProduct', value: 'Товар', options:['ТОВАР', 'УСЛУГА', 'БЛЮДО', 'КОМПЛЕКС']}
                    ]
                },

                {
                    rows: [
                        {template: "Единица измерения", type: "section"},
                        {view: 'text', label: 'ID UNIT', name: 'idUnit'},
                        {view: 'combo', label: 'Статус ед.из', name: 'unitStatus', value: 'Товар', options:['ACTIVE', 'NOT_ACTIVE', 'DELETED']},
                        {
                            view: 'combo', label: 'Единица измерения', name: 'unitName',
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
                        {template: "Общее", type: "section"},
                        {view: 'combo', label: 'Статус товара', name: 'status', value: 'Товар', options:['ACTIVE', 'NOT_ACTIVE', 'DELETED']}
                    ]
                },

                {view: 'button', value: 'добавить цену',
                    click: function () {
                        $$("prices").add({name: 'выберите тип цены'});
                    }},
                {view: 'button', value: 'удалить цену',
                    click: function () {}},

                {view: 'datatable', id: 'prices', editable: true, columns:[
                        {id: "id", header: "id", width:150, editor: 'text'},
                        {id: "id_price", header: "id_price", width:150},
                        {id: "name", header: "Тип цены", width:150, editor: 'text'},
                        {id: "price", header: "Цена", width:100, editor: 'text'},

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
                        values.isGroup = Boolean(values.isGroup);

                        let price = $$('prices').serialize();
                        let prices = [];
                        let isNew = values.isNew;
                        let levelGroup = 0;

                        if (values.parentId !== 0 && values.isGroup)
                            levelGroup = 2;
                        else
                            levelGroup = 1;

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
                                        status: 'ACTIVE',
                                        unit: {
                                            id: values.idUnit,
                                            unitName: values.unitName,
                                            status: values.unitStatus
                                        }

                                    },
                                    price: Number(price[i].price),
                                    id: price[i].id_price,
                                    status: 'ACTIVE',
                                    typePrice: {id: price[i].id, name: price[i].name} // todo id таблицы price переименовать на id_type_price

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

                        delete values.idUnit;
                        delete values.unitName;
                        delete values.unitStatus;
                        Object.assign(values, {unit: unit})

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