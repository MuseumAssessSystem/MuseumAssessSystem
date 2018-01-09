package com.service.impl;

import com.service.DeleteFileService;

import java.io.File;

/**
 * Created by 10922 on 2018/1/9.
 */
public class DeleteFileServiceImpl implements DeleteFileService{

    // 递归删除目录下的所有文件及子目录下所有文件
    @Override
    public boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    // 删除空目录，dir是将要删除的目录路径
    private void deleteEmptyDir(String dir){
        boolean success = (new File(dir)).delete();
        if (success) {
            System.out.println("Successfully deleted empty directory: " + dir);
        } else {
            System.out.println("Failed to delete empty directory: " + dir);
        }
    }
}
