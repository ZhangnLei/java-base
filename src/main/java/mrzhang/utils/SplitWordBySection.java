package mrzhang.utils;
import com.spire.doc.Document;

/**
 * @author zhangnianlei
 * @date 2020/11/3
 */
public class SplitWordBySection {


	public static void main(String[] args) {

		//创建Document对象
		Document document = new Document();

		//加载要拆分的文档
		document.loadFromFile("/Users/zhangdabao/Documents/code/Java/java-base/src/main/java/mrzhang/utils/document.docx");

		//声明新的Document对象
		Document newWord;

		//遍历源文档中的节
		for (int i = 0; i < document.getSections().getCount(); i++)
		{
			//初始化新的Document对象
			newWord = new Document();

			//将源文档中的指定节复制到新文档
			newWord.getSections().add(document.getSections().get(i).deepClone());

			//保存新文档到指定文件夹
			newWord.saveToFile(String.format("/Users/zhangdabao/Documents/code/Java/java-base/src/main/java/mrzhang/utils/result-%d.docx", i));
		}
	}

}
