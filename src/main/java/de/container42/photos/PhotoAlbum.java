package de.container42.photos;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edi on 4/22/16.
 */
public class PhotoAlbum {
    public static String ATTRIBUTE_NAME = "Photo_Album";
    private List<byte[]> photoDataList = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public static PhotoAlbum getPhotoAlbum(ServletContext servletContext) {
        if(servletContext.getAttribute(ATTRIBUTE_NAME) == null) {
            PhotoAlbum pa = new PhotoAlbum();
            servletContext.setAttribute(ATTRIBUTE_NAME, pa);
        }
        return (PhotoAlbum) servletContext.getAttribute(ATTRIBUTE_NAME);
    }

    public synchronized void addPhoto(String name, byte[] bytes) {
        this.photoDataList.add(bytes);
        this.names.add(name);
    }

    public synchronized byte[] getPhotoData(int i) {
        return photoDataList.get(i);
    }

    public synchronized String getPhotoName(int i) {
        return names.get(i);
    }

    public synchronized int getPhotoCount() {
        return photoDataList.size();
    }

    public synchronized void removePhoto(int i) {
        photoDataList.remove(i);
        names.remove(i);
    }
}
