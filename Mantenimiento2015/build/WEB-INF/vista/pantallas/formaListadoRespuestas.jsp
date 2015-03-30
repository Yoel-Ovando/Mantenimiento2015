    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<style>

#formulario{
   width: 182px;
   background-color: #eee;
   padding: 20px;
}

#formulario #nombre, #descripcion{
   margin-bottom: 10px;
   padding: 4px;
   border: 1px solid #6E6E6E;
   border-radius: 3px;
}

#formulario button{
  width: 180px;
  height: 30px;
}

table {
    width:100%;
}
table {
    border: 1px solid #eee;
    border-collapse: collapse;
    font-family: Arial, Helvetica, sans-serif;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
    color: #414141;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
   color: #555555;
}
table#t01 th  {
    background-color: white;
    color: #6E6E6E;
    text-align: center;
}
</style>
<script language="javascript" type="text/javascript">
<!--
  function EliminarRespuesta(strRespuestaName){
    return confirm("¿Desea eliminar la respuesta '" + strRespuestaName + "'?")
  }
-->
</script>
   
    <label><fmt:message key="formaListadoRespuestas.titulo" /></label>
   
               <html:errors />


        <table id="t01">
        <tr>
         <th><label><fmt:message key="formaListadoRespuestas.etiqueta.nombre" /></label></th>
         <th><label><fmt:message key="formaListadoRespuestas.etiqueta.valor" /></label></th>
         <th><label><fmt:message key="formaListadoRespuestas.etiqueta.administracion" /></label></th>
        </tr>

        
        <c:forEach var="respuesta" items="${formaListadoRespuestas.respuestas}">
            <tr>
                <td><label><c:out value="${respuesta.nombre}"/></label></td>
                <td><label><c:out value="${respuesta.valor}"/></label></td>
           
                <td><a href='procesarEliminarRespuesta.do?id=<c:out value="${respuesta.id}"/>'
					          onClick="javascript: return EliminarRespuesta('<c:out value="${respuesta.nombre}"/>')">
                        <fmt:message key="formaListadoRespuestas.etiqueta.eliminar" />
                </a></td>
            </tr>
        </c:forEach>
        </table>
        
            <label><b>Total:</b> ${formaListadoRespuestas.contador}</label>