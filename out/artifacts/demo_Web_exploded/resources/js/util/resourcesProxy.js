define(function () {
    var ajax = webix.ajax().headers({
        'Content-type': 'application/json'
    })

    webix.proxy.resource = {
        init:function () {
            webix.extend(this, webix.proxy.rest);
        },
        load:function (view, params) {

            var url = view.config.url.source;

            return ajax.get(url).then(function (value) {
                //return value.json().content;
                return value.json();
            })
        },

        save:function (view, params) {

            const id = params.id;
            const url = view.config.url.source;

            if(params.operation === 'update') {
                return ajax.put(url + '/' + id, params.data);
            }

            if(params.operation === 'delete') {
                return ajax.del(url + '/' + id, id);
            }

            if(params.operation === 'insert') {
                return ajax.post(url, params.data);
            }
        }

    }
})