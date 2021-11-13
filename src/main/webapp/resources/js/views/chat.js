//import {connect, disconnect, sendMessage} from "../util/webSocketUtil";

requirejs.config({
    baseURI: 'js'
})

define(function () {

    return {

        id: 'chat',
        height: 690,

        rows:[
            {template: "Тестирование чата Webix", type:"header"},
            {
                cols:
                    [
                        {
                            id: 'list_users',
                            view: 'datatable',
                            url: 'resource->/users',
                            editable:true,
                            editaction: "custom",
                            gravity:3,
                            type: {height:"auto"},
                            maxWidth: 200,
                            select: 'row',
                            columns: [
                                {
                                    id: 'id',
                                    header: 'id',
                                    template: "#id#",
                                    adjust:true

                                },
                                {
                                    id: 'username',
                                    header: 'Имя',
                                    fillspace: true
                                }
                            ],

                            on: {
                                onItemClick: function (id) {
                                    $$("list_users").load({
                                        $proxy: true,
                                        load: function (view, params) {
                                            let sender = $$('main_toolbar').getValues();
                                            webix.ajax().get("/chat/messages/" + id.row + "/" + sender.id).then(function (value) {

                                                let messages = value.json();

                                                $$('list_of_messages').clearAll();

                                                for(let i = 0; i < messages.length; i++) {

                                                    $$('list_of_messages').add(
                                                        {
                                                            user: messages[i].senderName,
                                                            value: messages[i].content

                                                        }
                                                    );
                                                }

                                            })
                                        }
                                    });
                                }
                            }
                        },
                        {
                            view: "list",
                            id: 'list_of_messages',
                            gravity:3,
                            type:{ height:"auto" },
                            template:chat_template
                        },
                    ]
            },

            { cols: [
                    { view:"text", id:"message", placeholder:"Напишите сообщение", gravity: 3},
                    {
                        view:"button",
                        value: "Отправить",
                        click: function () {
                            send();
                        }
                    }
                ]}
        ], type:"space", margin:2
    }
})

function chat_template(obj){
    return "<span class='own'>" + obj.user +  "</span>" + obj.value;
}

function send() {
    let content = $$('message').getValue();

    let sender = $$('main_toolbar').getValues();
    let recipient = $$("list_users").getSelectedItem();

    let message =
        {
            senderId: sender.id,
            senderName: sender.username,
            recipientId: recipient.id,
            recipientName: recipient.username,
            content: content,
            status: 'ACTIVE',
            timestamp: new Date()
        }

    $$('list_of_messages').add(
        {
            user: sender.username,
            value: content
        }
    );
    sendMessage(message);
    $$('message').setValue("");
}

webix.UIManager.addHotKey("Enter", send, $$("message"));
webix.UIManager.setFocus($$("message"));