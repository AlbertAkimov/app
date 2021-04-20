requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        view: 'datatable',
        id: 'unitsDialog',
        url: 'resource->/units',
        //save: 'resource->/typePrice',
        columns: [
            {id: "id", header: "id", width: 50, template: "#id#"},
            {id: "unitName", header: "Наименоавние", width: 350, template: "#unitName#"}
        ],
        on: {
            onItemClick: function (id) {
                let result = this.getItem(id);
                let values = $$('product_edit_form').getValues();
                values.idUnit = result.id;
                values.unitStatus = result.status;
                values.unitName = result.unitName;

                $$('product_edit_form').setValues(values)

                this.getTopParentView().close();

            }
        }

    }
})