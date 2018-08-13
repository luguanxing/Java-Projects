package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

import org.junit.Test;

/*
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 * 
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 * 
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 * 
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 * 		
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 * 
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 * 
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 * 
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 * 
 */
public class TestChannel {

	// 利用通道完成文件的复制（非直接缓冲区）
	@Test
	public void testCopy1() throws Exception {
		long start = System.currentTimeMillis();
		// 先获取原始流
		FileInputStream fis = new FileInputStream("e:/1.RMVB");
		FileOutputStream fos = new FileOutputStream("e:/2.RMVB");

		// 获取通道
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();

		// 获取缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);

		// 通过通道传输缓冲区运输数据
		while (inChannel.read(buf) != -1) {
			buf.flip();
			outChannel.write(buf);
			buf.clear();
		}

		outChannel.close();
		inChannel.close();
		fos.close();
		fis.close();
		long end = System.currentTimeMillis();
		System.out.println("耗时" + (end - start));
	}

	// 利用通道完成文件的复制（直接缓冲区）
	@Test
	public void testCopy2() throws Exception {
		long start = System.currentTimeMillis();
		// 创建相应的类型通道
		FileChannel inChannel = FileChannel.open(Paths.get("e:/1.RMVB"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("e:/3.RMVB"), StandardOpenOption.WRITE,
				StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

		// 使用通道创建内存映射文件
		MappedByteBuffer inMapBuf = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMapBuf = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

		// 直接操作内存映射文件就传输完成了，不需要用通道了
		byte[] dst = new byte[inMapBuf.limit()];
		inMapBuf.get(dst);
		outMapBuf.put(dst);

		outChannel.close();
		inChannel.close();
		long end = System.currentTimeMillis();
		System.out.println("耗时" + (end - start));
	}

	// 利用通道之间直接完成文件的复制（直接缓冲区）
	@Test
	public void testCopy3() throws Exception {
		long start = System.currentTimeMillis();
		// 创建相应的类型通道
		FileChannel inChannel = FileChannel.open(Paths.get("e:/1.RMVB"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("e:/4.RMVB"), StandardOpenOption.WRITE,
				StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

		// 通道之间直接传输
		inChannel.transferTo(0, inChannel.size(), outChannel);
		// outChannel.transferFrom(inChannel, 0, inChannel.size());

		outChannel.close();
		inChannel.close();
		long end = System.currentTimeMillis();
		System.out.println("耗时" + (end - start));
	}

	// 分散读取和聚集写入
	@Test
	public void testScatterAndGather() throws Exception {
		RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");

		// 获取通道
		FileChannel channel1 = raf1.getChannel();

		// 分配多个缓冲区
		ByteBuffer buf1 = ByteBuffer.allocate(100);
		ByteBuffer buf2 = ByteBuffer.allocate(200);

		// 分散读取
		ByteBuffer[] bufs = { buf1, buf2 };
		channel1.read(bufs);
		
		for (ByteBuffer buf : bufs) {
			buf.flip();
		}
		
		System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
		System.out.println("---------------");
		System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));
		
		RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
		FileChannel channel2 = raf2.getChannel();
		
		channel2.write(bufs);
	}

	// 字符集
	@Test
	public void testCharsetMap() throws Exception {
		Map<String, Charset> map = Charset.availableCharsets();
		Set<Entry<String, Charset>> entrySet = map.entrySet();
		for (Entry<String, Charset> entry : entrySet) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}
	}
	
	//编码与解码
	@Test
	public void testCharset() throws Exception {
		Charset cs1 = Charset.forName("GBK");
		
		//获取编码器与解码器
		CharsetEncoder ce = cs1.newEncoder();
		CharsetDecoder cd = cs1.newDecoder();
		
		CharBuffer cBuf = CharBuffer.allocate(1024);
		cBuf.put("你好啊");
		cBuf.flip();
		
		//编码
		ByteBuffer bBuf = ce.encode(cBuf);
		for (int i = 0; i < bBuf.limit(); i++) {
			System.out.println(bBuf.get());
		}
		
		//解码
		bBuf.flip();
		CharBuffer cBufDecode = cd.decode(bBuf);
		System.out.println(cBufDecode);
		
		// 用不同解码器尝试解码
		bBuf.flip();
		Charset cs2 = Charset.forName("UTF-8");
		CharBuffer cBufDecode2 = cs2.decode(bBuf);
		System.out.println(cBufDecode2);
	}
}
