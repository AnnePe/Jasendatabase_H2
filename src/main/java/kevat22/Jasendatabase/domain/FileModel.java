package kevat22.Jasendatabase.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String fileName, mimeType;
	
	@Lob
	private byte[] file;

	public FileModel() {};
	
	public FileModel(String fileName, String mimeType, byte[] file) {
		super();
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.file = file;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileModel [fileName=" + fileName + ", mimeType=" + mimeType + ", file=" + Arrays.toString(file) + "]";
	}
	
	
}
