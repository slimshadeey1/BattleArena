package mc.alk.arena.util;

import mc.alk.arena.BattleArena;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

	public static InputStream getInputStream(Class<?> clazz, File file) {
		InputStream inputStream = null;
		if (file.exists()){
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				Log.printStackTrace(e);
			}
		}
		String path = file.getPath();
		/// Load from pluginJar
		inputStream = clazz.getResourceAsStream(path);
		if (inputStream == null)
			inputStream = clazz.getClassLoader().getResourceAsStream(path);
		return inputStream;
	}

	@SuppressWarnings("resource")
	public static InputStream getInputStream(Class<?> clazz, File defaultFile, File defaultPluginFile) {
		InputStream inputStream = null;
		if (defaultPluginFile.exists()){
			try {
				inputStream = new FileInputStream(defaultPluginFile);
			} catch (FileNotFoundException e) {
				Log.printStackTrace(e);
			}
		}

		/// Try to load a default file from the given plugin
		/// Load from ExtensionPlugin.Jar
		if (inputStream == null)
			inputStream = clazz.getResourceAsStream(defaultPluginFile.getPath());
		if (inputStream == null) /// will this work to fix the problems in windows??
			inputStream = clazz.getClassLoader().getResourceAsStream(defaultPluginFile.getPath());
		/// Load from the defaults
		/// Load from BattleArena.jar
		if (inputStream == null)
			inputStream = BattleArena.getSelf().getClass().getResourceAsStream(defaultFile.getPath());
		if (inputStream == null)
			inputStream = BattleArena.getSelf().getClass().getClassLoader().getResourceAsStream(defaultFile.getPath());

		return inputStream;
	}

	public static boolean hasResource(Class<?> clazz, String default_file) {
		InputStream inputStream = null;
		try{
			inputStream = clazz.getResourceAsStream(default_file);
			if (inputStream == null){ /// will this work to fix the problems in windows??
				inputStream = clazz.getClassLoader().getResourceAsStream(default_file);}
			return inputStream != null;
		} catch (Exception e){
			return false;
		} finally{
			if (inputStream!=null)try{inputStream.close();}catch(Exception e){}
		}
	}

	public static File load(Class<?> clazz, String config_file, String default_file) {
		File file = new File(config_file);
		if (!file.exists()){ /// Create a new file from our default example
			InputStream inputStream = null;
			OutputStream out = null;
			try{
				inputStream = clazz.getResourceAsStream(default_file);
				if (inputStream == null){
					inputStream = clazz.getClassLoader().getResourceAsStream(default_file);}
				out=new FileOutputStream(config_file);
				byte buf[]=new byte[1024];
				int len;
				while((len=inputStream.read(buf))>0){
					out.write(buf,0,len);}
			} catch (Exception e){
				Log.printStackTrace(e);
			} finally {
				if (out != null) try {out.close();} catch (Exception e){/* ignore*/}
				if (inputStream != null) try {inputStream.close();} catch (Exception e){/* ignore*/}
			}
		}
		return file;
	}
}
