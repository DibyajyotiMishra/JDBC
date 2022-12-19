package com.jdbc.practice;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;

public class FetchImage {
    public static ImageIcon getImageIconById(int id, Connection con) {
        ImageIcon icon = null;
        try {
            String query = "select image from images where id=?;";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                Blob blob = set.getBlob("image");
                InputStream is = blob.getBinaryStream();
                Image image = ImageIO.read(is);
                icon = new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }

}
