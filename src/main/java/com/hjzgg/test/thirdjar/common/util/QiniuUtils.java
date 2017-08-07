package com.hjzgg.test.thirdjar.common.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


public class QiniuUtils {

    public static final String domain = "http://o93qmsoro.qnssl.com/";

    /**
     * 授权key
     */
    private String accessKey = "az4AJ4iMNUywZfow3DNQiezV2AyRyWH14MoTsqMo";

    /**
     * 秘钥
     */
    private String secretKey = "jqvrNCJNxtrBoAr3-LzIqtKbjRpVgW73GmnunIrk";

    /**
     * bucket name
     */
    private String bucket = "beiquan";

    private String path = "image/ad/system/";

    /**
     * 配置类
     */
    private Configuration cfg = null;

    private UploadManager uploadManager = null;

    private String upToken = null;

    // 通过构造代码块完成配置的创建
    {
        cfg = new Configuration(Zone.autoZone());
        uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        upToken = auth.uploadToken(bucket);
    }

    public String upload(MultipartFile file) throws IOException {
        try {
            Response response = uploadManager.put(file.getInputStream(), path + uuid(file.getOriginalFilename()), upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return domain + putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (file != null) {
                file.getInputStream().close();
            }
        }
        return null;
    }

    public String uuid(String originalFilename) {
        UUID uuid = UUID.randomUUID();
//        int indexOf = originalFilename.lastIndexOf(".");
//        String sub = originalFilename.substring(indexOf);
//        return uuid.toString().replaceAll("-", "") + sub;
        return uuid.toString().replaceAll("-", "");
    }
}
