package com.shopping.service;

import org.springframework.web.multipart.MultipartFile;

import com.shopping.pojo.PictureResult;

public interface PictureService {
	public PictureResult uploadPicture(MultipartFile uploadFile);
}
