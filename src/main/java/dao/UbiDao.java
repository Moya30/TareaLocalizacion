package dao;

import dto.Ubicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UbiDao{
    public static int ubicActual = 1, maxUbic = 148;
    public static int ubicActual2 = 1, maxUbicx = 148;
    public static Ubicacion get() {
        try {
            String sql = "select lat,lng,DatoAuto from dataubic where cod=?";
            Connection cn = MySQL.getInstance().getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, ubicActual);
            ResultSet rst = pstm.executeQuery();
            Ubicacion ubic = null;
            while (rst.next()) {
                ubic = new Ubicacion(rst.getDouble(1), rst.getDouble(2),rst.getString(3));
                break;
            }
            if (ubicActual <= 148) {
                ubicActual++;
            } else {
                ubicActual = 148;
            }
            return ubic; // lat, log / dato
        } catch (Exception ex) {
            return null;
        }
    }
}
