package com.example.model;

public class MyFile {
    private String display;
    private String path;
    private String desc;
    private FileSupport fileType;
    private boolean hasChild;

    public MyFile() {
    }

    public MyFile(String display, String path, String desc, FileSupport fileType, boolean hasChild) {
        this.display = display;
        this.path = path;
        this.desc = desc;
        this.fileType = fileType;
        this.hasChild = hasChild;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FileSupport getFileType() {
        return fileType;
    }

    public void setFileType(FileSupport fileType) {
        this.fileType = fileType;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }
}
