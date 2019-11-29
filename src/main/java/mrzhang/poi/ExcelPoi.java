//package mrzhang.poi;
//
//import com.sun.media.sound.InvalidFormatException;
//import com.sun.rowset.internal.Row;
//import javafx.scene.control.Cell;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author zhangnianlei
// * @date 2019/11/11
// */
//public class ExcelPoi {
//	public static void main(String[] args) throws IOException {
//		File directory = new File("");
//
//		String path = directory.getCanonicalPath(); //得到的是C:\test
////		String filePath = path + File.separator+ "excel01.xls";
////		String filePath = "/Users/zhangdabao/Documents/syfintech/dcpms-service-business-function-info/src/main/java/com/dcpms/service/business/function/info/service/impl/excel01.xls";
//		String filePath = "/Users/zhangdabao/Downloads/业务功能点数据导出20191108101036420.xls";
//		System.out.println(filePath);
//		readFile(filePath);
//	}
//
//	/**
//	 * 根据文件路径读取文件返回文件内容数据
//	 * @param path
//	 * @return
//	 */
//	public static List<String[]> readFile(String path) {
//		File file = new File(path);
//		InputStream is =null;
//		if (file.exists()) {
//			//将file 转换成MultipartFile
//			try{
////				String filePath = "../excel01.xls";
//				is = new FileInputStream(path);
////				MultipartFile mf = new MockMultipartFile(file.getName(),new FileInputStream(file));
////				is = mf.getInputStream();
//				//获取文件名
//				//String fileName = mf.getOriginalFilename(); 获取原始文件名。在单元测试中值是空的。可能不是通过页面上传获取到的文件。
//				String fileName = file.getName();
//
//				Workbook workbook = null;
//				if (fileName.endsWith("xls")){
//					workbook = new HSSFWorkbook(is);
//				} else if(fileName.endsWith("xlsx")){
//					workbook = new XSSFWorkbook(is);
//				} else {
//					System.out.println("workBoot 创建失败");
//				}
//				//获得当前页
//				Sheet sheet = workbook.getSheetAt(0);
//				//容器
//				List<String[]> list = new ArrayList<>();
//
//				//遍历获取每行
//				int firstRowNum = sheet.getFirstRowNum();
//				int lastRowNum = sheet.getLastRowNum();
//				for (int i =firstRowNum+1;i <= lastRowNum;i++) {
//					Row row = sheet.getRow(i);
//					int lastCellNum = row.getLastCellNum();
//					//遍历每行获取每列的数据
//					String[] cells = new String[lastCellNum];
//					for (int j = 0; j < lastCellNum; j++) {
//						Cell cell = row.getCell(j);
//						String value = "";
//						if (cell != null) {
//
////							 cell.get();
////							if (pizhu != null) {
////								System.out.println(pizhu);
////							}
//							Comment comment = cell.getCellComment();
//							if (comment != null) {
//								RichTextString str = comment.getString();
//								String author = comment.getAuthor();
//								System.out.println(author+" : " +str);
//
//							}
////							int cellType = cell.getCellType();
////							//判断单元格value 调用不同的返回值获取数据
////							switch (cellType) {
////								case 0:
////									double numericCellValue = cell.getNumericCellValue();
////
////									value = String.valueOf(numericCellValue);
////									value = value.substring(0,value.lastIndexOf("."));
////									break;
////								case 1:
////									value = cell.getStringCellValue();
////									break;
////							}
//						}
//						cells[j]=value;
//					}
//					list.add(cells);
//				}
//				return list;
//			} catch (Exception  e){
//				System.out.println("文件转换出错");
//				e.printStackTrace();
//			} finally {
//				if (is != null) {
//					try {
//						is.close();
//					} catch (Exception e){
//						System.out.println("输入流关闭异常");
//					}
//				}
//			}
//			return null;
//		}else{
//			System.out.println("文件不存在");
//			return null;
//		}
//	}
//
//}
