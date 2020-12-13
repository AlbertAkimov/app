requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        view: 'datatable',
        id: 'typePrice',
        url: 'resource->/typePrice',
        //save: 'resource->/typePrice',
        columns: [
            {id: "id", header: "id", width: 150, template: "#id#"},
            {id: "name", header: "Тип цены", width: 250, template: "#name#"}
        ],
        on: {
            onItemClick: function (id) {
                let result = this.getItem(id);
                let parentConfig = this.getTopParentView().config;
                let cell = parentConfig.cell;

                let item = $$('prices').getItem(cell.row);
                item.id = result.id;
                item.name = result.name

                $$('prices').updateItem(cell.row, item);

                this.getTopParentView().close();
            }
        }

    }
})