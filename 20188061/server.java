import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;


public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket serverSocket=new DatagramSocket(4000);
			Scanner inpuut =new Scanner (System.in);
			
			System.out.println("Server is booted up");
			while (true)
			{
				//here i will receive the first input 
				byte[]requestBuffer=new byte[5000];
				
				DatagramPacket requestPacket=new DatagramPacket(requestBuffer, requestBuffer.length);
				
				serverSocket.receive(requestPacket);
				
				String request=new String(requestPacket.getData());
				String []arrstr=request.split(",");
				
				
				System.out.println("Client :"+request.trim());
				
				//here the serve will send to client to chose 1 or 2
				String replay="Please choose:\r\n"
						+ "1. Ascending order.\r\n"
						+ "2. Descending order.";
				
				byte[] replayByte=replay.getBytes();
				
				int replayLength=replayByte.length;
				
				InetAddress clientIP=requestPacket.getAddress();
				
				int clientPort=requestPacket.getPort();
				
				
				DatagramPacket replayPacket=new DatagramPacket(replayByte, replayLength, clientIP, clientPort);
				
				serverSocket.send(replayPacket);
				//
				
				//here i will receive 1 or 2 
                byte[]request2Buffer=new byte[5000];
				
				DatagramPacket request2Packet=new DatagramPacket(request2Buffer, requestBuffer.length);
				
				serverSocket.receive(request2Packet);
				
				String request2=new String(request2Packet.getData());
				
				System.out.println("Client :"+request2.trim());
				//
				
				//here i will send the number sorted 
				if(request2.contains("1"))
    			{	
					System.out.println("Done 1");
						int temp;
						int size=arrstr.length;
						int [] arr=new int[size];
						for(int i=0;i<size;i++)
	        			{
	        				arr[i] = Integer.parseInt(arrstr[i].trim());
	        				System.out.println("arr [i] = "+arr[i]);
	        			}System.out.println("Done parse ");
						
					for(int i=0;i<arr.length;i++)
					{
						for(int j=i;j<arr.length;j++)
						{
							if(arr[i]>arr[j])
							{
								temp=arr[i];
								arr[i]=arr[j];
								arr[j]=temp;
							}
						}
					
					}
					StringBuilder stringBuilder = new StringBuilder();
					for (int i = 0; i < arr.length; i++) {
						if(i==0)
						{
							stringBuilder.append("[");
						}
					    stringBuilder.append(arr[i]);
					    if(i==(arr.length)-1)
					    {
					    	stringBuilder.append("]");
					    	break;
					    }
					    stringBuilder.append(",");
					}
					String arrS = stringBuilder.toString();
					byte[] replay2Byte=arrS.getBytes();
					
					int replay2Length=replay2Byte.length;
					
					InetAddress client2IP=request2Packet.getAddress();
					
					int client2Port=request2Packet.getPort();
					
					
					DatagramPacket replay2Packet=new DatagramPacket(replay2Byte, replay2Length, client2IP, client2Port);
					
					serverSocket.send(replay2Packet);
    			}
				else 
				{
					
					int temp;
    				int size=arrstr.length;
    				int [] arr=new int[size];
    				for(int i=0;i<size;i++)
        			{	
        				arr[i] = Integer.parseInt(arrstr[i].trim());
        				
        			}
    				
    				for(int i=0;i<arr.length;i++)
    				{
    					for(int j=i;j<arr.length;j++)
    					{
    						if(arr[i]<arr[j])
    						{
    							temp=arr[i];
    							arr[i]=arr[j];
    							arr[j]=temp;
    						}
    					}
    				}
    				StringBuilder stringBuilder = new StringBuilder();
					for (int i = 0; i < arr.length; i++) {
						if(i==0)
						{
							stringBuilder.append("[");
						}
					    stringBuilder.append(arr[i]);
					    if(i==(arr.length)-1)
					    {
					    	stringBuilder.append("]");
					    	break;
					    }
					    stringBuilder.append(",");
					}
					String arrS = stringBuilder.toString();
                    byte[] replay2Byte=arrS.getBytes();
					
					int replay2Length=replay2Byte.length;
					
					InetAddress client2IP=requestPacket.getAddress();
					
					int client2Port=requestPacket.getPort();
					
					
					DatagramPacket replay2Packet=new DatagramPacket(replay2Byte, replay2Length, client2IP, client2Port);
					
					serverSocket.send(replay2Packet);
					
				}
					
				
				
				
				
				
				
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
