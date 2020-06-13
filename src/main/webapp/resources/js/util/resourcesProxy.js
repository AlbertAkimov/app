define(function () {
    var ajax = webix.ajax().headers({
        'Content-type': 'application/json'
    })

    webix.proxy.resource = {
        init:function () {
            webix.extend(this, webix.proxy.rest);
        },
        load:function (view, params) {
            return ajax.get("/products/tree").then(function (value) {
                console.log(value);
                return value.json().content;
            })
        },
        save:function (view, params) {
            return
        }
    }
})