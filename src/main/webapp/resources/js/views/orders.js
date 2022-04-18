requirejs.config({
    baseURI: 'js'
})

define(function () {

    return {

        id: 'orders_view_id',
        view: 'datatable',
        url: 'resource->/orders',
        save: 'resource->/orders',
        //editable: true,
        editaction: "custom",
        select: 'cell',

        columns:
            [
                {
                    id: "id",
                    header: "id",
                    css: {"text-align": "canter"},
                    width: 150,
                    template: "#id#",
                    adjust:true
                },

                {
                    id: 'status',
                    header: 'Статус',
                    template: "#status#",
                    adjust:true
                },

                {
                    id: 'partner_id',
                    css: {"text-align": "center"},
                    template: "#owner.id#",
                    hidden: true
                },
                {
                    id: 'partner_name',
                    header: 'Партнер',
                    template: "#owner.firstName#",
                    fillspace: true
                },

                {
                    id: 'card_id',
                    template: "#card.id#",
                    hidden: true
                },

                {
                    id: 'card_number',
                    header: 'Карта',
                    template: "#card.number#",
                    adjust:true
                },

                {
                    id: 'totalSum',
                    header: 'Сумма документа',
                    template: '#totalSum#',
                    adjust:true
                }
            ]

    }
})