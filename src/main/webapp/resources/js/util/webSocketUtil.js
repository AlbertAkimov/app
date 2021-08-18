/*import SockJS from '/resources/libs/sockjs.min'
import {Stomp} from '/resources/libs/stomp.min'*/

let stompClient = null;
let handlers = [];

const onMessageReceived = (msg) => {
    //todo метод тестовый, все нужно привести в порядок!
    const notification = JSON.parse(msg.body);
    let active = $$("list_users").getSelectedItem();

    if(active === undefined) {
        active = {id: 0};
    }

    if (active.id === notification.senderId) {

        $$("list_users").load({
            $proxy: true,
            load: function (view, params) {
                webix.ajax().get("/chat/messages/" + notification.id).then(function (value) {

                    let messages = value.json();

                    $$('list_of_messages').add(
                        {
                            user: messages.senderName,
                            value: messages.content

                        }
                    );
                })
            }
        });

    } else {
/*        webix.message.position = "bottom";
        webix.message.expire = 20000;*/

        webix.message({
            text: "Новое сообщение от " + "<br/>" + notification.senderName,
            type: "success",
            position: "bottom",
            expire: 20000
        });
    }
};

const onConnected = () => {
    let currentUser = $$('main_toolbar').getValues();
    console.log("connected");
    console.log(currentUser);
    stompClient.subscribe(
        "/user/" + currentUser.id + "/queue/messages",onMessageReceived
    );
};
const onError = (err) => {
    console.log(err);
};

function addHandlers(handler) {
    handlers.push(handler);
}

function connect() {
    let socket = new SockJS('http://localhost:8081/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({},onConnected, onError);
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function sendMessage(message) {
    stompClient.send("/app/chat", {}, JSON.stringify(message));
}

