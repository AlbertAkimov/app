define(function () {
    var ajax = webix.ajax().headers({
        'Content-type': 'application/json'
    })

    webix.proxy.resource = {
        init:function () {
            webix.extend(this, webix.proxy.rest);
        },
        load:function (view, params) {
            return ajax.get("/products").then(function (value) {
                console.log(value);
                return value.json().content;
            })
        },
        save:function (view, params) {

            var id = params.id;
            var url = view.config.url.source;

            if(params.operation === 'update') {
                return ajax.put(url + '/' + id, params.data);
            }
        }
    }
})