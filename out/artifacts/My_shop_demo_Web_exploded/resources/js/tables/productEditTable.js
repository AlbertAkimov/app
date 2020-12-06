requirejs.config({
    baseURI: 'js'
})

define(['tables/typePriceDialog'], function (typePriceDialog) {
    return {
        view: 'form',
        id: 'product_edit_form',
        width: 600,
        height: 900,
        url: 'resource->/products',
        save: 'resource->/products',
        elements:
            [
                {view: 'text', label: 'ID', name: 'id', hidden: true},
                {view: 'text', label: 'Это группа', name: 'isGroup',hidden: true},
                {view: 'text', label: 'Это новый', name: 'isNew', hidden: true},
                {view: 'text', label: 'Родитель', name: 'parentId',hidden: true},
                {view: 'text', label: 'Наименование', name: 'name'},
                {view: 'combo', label: 'Тип', name: 'typeProduct', value: 'Товар', options:['ТОВАР', 'УСЛУГА', 'БЛЮДО', 'КОМПЛЕКС']},

                {view: 'button', value: 'добавить цену',
                    click: function () {
                        $$("prices").add({name: 'выберите тип цены'});
                    }},
                {view: 'button', value: 'удалить цену',
                    click: function () {}},

                {view: 'datatable', id: 'prices', editable: true, columns:[
                        {id: "id", header: "id", width:150, editor: 'text', hidden: true},
                        {id: "id_price", header: "id_price", width:150, hidden: true},
                        {id: "name", header: "Тип цены", width:250, editor: 'text'},
                        {id: "price", header: "Цена", width:200, editor: 'text'},

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
                        delete values['isNew'];

                        for (let i = 0; i <= price.length - 1; i++) {

                            let result = new Object({
                                product: {
                                    id: values.id,
                                    isGroup: values.isGroup,
                                    name: values.name,
                                    parentId: values.parentId,
                                    typeProduct: values.typeProduct
                                },
                                price: Number(price[i].price),
                                id: price[i].id_price,
                                typePrice: {id: price[i].id, name: price[i].name}

                            })

                            prices.push(result);
                        }

                        Object.assign(values, {prices: prices})

                        if (isNew === '1') {
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