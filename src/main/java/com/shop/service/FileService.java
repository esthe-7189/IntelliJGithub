package com.shop.service;


import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;


//파일처리, 업로드와 삭제 메소드
@Service
@Log
public class FileService {

    public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws Exception{
        UUID uuid = UUID.randomUUID(); //서로다른 객체 구별위해 이름부여할때 파일이름으로 사용,파일명 중복 해결
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String savedFileName = uuid.toString() + extension;
        String fileUploadFullUrl = uploadPath + "/" + savedFileName;
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl); //바이트 단위의 출력을 내보내는 클래스
        fos.write(fileData);
        fos.close();
        return savedFileName;
    }

    public void deleteFile(String filePath) throws Exception{
        File deleteFile = new File(filePath);
        if(deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }

}
