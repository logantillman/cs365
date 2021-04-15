class ChatData {
    // distributeMessage: broadcasts a message to all clients in this chat room.
    // addClient: adds a client socket to the data structures for this ChatData object and creates a message indicating that the user has joined the chat room. This message is broadcast by distributeMessage.
    // deleteClient: removes a client socket from the data structures for this ChatData object and creates a message indicating that the user has left the chat room. This message is broadcast by distributeMessage.
    // broadcastMembers: writes a list of the chat rooms users to a new client so that the client can display the list of users in this chat room.
}