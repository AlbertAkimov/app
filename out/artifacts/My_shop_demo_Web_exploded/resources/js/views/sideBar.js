requirejs.config({
    baseURI: 'js'
})

define(function () {
    return {
        rows: [
            {
                view: 'toolbar', css: 'main_toolbar', elements: [
                    {
                        view: 'button',
                        type: 'icon',
                        icon: 'bars',
                        width: 30,
                        align: 'left',
                        css: 'main_toolbar_icon_bars_icon'
                    },
                    {view: 'label', label: 'My Application', css: 'toolbar_label'},
                    {
                        view: 'button', type: 'icon', icon: 'envelop-o', width: 40,
                        align: 'left', css: 'main_toolbar_icon envelope_icon', badge: 4
                    },
                    {
                        view: 'button', type: 'icon', icon: 'bell-o', width: 40,
                        align: 'left', css: 'main_toolbar_icon bars_icon', badge: 10
                    }
                ]
            },
            {
                cols: [
                    {
                        view: 'sidebar',
                        css: 'main_sidebar',
                        data: [{
                            id: 'item1', icon: 'home', value: 'Справочники', data: [
                                {id: 'item_products', value: 'Товары'},
                                {id: 'item_category', value: 'Категории товара'}
                            ]
                        }]
                    }
                ]
            }
        ]
    }
})