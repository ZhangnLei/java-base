package mrzhang.utils;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.documents.ImageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertWordToOtherFormats {

	public static void main(String[] args) throws IOException {

		//创建Document对象
		Document doc = new Document();

		//加载Word文档
		doc.loadFromFile("C:\\Users\\Administrator\\Desktop\\sample.docx");

		//将指定页保存为BufferedImage
		BufferedImage image= doc.saveToImages(0, ImageType.Bitmap);

		//将图片数据保存为PNG格式文档
		File file= new File("output/ToPNG.png");
		ImageIO.write(image, "PNG", file);

		//将Word保存为SVG格式
		doc.saveToFile("output/ToSVG.svg",FileFormat.SVG);

		//将Word保存为RTF格式
		doc.saveToFile("output/ToRTF.rtf",FileFormat.Rtf);

		//将Word保存为XPS格式
		doc.saveToFile("output/ToXPS.xps",FileFormat.XPS);

		//将Word保存为XML格式
		doc.saveToFile("output/ToXML.xml",FileFormat.Xml);

		//将Word保存为TXT格式
		doc.saveToFile("output/ToTXT.txt",FileFormat.Txt);
	}
}
