requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        rows: [
            { view: "toolbar", padding:3, elements: [
                    { view: "icon", icon: "wxi-folder-open", click: function(){
                            $$("$sidebar1").toggle();
                        }
                    },
                    { view: "label", label: "Albert Corporation"},
                    {},
                    { view: "icon", icon: "mdi mdi-comment",  badge:4},
                    { view: "icon", icon: "mdi mdi-bell",  badge:10}
                ]
            },
            { cols:[
                    {
                        view: "sidebar",
                        height: 300,
                        data: {id: "dashboard", icon: "mdi mdi-view-dashboard", value: "Dashboards",  data:[
                                { id: "dashboard1", value: "Dashboard 1"},
                                { id: "dashboard2", value: "Dashboard 2"}
                            ]},
                        on:{
                            onAfterSelect: function(id){
                                webix.message("Selected: "+this.getItem(id).value)
                            }
                        }
                    },
                    { template: ""}
                ]}
        ]
    }
})