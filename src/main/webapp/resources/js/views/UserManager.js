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
                        url: 'resource->/typePrice',
                        save: 'resource->/typePrice',
                        editable:true,
                        editaction: "custom",

                        columns: [
                            {
                                id: "id",
                                header: "id",
                                css: {"text-align": "canter"},
                                width: 150,
                                template: "#id#"

                            },

                            {
                                id: "firstName",
                                header: "Имя",
                                width: 250
                            },

                            {
                                id: "lastName",
                                header: "Фамилия",
                                width: 250
                            },

                            {
                                id: "email",
                                header: "Почта",
                                width: 250
                            },

                            {
                                id: "phone",
                                header: "Телефон",
                                width: 250
                            },

                            {
                                view: 'combo',
                                label: 'Статус',
                                name: 'status',
                                value: 'ACTIVE',
                                options: ['ACTIVE', 'NOT_ACTIVE', 'DELETED']
                            }
                        ]
                    }
                ]
            },

            {
                id: 'userManagerDetail',
                view: 'form',
                //width: 870,
                //height: 900,
            }

        ]
    }
}