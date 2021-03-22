package mrzhang.utils;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.documents.ImageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertWordToOtherFormats {

	private final static String wordFile = "/Users/zhangdabao/Documents/工作文档/需求专项工具/spire/原始文档（有目录）.docx";
	private final static String FilePath = "/Users/zhangdabao/Documents/工作文档/需求专项工具/spire/";

	public static void main(String[] args) throws IOException {

		//创建Document对象
		Document doc = new Document();

		//加载Word文档
		doc.loadFromFile(wordFile);

		//将指定页保存为BufferedImage
		BufferedImage image= doc.saveToImages(1, ImageType.Bitmap);

//		//将图片数据保存为PNG格式文档
		File file= new File(FilePath + "ToPNG.png");
		ImageIO.write(image, "PNG", file);

		//将Word保存为HTML格式
		doc.saveToFile(FilePath + "ToHtml.html", FileFormat.Html);
	}
}
