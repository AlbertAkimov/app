requirejs.config({
    baseURI: 'js'
})

define(['tables/roleDialog'], function (roleDialog) {
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

                                        let user = $$('usersManager').getSelectedItem();
                                        let data = $$('role_table').serialize();

                                        let privileges = [];

                                        for (let i = 0; i < data.length; i++) {

                                            let index = data[i].name.indexOf("_");
                                            let nameTable = data[i].name.substring(index + 1);
                                            let permissions = [];
                                            let permission;

                                            if (data[i].isWrite) {

                                                permission = {
                                                    id: data[i].id_2_w,
                                                    id_2: data[i].id_w,
                                                    permission: "WRITE:" + nameTable
                                                };
                                                permissions.push(permission);
                                            }
                                            if (data[i].isRead) {

                                                permission = {
                                                    id: data[i].id_2_r,
                                                    id_2: data[i].id_r,
                                                    permission: "READ:" + nameTable
                                                };
                                                permissions.push(permission);
                                            }
                                            if (data[i].isRemove) {

                                                permission = {
                                                    id: data[i].id_2_d,
                                                    id_2: data[i].id_d,
                                                    permission: "DELETE:" + nameTable
                                                };
                                                permissions.push(permission);
                                            }

                                            for (let j = 0; j < permissions.length; j++) {

                                                let result = new Object({
                                                    id: permissions[j].id_2,
                                                    permission: {
                                                        id: permissions[j].id,
                                                        permission: permissions[j].permission
                                                    },
                                                    role: {
                                                        id: data[i].id,
                                                        name: data[i].name
                                                    },
                                                    user: user
                                                })

                                                privileges.push(result);
                                            }
                                        }

                                        let param = {
                                            id: '',
                                            url: '/privileges/all',
                                            operation: 'insert',
                                            data: JSON.stringify(privileges)
                                        }

                                        webix.proxy.resource.save($$('usersManager'), param);

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
                                        webix.ajax().get("/privileges/user/" + id.row).then(function (value) {

                                            let bridges = value.json();

                                            $$('role_table').clearAll();

                                            for (let i = 0; i < bridges.length; i++) {

                                                if(bridges[i].permission === null)
                                                    continue;

                                                //let tmp = $$('role_table').serialize();
                                                let obj = $$('role_table').getItem(bridges[i].role.id);

                                                let isFound = 0;

                                                if(obj !== undefined)
                                                    isFound = 1;

                                                let id_w     = webix.uid();
                                                let id_r     = webix.uid();
                                                let id_d     = webix.uid();
                                                let id_2_w   = webix.uid();
                                                let id_2_r   = webix.uid();
                                                let id_2_d   = webix.uid();
                                                let isWrite  = webix.uid();
                                                let isRead   = webix.uid();
                                                let isRemove = webix.uid();

                                                if(isFound) {
                                                    id_w     = obj.id_w;
                                                    id_r     = obj.id_r;
                                                    id_d     = obj.id_d;
                                                    id_2_w   = obj.id_2_w;
                                                    id_2_r   = obj.id_2_r;
                                                    id_2_d   = obj.id_2_d;
                                                    isWrite  = obj.isWrite;
                                                    isRead   = obj.isRead;
                                                    isRemove = obj.isRemove;
                                                }

                                                if (bridges[i].permission.permission.charAt(0) === 'W') {
                                                    id_w    = bridges[i].id;
                                                    id_2_w  = bridges[i].permission.id;
                                                    isWrite = 1;
                                                }
                                                if (bridges[i].permission.permission.charAt(0) === 'R') {
                                                    id_r    = bridges[i].id;
                                                    id_2_r  = bridges[i].permission.id;
                                                    isRead  = 1;
                                                }
                                                if (bridges[i].permission.permission.charAt(0) === 'D') {
                                                    id_d     = bridges[i].id;
                                                    id_2_d   = bridges[i].permission.id;
                                                    isRemove = 1;
                                                }

                                                if(isFound) {
                                                    obj.isWrite     = isWrite;
                                                    obj.isRead      = isRead;
                                                    obj.isRemove    = isRemove;
                                                    obj.id_w        = id_w;
                                                    obj.id_r        = id_r;
                                                    obj.id_d        = id_d;
                                                    obj.id_2_w      = id_2_w;
                                                    obj.id_2_r      = id_2_r;
                                                    obj.id_2_d      = id_2_d;

                                                    $$('role_table').refresh();
                                                }
                                                else {
                                                    $$('role_table').add(
                                                        {
                                                            id: bridges[i].role.id,
                                                            name: bridges[i].role.name,
                                                            isWrite: isWrite,
                                                            isRead: isRead,
                                                            isRemove: isRemove,
                                                            id_w: id_w,
                                                            id_r: id_r,
                                                            id_d: id_d,
                                                            id_2_w: id_2_w,
                                                            id_2_r: id_2_r,
                                                            id_2_d: id_2_d
                                                        }
                                                    );
                                                }
                                            }
                                        })
                                    }
                                });

                            } // click
                        } // on
                    },

                    {
                        view: "toolbar",
                        elements: [
                            {
                                view: 'button',
                                value: 'Добавить',
                                width: 100,
                                click: function () {
                                    $$("role_table").add({name: 'Выберите роль'});
                                }
                            },

                        ]
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
                                    header: "id_role",
                                    css: {"text-align": "canter"},
                                    template: "#id#",
                                    hidden: true
                                    //adjust:true
                                },

                                {
                                    id: "id_w",
                                    header: "id_w",
                                    css: {"text-align": "canter"},
                                    hidden: true
                                    //template: "#id#",
                                    //adjust:true
                                },

                                {
                                    id: "id_r",
                                    header: "id_r",
                                    css: {"text-align": "canter"},
                                    hidden: true
                                    //template: "#id#",
                                    //adjust:true
                                },

                                {
                                    id: "id_d",
                                    header: "id_d",
                                    css: {"text-align": "canter"},
                                    hidden: true
                                    //template: "#id#",
                                    //adjust:true
                                },

                                {
                                    id: 'id_2_w',
                                    header: 'id_2_w',
                                    hidden: true
                                    //hidden: true
                                },

                                {
                                    id: 'id_2_r',
                                    header: 'id_2_r',
                                    hidden: true
                                    //hidden: true
                                },

                                {
                                    id: 'id_2_d',
                                    header: 'id_2_d',
                                    hidden: true
                                    //hidden: true
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

                            ],

                        on: {
                            onItemClick: function (id) {

                                if (id.column === 'name') {
                                    webix.ui(
                                        {
                                            view: 'window',
                                            head: 'Список ролей',
                                            width: 400,
                                            position: 'center',
                                            modal: true,
                                            parentTable: this,
                                            cell: id,
                                            body: roleDialog
                                        }).show()
                                    //})
                                }
                            }
                        }
                    }
                ]
            }
        ]
    }
})