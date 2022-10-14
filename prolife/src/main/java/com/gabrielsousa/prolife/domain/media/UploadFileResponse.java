package com.gabrielsousa.prolife.domain.media;

import java.io.Serializable;

public class UploadFileResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String fileDownloadUri;
	private String fileType;
	private Long size;
	
	public UploadFileResponse() {
		super();
	}

	public UploadFileResponse(Integer id, String fileDownloadUri, String fileType, Long size) {
		super();
		this.id = id;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
