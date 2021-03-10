requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        type: 'wide',

        cols: [
            {
                rows: [
                    {
                        view: 'toolbar',
                        elements:
                            [
                                {
                                    view: "button",
                                    value: "Сохранить",
                                    width: 100,

                                    click: function () {


                                    }
                                },
                                {
                                    view: "button",
                                    value: "Деактивировать",
                                    width: 100,

                                    click: function () {

                                    }
                                }
                            ]
                    },

                    {
                        id: 'usersManager',
                        view: 'datatable',
                        url: 'resource->/users',
                        save: 'resource->/users',
                        editable:true,
                        editaction: "custom",
                        maxHeight: 300,
                        select: 'row',

                        columns: [
                            {
                                id: "id",
                                header: "id",
                                css: {"text-align": "canter"},
                                template: "#id#",
                                adjust:true

                            },

                            {
                                id: "username",
                                header: "Логин",
                                fillspace: true
                            },

                            {
                                id: "firstName",
                                header: "Имя",
                                adjust:true
                            },

                            {
                                id: "lastName",
                                header: "Фамилия",
                                adjust:true
                            },

                            {
                                id: "email",
                                header: "Почта",
                                adjust:true
                            },

                            {
                                id: "phone",
                                header: "Телефон",
                                adjust:true
                            },

                            {
                                id: "status",
                                header: "Статус",
                                adjust:true
                            }
                        ],

                        on: {
                            onItemClick: function (id) {

                                $$("usersManager").load({
                                    $proxy: true,
                                    load: function (view, params) {
                                        webix.ajax().get("/users/" + id.row).then(function (value) {

                                            let result = value.json();
                                            let bridges = result.bridges;

                                            $$('role_table').clearAll();

                                            for (let i = 0; i < bridges.length; i++) {

                                                let tmp = $$('role_table').serialize();
                                                let indicator = 0;

                                                for(let j = 0; j < tmp.length; j++) {

                                                    if(tmp[j].id === bridges[i].role.id) {
                                                        indicator = 1;
                                                        break;
                                                    }
                                                }

                                                if(indicator === 0) {

                                                    $$('role_table').add(
                                                        {
                                                            id: bridges[i].role.id,
                                                            name: bridges[i].role.name,
                                                            isWrite: 0,
                                                            isRead: 0,
                                                            isRemove: 0
                                                        }
                                                    );
                                                }
                                            }

                                            for(let i = 0; i < bridges.length; i++) {

                                                if(bridges[i].permission !== null) {
                                                    let permission = bridges[i].permission.permission;
                                                    let index = permission.indexOf(':');
                                                    let role = permission.substring(index + 1);

                                                    let search = $$('role_table').find(function (obj) {
                                                        return obj.name.indexOf('ROLE_' + role) !== -1;
                                                    });

                                                    if(search === undefined)
                                                        continue;

                                                    let searchObj = $$('role_table').getItem(search[0].id);

                                                    let isWrite     = searchObj.isWrite;
                                                    let isRead      = searchObj.isRead;
                                                    let isRemove    = searchObj.isRemove;

                                                    if (permission.charAt(0) === 'W')
                                                        isWrite = 1;
                                                    if (permission.charAt(0) === 'R')
                                                        isRead = 1;
                                                    if (permission.charAt(0) === 'D')
                                                        isRemove = 1;

                                                    searchObj.isWrite   = isWrite;
                                                    searchObj.isRead    = isRead;
                                                    searchObj.isRemove  = isRemove;

                                                    $$('role_table').refresh();
                                                }
                                            }

                                            //deleteDuplicate("role_table");
                                        })
                                    }
                                });

                            } // click
                        } // on
                    },

                    {
                        id: 'role_table',
                        view: 'datatable',
                        editable:true,
                        editaction: "custom",
                        maxHeight: 400,

                        columns:
                            [
                                {
                                    id: "id",
                                    header: "id",
                                    css: {"text-align": "canter"},
                                    template: "#id#",
                                    adjust:true
                                },

                                {
                                    id: "name",
                                    header: "Роль",
                                    fillspace: true
                                },

                                {
                                    id: "isWrite",
                                    header: "Запись",
                                    template:"{common.checkbox()}"
                                },

                                {
                                    id: "isRead",
                                    header: "Чтение",
                                    template:"{common.checkbox()}"
                                },

                                {
                                    id: "isRemove",
                                    header: "Удаление",
                                    template:"{common.checkbox()}"
                                },
                            ]
                    }
                ]
            }
        ]
    }
})