requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {

        view: "sidebar",
        url: 'resource->/sidebar',
        save: 'resource->/sidebar',

        on: {
            onAfterSelect: function (id) {
                routie(this.getItem(id).sidebarId);
            }
        }
    }
})