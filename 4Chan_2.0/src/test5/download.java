package test5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class download {
		
		public download() {
			
			
		}
		
		public download(String aurl,String dir,window win) {
			

			
		
			ReadableByteChannel readChannel = null;
			
			String fileName = aurl.substring( aurl.lastIndexOf('/')+1, aurl.length() );
			System.out.println("url : " + aurl);
			System.out.println("Fn : " + fileName);
			System.out.println("dir : " + dir);
			
			
			try {
				 readChannel = Channels.newChannel(new URL(aurl).openStream());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			FileOutputStream fileOS = null;
			
			
			try {
				fileOS = new FileOutputStream(dir + "/" + fileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileChannel writeChannel = fileOS.getChannel();
			try {
				writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}