function onMessage(event) {
	console.log(event.data);
	var json=JSON.parse(event.data);
	
}

function onOpen(event) {
	console.log("onOpen");
//	socket.open();
}

function onError(event) {
	console.log("onError");
}
function init() {
	alert("init");
	// Requesting a specific protocol
//	socket = new WebSocket("ws://localhost:8080/jetty-websocket-poc/notifications/B090", "sip");
	socket = new WebSocket("ws://localhost:8080/jetty-websocket-poc/notifications/B090");
	console.log(socket.readyState);
	socket.onmessage = onMessage;
	socket.onopen = onOpen;
	socket.onerror = onError;
}
var socket;
window.onload=init;
