<%@page import="dao.UbiDao"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="dto.Ubicacion"%>


<%
    /* SIMULA DATO OBTENIDO POR LA APP MOVIL*/
    Ubicacion ubic = UbiDao.get();
    Gson gson = new Gson();
    String json = gson.toJson(ubic);
    out.print(json);

%>
