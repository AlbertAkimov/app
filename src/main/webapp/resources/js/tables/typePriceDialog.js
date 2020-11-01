requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        view: 'datatable',
        id: 'typePrice',
        url: 'resource->/typePrice',
        save: 'resource->/typePrice',
        columns: [
            {id: "id", header: "id", width: 150, template: "#id#"},
            {id: "name", header: "Тип цены", width: 250, template: "#name#"}
        ]

    }
})