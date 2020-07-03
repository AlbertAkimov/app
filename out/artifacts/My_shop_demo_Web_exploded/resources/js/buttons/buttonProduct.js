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
                    var tree = $$("products");
                    var parent = tree.getSelectedId() || 0;
                    tree.add({name: ""}, 0, parent);
                    tree.open(parent);
                }
            },
            {
                view: "button",
                value: "Удалить",
                width: 100,
                click: function () {
                    var tree = $$("products");
                    var id = tree.getSelectedId();
                    if (id)
                        tree.remove(id);
                }
            },
            {
                view: "button",
                value: "Обновить",
                width: 100,
                click: function () {
                    $$("products").refresh();
                }
            },
        ]
    }
})