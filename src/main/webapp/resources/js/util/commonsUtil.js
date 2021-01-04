function addElementToTree(tree, values, nameFieldParentId) {
    let obj = $$(tree);

    if (obj === undefined) {
        console.log("Object with id: " + tree + "not found");
        return;
    }

    let selected = obj.getSelectedItem();
    let parent = 0;

    if (selected !== undefined) {
        parent = selected.id;
    }

    if (values[nameFieldParentId] === 0)
        values[nameFieldParentId] = parent;

    obj.add(values, 0, parent);
}

function generateBarcode(nameForm) {

    let obj = $$(nameForm);

    if (obj === undefined) {
        console.log("Object with id: " + nameForm + "not found");
    }

    let newBarcode = "";
    let possible = "0123456789";
    //let possible = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    for (let i = 0; i < 12; i++)
        newBarcode += possible.charAt(Math.floor(Math.random() * possible.length));

    let values = obj.getValues();
    //values.id_barcode = "";
    values.code = newBarcode;

    obj.setValues(values);

}
