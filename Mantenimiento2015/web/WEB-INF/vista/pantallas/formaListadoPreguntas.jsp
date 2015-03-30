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
  function EliminarPregunta(strPreguntaName){
    return confirm("�Desea eliminar la pregunta '" + strPreguntaName + "'?")
  }
-->
</script>
   
    <label><fmt:message key="formaListadoPreguntas.titulo" /></label>
   
               <html:errors />


        <table id="t01">
        <tr>
         <th><label><fmt:message key="formaListadoPreguntas.etiqueta.nombre" /></label></th>
         <th COLSPAN=3><label><fmt:message key="formaListadoPreguntas.etiqueta.administracion" /></label></th>
        </tr>

        
        <c:forEach var="pregunta" items="${formaListadoPreguntas.preguntas}">
            <tr>
                <td><label><c:out value="${pregunta.nombre}"/></label></td>

                <td>
                  <a href='solicitarListarRespuestas.do?idPregunta=<c:out value="${pregunta.id}"/>'>
                     <fmt:message key="formaListadoPreguntas.etiqueta.modificar" /> </a>  
              </td>

              <td>

                <form method="post" action="procesarRegistroRespuesta.do?volver=si" >

                  <input type="text" name="idPregunta" style="display: none" value="<c:out value='${pregunta.id}'/>" />
                  <input type="text" name="nombre" style="margin-bottom: -18px"  placeholder="Nueva Respuesta" required />
                  <!--<input type="text" name="valor" style="display: none" value="incorrecto" />-->
                  <select name="valor" style="margin-bottom: -10px">
                    <option value="incorrecto">incorrecto</option>
                    <option value="correcto">correcto</option>
                  </select>
                  <button style="display: none" >Enviar</button>

                </form>

              </td>

              <td><a href='procesarEliminarPregunta.do?id=<c:out value="${pregunta.id}"/>'
					          onClick="javascript: return EliminarPregunta('<c:out value="${pregunta.nombre}"/>')">
                        <fmt:message key="formaListadoPreguntas.etiqueta.eliminar" />
                </a></td>
            </tr>
        </c:forEach>
        </table>
        
            <label><b>Total:</b> ${formaListadoPreguntas.contador}</label>