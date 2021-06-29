requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        view: 'datatable',
        id: 'roleDialog',
        url: 'resource->/roles',
        columns: [
            {id: "id", header: "id", width: 50, template: "#id#"},
            {id: "name", header: "роль", width: 350, template: "#name#"}
        ],
        on: {
            onItemClick: function (id) {
                let result = this.getItem(id);
                let parentConfig = this.getTopParentView().config;
                let cell = parentConfig.cell;

                let item = $$('role_table').getItem(cell.row);
                item.id = result.id;
                item.name = result.name

                $$('role_table').updateItem(cell.row, item);

                this.getTopParentView().close();

            }
        }

    }
})