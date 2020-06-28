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

/*            if(params.operation === 'notContent') {
                url = url + '/' + params.id;
            }*/

            return ajax.get(url).then(function (value) {

             /*   if(params.operation === 'getById') {*/
/*                    var result = value.json();
                    $$("productEdit").elements.name.setValue(result.name);*/
/*                    return value.json();
                }*/

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