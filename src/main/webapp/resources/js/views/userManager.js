requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        cols: [
            {
                rows: [
                    {
                        id: 'usersManager',
                        view: 'datatable',
                        url: 'resource->/users',
                        save: 'resource->/users',
                        editable:true,
                        editaction: "custom",
                        //autoheight:true,
                        //autowidth:true,

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
                                adjust:true
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
                        ]
                    }
                ]
            }

            //{
            //    id: 'userManagerDetail',
            //    view: 'form',
                //width: 870,
                //height: 900,
            //}

        ]
    }
})