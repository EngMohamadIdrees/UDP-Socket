# UDP-Socket
UDP socket routines enable simple IP communication using the user datagram protocol (UDP).

The User Datagram Protocol (UDP) runs on top of the Internet Protocol (IP) and was developed for applications that do not require reliability, acknowledgment, or flow control features at the transport layer. This simple protocol provides transport layer addressing in the form of UDP ports and an optional checksum capability.

UDP is a very simple protocol. Messages, so called datagrams, are sent to other hosts on an IP network without the need to set up special transmission channels or data paths beforehand. The UDP socket only needs to be opened for communication. It listens for incoming messages and sends outgoing messages on request.

This documentation is separated as follows:

User API describes the operation of UDP Sockets.
Configuration explains the configuration options of the UDP Sockets.
