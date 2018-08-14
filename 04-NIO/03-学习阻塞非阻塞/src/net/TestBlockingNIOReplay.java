package net;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class TestBlockingNIOReplay {

	// 客户端发送文件，并接收响应
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

		// 结束客户端通道发送
		sChannel.shutdownOutput();

		// 阻塞式等接收服务端反馈
		while (sChannel.read(buf) != -1) {
			buf.flip();
			System.out.println(new String(buf.array(), 0, buf.limit()));
			buf.clear();
		}

		// 关闭通道
		inChannel.close();
		sChannel.close();
	}

	// 服务端接收文件，并返回响应
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

		// 结束服务端通道接收(可选，但服务端结束接收和客户端结束发送至少得执行其中一个)
		sChannel.shutdownInput();

		// 反馈结果给客户端
		buf.put("服务端接收数据成功".getBytes());
		buf.flip();
		sChannel.write(buf);
		sChannel.shutdownInput();

		// 关闭通道
		sChannel.close();
		outChannel.close();
		ssChannel.close();
	}

}
