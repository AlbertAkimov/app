import SockJS from '/resources/libs/sockjs.min'
import {Stomp} from '/resources/libs/stomp.min'

let stompClient = null;

export function connect() {
    let socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect();
}

export function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

export function sendMessage(message) {
    stompClient.send("/app/chat", {}, JSON.stringify(message));
}

