/*import SockJS from '/resources/libs/sockjs.min'
import {Stomp} from '/resources/libs/stomp.min'*/

let stompClient = null;
let handlers = [];

const onMessageReceived = (msg) => {
    //todo метод тестовый, все нужно привести в порядок!
    const notification = JSON.parse(msg.body);
    const active = $$("list_users").getSelectedItem();

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

    } /*else {
        message.info("Received a new message from " + notification.senderName);
    }*/
    //loadContacts();
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

