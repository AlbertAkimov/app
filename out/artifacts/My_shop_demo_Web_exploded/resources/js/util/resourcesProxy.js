define(function () {
    var ajax = webix.ajax().headers({
        'Content-type': 'application/json'
    })

    webix.proxy.resource = {
        init:function () {
            webix.extend(this, webix.proxy.rest);
        },
        load:function (view, params) {

            var id = 0;
            var url = view.config.url.source;

            if(params != null) {
                if (params.operation === 'details') {
                    id = params.id;
                    url = url + '/' + id;
                }
            }

            return ajax.get(url).then(function (value) {
                if (params != null) {
                    if (params.operation === 'details') {
                        return value.json();
                    }
                }
                return value.json().content;
            })
        },

        save:function (view, params) {

            const id = params.id;
            const url = view.config.url.source;

            if(params.operation === 'update') {
                return ajax.put(url + '/' + id, params.data);
            }
        }

    }
})