/*import SockJS from '/resources/libs/sockjs.min'
import {Stomp} from '/resources/libs/stomp.min'*/

let stompClient = null;

const onConnected = () => {
    let currentUser = $$('main_toolbar').getValues();
    console.log("connected");
    console.log(currentUser);
    stompClient.subscribe(
        "/user/" + currentUser.id + "/queue/messages",
        ""
    );
};

const onError = (err) => {
    console.log(err);
};

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

