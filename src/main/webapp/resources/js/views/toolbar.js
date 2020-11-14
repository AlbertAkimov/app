requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        view: "toolbar", padding: 3, elements: [
            {
                view: "icon", icon: "fas fa-bars", click: function () {
                    $$("$sidebar1").toggle();
                }
            },
            {view: "label", label: "Albert Corporation"},
            {},
            {view: "icon", icon: "fas fa-envelope", badge: 4},
            {view: "icon", icon: "fas fa-bell", badge: 10}
        ]
    }
})