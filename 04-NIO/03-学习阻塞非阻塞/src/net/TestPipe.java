package net;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

import org.junit.Test;

public class TestPipe {

	@Test
	public void test() throws Exception {
		// 获取管道
		Pipe pipe = Pipe.open();

		// 将缓冲区数据写入(可在线程中单独实现)
		ByteBuffer buf = ByteBuffer.allocate(1024);
		SinkChannel sinkChannel = pipe.sink();
		buf.put("管道单向发送的数据".getBytes());
		buf.flip();
		sinkChannel.write(buf);

		// 读取缓冲区的数据(可在线程中单独实现)
		SourceChannel sourceChannel = pipe.source();
		buf.flip();
		int len = sourceChannel.read(buf);
		System.out.println(new String(buf.array(), 0, len));
		
		// 关闭管道
		sinkChannel.close();
		sourceChannel.close();
	}

}
