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

                    let tree = $$("products");
                    let selected = tree.getSelectedItem();
                    let parent = 0;

                    if(selected !== undefined) {
                            parent = selected.id;
                    }

                    tree.add({
                        parentId: parent,
                        name: "Новый элемент",
                        typeProduct: 'ТОВАР',
                        isNew: String(true),
                    }, 0, parent);

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