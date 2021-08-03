import {connect, disconnect, sendMessage} from "../util/webSocketUtil";

requirejs.config({
    baseURI: 'js'
})

define(function () {

    return {

        height: 600,

        rows:[
            { template:"Тестирование чата Webix", type:"header" },
            {
                view: "list", id:"chat", gravity:3,
                //url:  "faye->/data", save: "faye->/data",
                type:{ height:"auto" },
                template:chat_template
            },
            { cols: [
                    { view:"text", id:"message", placeholder:"Напишите сообщение", gravity: 3},
                    {
                        view:"button",
                        value: "Отправить",
                        click: function () {

                            let message =
                            {
                                senderId: 1,
                                senderName: "Test sender",
                                recipientId: 1,
                                recipientName: "Test recipient",
                                content: $$('message').getValue()
                            }

                            connect();
                            sendMessage(message);
                            disconnect();

                        }
                    }
                ]}
        ], type:"space", margin:2
    }
})

function chat_template(obj){
    return "<span class='own'>" + obj.user +  "</span>" + obj.value;
}