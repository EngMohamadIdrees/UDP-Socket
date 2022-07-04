import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket clientSocket=new DatagramSocket();
			Scanner inpuut =new Scanner (System.in);
			while(true)
			{
				System.out.println(" Server : Please enter the list of numbers to be arranged or 'close' to close the connection ");
				
				String request=inpuut.nextLine();
				String []arrstr=request.split(",");
				
				if (request.equalsIgnoreCase("close"))
				{
					clientSocket.close();
					System.out.println("Client is Terminated");
					break;
				}
				else if(!request.equalsIgnoreCase("close")&&arrstr[0].matches("\\d"))
				{
					// here i will send to the server the number
					byte[] requestByte=request.getBytes();
					
					int requestLength=requestByte.length;
					
					InetAddress serverIP=InetAddress.getByName("localhost");
					
					int serverPort=4000;
					
					DatagramPacket requestPacket= new DatagramPacket(requestByte, requestLength, serverIP, serverPort);
					
					clientSocket.send(requestPacket);
					//
					
					//here i will receive  the server 1 or 2 
					byte[]replayBuffer=new byte[5000];
					
					DatagramPacket replayPacket=new DatagramPacket(replayBuffer, replayBuffer.length);
					
					clientSocket.receive(replayPacket);
					
					String replay=new String(replayPacket.getData());
					
					System.out.println("Server :"+replay.trim()); 
					//
					
					//here i will send the 1 or 2 
					String request2=inpuut.nextLine();
					
                    byte[] reques2tByte=request2.getBytes();
					
					int request2Length=reques2tByte.length;
					
					InetAddress server2IP=InetAddress.getByName("localhost");
					
					int server2Port=4000;
					
					DatagramPacket request2Packet= new DatagramPacket(reques2tByte, request2Length, server2IP, server2Port);
					
					clientSocket.send(request2Packet);
					//
					
					// here i will receive the number with sorted
					
                    byte[]replay2Buffer=new byte[5000];
					
					DatagramPacket replay2Packet=new DatagramPacket(replay2Buffer, replay2Buffer.length);
					
					clientSocket.receive(replay2Packet);
					
					String replay2=new String(replay2Packet.getData());
					
					System.out.println("Server :"+replay2.trim());
					//
					
					
					
					
					
					
					
				}
				else 
				{
					System.out.println("Server :Wrong Input ");
					
				}
				
				
			}
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
