package de.container42.photos;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by edi on 4/13/16.
 */
@WebServlet("/DisplayPhotoServlet")
public class DisplayPhotoServlet extends HttpServlet {

//    @Inject
//    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexString = req.getParameter("photo");
        int index = new Integer(indexString.trim());
        resp.setContentType("img/jpeg");
        try (OutputStream out = resp.getOutputStream()) {
            ServletContext myServletContext = req.getServletContext();
            PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(myServletContext);
            byte[] bytes = pa.getPhotoData(index);
            for (byte aByte : bytes) {
                out.write(aByte);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
