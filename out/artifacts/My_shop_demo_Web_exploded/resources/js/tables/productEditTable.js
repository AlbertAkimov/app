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
                {view: 'text', label: 'ID', name: 'id'},
                {view: 'text', label: 'Это группа', name: 'isGroup'},
                {view: 'text', label: 'Это новый', name: 'isNew'},
                {view: 'text', label: 'Родитель', name: 'parentId'},
                {view: 'text', label: 'Наименование', name: 'name'},
                {view: 'combo', label: 'Тип', name: 'typeProduct', value: 'Товар', options:['ТОВАР', 'УСЛУГА', 'БЛЮДО', 'КОМПЛЕКС']},

                {view: 'button', value: 'добавить цену',
                    click: function () {
                        $$("prices").add({name: 'выберите тип цены'});
                    }},
                {view: 'button', value: 'удалить цену',
                    click: function () {}},

                {view: 'datatable', id: 'prices', editable: true, columns:[
                        {id: "id", header: "id", width:150},
                        {id: "name", header: "Тип цены", width:250, editor: 'text'},
                        {id: "price", header: "Цена", width:200, editor: 'text'},

                    ],
                    on: {
                        onItemClick: function (id) {

                            if (id.column === 'name') {
                                webix.ui(
                                    {typePriceDialog}).show()
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

                        if (values.isNew === '1') {
                            param.id = values.id;
                            param.operation = 'save';
                            param.data = values;

                        } else {
                            param.id = values.id;
                            param.operation = 'update';
                            param.data = values;
                        }

                        delete values['isNew'];
                        webix.proxy.resource.save(obj, param);
                    }
                }
            ]
    }
})