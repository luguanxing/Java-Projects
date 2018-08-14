package net;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

public class TestNonBlockingNIO {

	// 客户端
	@Test
	public void client() throws Exception {
		// 获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

		// 切换成非阻塞模式
		sChannel.configureBlocking(false);

		// 分配缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);

		// 发送数据给服务端
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			buf.put((new Date().toString() + "\n" + str).getBytes());
			buf.flip();
			sChannel.write(buf);
			buf.clear();
		}

		// 关闭通道
		sChannel.close();
	}

	// 服务端
	@Test
	public void server() throws Exception {
		// 获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();

		// 切换成非阻塞模式
		ssChannel.configureBlocking(false);

		// 绑定连接
		ssChannel.bind(new InetSocketAddress(9898));

		// 获取选择器
		Selector selector = Selector.open();

		// 将通道注册到选择器上，指定监听的状态或事件(接收)
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);

		// 轮询式获取选择器上已经“准备就绪”的事件
		while (selector.select() > 0) {
			// 选择当前选择器中所有注册的“选择键(已注册的监听事件)”
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			// 迭代获取准备就绪的事件
			while (it.hasNext()) {
				SelectionKey sk = it.next();
				// 判断准备就绪事件的具体内容
				if (sk.isAcceptable()) {
					// 连接就绪->获取远程的客户端连接，可单独分配到某上线程
					SocketChannel sChannel = ssChannel.accept();
					// 切换成非阻塞模式
					sChannel.configureBlocking(false);
					// 也得将该通道注册到选择器上
					sChannel.register(selector, SelectionKey.OP_READ);
				} else if (sk.isReadable()) {
					// 可读就绪->获取读通道，可单独分配到某上线程
					SocketChannel sChannel = (SocketChannel) sk.channel();
					//读取数据
					ByteBuffer buf = ByteBuffer.allocate(1024);
					int len = 0;
					while ((len = sChannel.read(buf)) > 0) {
						buf.flip();
						System.out.println(new String(buf.array(), 0, len));
						buf.clear();
					}
				}
				// 取消选择键SelectionKey
				it.remove();
			}
		}
	}

}
