requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        view: "toolbar",
        id: 'main_toolbar',
        url: 'resource->/users/user/authentication_user', //todo убрать отсюда
        padding: 3,
        elements: [
            {
                view: "icon", icon: "fas fa-bars", click: function () {
                    $$("$sidebar1").toggle();
                }
            },
            {view: "label", id: "username_label"},
            {
                view: 'button',
                value: 'Выход',
                width: 80,
                align: 'left',
                click: function () {
                    document.forms['logoutForm'].submit();
                }
            },
            {},
            {view: "icon", icon: "fas fa-envelope", badge: 4},
            {view: "icon", icon: "fas fa-bell", badge: 10}
        ],

        on: {
            onAfterLoad:function () {
                $$('username_label').setValue("WELCOME - " + $$('main_toolbar').getValues().username);
            }
        }
    }
})