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
  function EliminarSeccion(strSeccionName){
    return confirm("¿Desea eliminar la seccion '" + strSeccionName + "'?")
  }
-->
</script>
   
    <label><fmt:message key="formaListadoSecciones.titulo" /></label>
   
               <html:errors />


        <table id="t01">
        <tr>
         <th><label><fmt:message key="formaListadoSecciones.etiqueta.nombre" /></label></th>
         <th COLSPAN=3><label><fmt:message key="formaListadoSecciones.etiqueta.administracion" /></label></th>
        </tr>

        
        <c:forEach var="seccion" items="${formaListadoSecciones.secciones}">
            <tr>
                <td><label><c:out value="${seccion.nombre}"/></label></td>
               <!-- <td><label><c:out value="${seccion.idTest}"/></label></td>  -->
                <td>


                  <a href='solicitarListarPreguntas.do?idSeccion=<c:out value="${seccion.id}"/>'>
                     <fmt:message key="formaListadoSecciones.etiqueta.modificar" />
                </a>
                
              </td>

              <td>

                <form method="post" action="procesarRegistroPregunta.do?volver=si" >

                  <input type="text" name="idSeccion" style="display: none" value="<c:out value='${seccion.id}'/>" />
                  <input type="text" name="nombre" style="margin-bottom: -18px"  placeholder="Nueva Pregunta" required />
                  <button style="display: none" >Enviar</button>

                </form>

              </td>

                <td><a href='procesarEliminarSeccion.do?id=<c:out value="${seccion.id}"/>'
					          onClick="javascript: return EliminarSeccion('<c:out value="${seccion.nombre}"/>')">
                        <fmt:message key="formaListadoSecciones.etiqueta.eliminar" />
                </a></td>
            </tr>
        </c:forEach>
        </table>
        
            <label><b>Total:</b> ${formaListadoSecciones.contador}</label>