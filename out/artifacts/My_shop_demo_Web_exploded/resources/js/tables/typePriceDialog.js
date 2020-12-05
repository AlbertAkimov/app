requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        view: 'window',
        head: 'Тип цен',
        width: 400,
        position: 'center',
        modal: true,
        parentTable: this,
        cell: id,
        body: {
            view: 'datatable',
            id: 'typePrice',
            url: 'resource->/typePrice',
            save: 'resource->/typePrice',
            columns: [
                {id: "id", header: "id", width: 150, template: "#id#"},
                {id: "name", header: "Тип цены", width: 250, template: "#name#"}
            ],
            on: {
                onItemClick: function (id) {
                    let result = this.getItem(id);
                    let parentConfig = this.getTopParentView().config;
                    let cell = parentConfig.cell;

                    $$('prices').updateItem(cell.row, {name: result.name, id: result.id});

                    this.getTopParentView().close();
                }
            }
        }

    }
})