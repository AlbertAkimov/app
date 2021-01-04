requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        view: "toolbar", elements: [
            {
                view: "button",
                value: "Добавить",
                width: 100,

                click: function () {

                    let value =
                        {
                            parentId: 0,
                            name: "Новый элемент",
                            typeProduct: 'ТОВАР',
                            isNew: String(true),
                        };

                    addElementToTree("products", value, "parentId");

                }
            },
            {
                view: "button",
                value: "Удалить",
                width: 100,
                click: function () {

                    let tree = $$("products");
                    let param = {
                        id: tree.getSelectedId().id,
                        operation: 'delete'
                    };

                    webix.proxy.resource.save(tree, param);
                    tree.remove(tree.getSelectedId().id);

                }
            },
            {
                view: "button",
                value: "Обновить",
                width: 100,
                click: function () {
                    webix.proxy.resource.load($$("products"));
                    $$("products").refresh();
                }
            },
        ]
    }
})