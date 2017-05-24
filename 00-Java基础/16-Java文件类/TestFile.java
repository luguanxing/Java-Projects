import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {
	
	public static void main(String[] args) throws Exception {
		testFile();
		SearchDir();
	}
	
	public static void testFile() {
		File file=new File("十不准.txt");  
		System.out.println("判断文件是否存在"+file.exists());  
		System.out.println("读取文件名称"+file.getName()); 
		System.out.println("读取文件修改日期"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()))); 
		System.out.println("读取文件相对路径"+file.getPath());  
		System.out.println("读取文件绝对路径"+file.getAbsolutePath());  
		System.out.println("读取文件的父级路径"+new File(file.getAbsolutePath()).getParent());  
		System.out.println("读取文件的大小"+file.length()+"byte");
		System.out.println("判断文件是否被隐藏"+file.isHidden());  
		System.out.println("判断文件是否可读"+file.canRead());  
		System.out.println("判断文件是否可写"+file.canWrite());  
		System.out.println("判断文件是否为文件夹"+file.isDirectory());
		System.out.println("");
	}
	
	public static void SearchDir() {
		String dirpath = System.getProperty("user.dir");
		System.out.println("当前目录为"+dirpath);
		System.out.println("dir");
		File dir = new File(dirpath);
		BFS(dir, 0);
	}
	
	public static void BFS(File dir, int blank) {
		String dirpath = dir.getAbsolutePath();
		String[] files = dir.list();
		for (String file : files) {
			for (int i = 0; i < blank/4; i++)
				System.out.print("║  ");		//先打印骨架
			System.out.print("╚═ ");			//再打印分支
			System.out.print(file);
			System.out.println("");
			File checkisdir = new File(dirpath+"\\"+file);
			if (checkisdir.isDirectory()) {		//若为目录继续递归
				BFS(checkisdir, blank+4);
			}
		}
	}
}
