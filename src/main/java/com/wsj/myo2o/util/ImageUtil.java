package com.wsj.myo2o.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.runner.notification.RunNotifier;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	
	public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
		String realFileName = FileUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}
	
	public static String generateNormallmg(CommonsMultipartFile thumbnail, String targetAddr) {
		String realFileName = FileUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getInputStream()).size(337, 640).outputQuality(0.5f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}
	
	public static List<String> generateNormallmgs(List<CommonsMultipartFile> imgs, String targetAddr){
		int count = 0;
		List<String> relativeAddrList = new ArrayList<String>();
		if (imgs != null && imgs.size() > 0) {
			makeDirPath(targetAddr);
			for (CommonsMultipartFile img : imgs) {
				String realFileName = FileUtil.getRandomFileName();
				String extension = getFileExtension(img);
				String relativeAddr = targetAddr + realFileName + count + extension;
				File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
				count++;
				try {
					Thumbnails.of(img.getInputStream()).size(600, 300).outputQuality(0.5f).toFile(dest);
				} catch (IOException e) {
					throw new RuntimeException("创建图片失败：" + e.toString());
				}
				relativeAddrList.add(relativeAddr);
			}
		}
		return relativeAddrList;
	}
	
	/**
	 * 创建目录
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath=FileUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
	
	/**
	 * 获取扩展名
	 * @param cFile
	 * @return
	 */
	private static String getFileExtension(CommonsMultipartFile cFile) {
		String originalFileName=cFile.getOriginalFilename();
		//返回'.'之后的字符
		return originalFileName.substring(originalFileName.lastIndexOf('.'));
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * 练习:改变图片大小并添加水印
		 */
		//当前线程路径
		//String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Thumbnails.of(new File("C:/Users/WangShuaiJie/Downloads/timg.jpg"))
		.size(1280,622)
		.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:/Users/WangShuaiJie/Downloads/logo.png")), 0.25f)
		.outputQuality(0.8f) 
		.toFile("C:/Users/WangShuaiJie/Downloads/newtimg.jpg");
		
		
		//测试CommonsMultipartFile转File
		CommonsMultipartFile img = null;
		inputStreamToFile(img.getInputStream(),  new File(""));
	}
	
	private static void inputStreamToFile(InputStream ins, File file) {
		OutputStream os=null;
		try {
			os=new FileOutputStream(file);
			int bytesRead=0;
			byte[] buff=new byte[1024];
			while((bytesRead=ins.read(buff))!=-1) {
				os.write(buff, 0, bytesRead);
			}
		}catch (Exception e) {
			throw new RuntimeException("调用InputSreamToFile产生异常 "+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(ins!=null) ins.close();
			}catch (IOException e) {
				throw new RuntimeException("调用InputSreamToFile关闭io产生异常 "+e.getMessage());
			}
		}
	}
}
