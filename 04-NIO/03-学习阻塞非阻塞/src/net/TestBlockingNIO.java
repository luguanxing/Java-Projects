package net;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/*
 * 一、使用 NIO 完成网络通信的三个核心：
 * 
 * 1. 通道（Channel）：负责连接
 * 		
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 * 
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 * 
 * 2. 缓冲区（Buffer）：负责数据的存取
 * 
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 * 
 */
public class TestBlockingNIO {

	// 客户端发送文件
	@Test
	public void client() throws Exception {
		// 获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		FileChannel inChannel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);

		// 分配指定大小的缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);

		// 读取本地文件并发送到服务端
		while (inChannel.read(buf) != -1) {
			buf.flip();
			sChannel.write(buf);
			buf.clear();
		}

		// 关闭通道
		inChannel.close();
		sChannel.close();
	}

	// 服务端接收文件
	@Test
	public void server() throws Exception {
		// 获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		FileChannel outChannel = FileChannel.open(Paths.get("2.txt"), StandardOpenOption.WRITE,
				StandardOpenOption.CREATE);

		// 绑定连接
		ssChannel.bind(new InetSocketAddress(9898));

		// 获取客户端连接的通道
		SocketChannel sChannel = ssChannel.accept();

		// 接收客户端的数据并保存到本地
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while (sChannel.read(buf) != -1) {
			buf.flip();
			outChannel.write(buf);
			buf.clear();
		}
		
		//关闭通道
		sChannel.close();
		outChannel.close();
		ssChannel.close();
	}

}
