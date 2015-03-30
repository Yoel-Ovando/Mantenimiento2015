    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<head>
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

  function EliminarTest(strTestName){
    return confirm("¿Desea eliminar el test '" + strTestName + "'?")
  }



</script>
  
    <label><fmt:message key="formaListadoTests.titulo" /></label>
    
                
                <form method="post" action="procesarRegistroTest.do?volver=si" id="formulario">
                <!--<div id="formulario">-->

                  <input type="text" name="nombre" id="nombre" placeholder="Nuevo Test (Requerido)" required />
                  <input type="text" name="descripcion" id="descripcion" placeholder="Descripcion (Opcional)" />
                  <button onclick="">Nuevo Test</button>

                </form>

               <html:errors />
       
      <table id="t01">

        <tr>
          <th><label><fmt:message key="formaListadoTests.etiqueta.nombre" /></label></th>
          <th><label><fmt:message key="formaListadoTests.etiqueta.descripcion" /></label></th>
          <th COLSPAN=3><label><fmt:message key="formaListadoTests.etiqueta.administracion" /></label></th>
        </tr>

        <c:forEach var="test" items="${formaListadoTests.tests}">
            <tr>
                <td><label><c:out value="${test.nombre}"/></label></td>
                <td><label><c:out value="${test.descripcion}"/></label></td>
                <td><a href='solicitarListarSecciones.do?idTest=<c:out value="${test.id}"/>'>
                  <fmt:message key="formaListadoTests.etiqueta.modificar" />
                </a></td>
                <td>

                <form method="post" action="procesarRegistroSeccion.do?volver=si" >

                  <input type="text" name="idTest" style="display: none" value="<c:out value='${test.id}'/>" />
                  <input type="text" name="nombre" style="margin-bottom: -18px"  placeholder="Nueva Seccion" required />
                  <button style="display: none" >Enviar</button>

                </form>

                </td>
                <td><a href='procesarEliminarTest.do?id=<c:out value="${test.id}"/>'
					        onClick="javascript: return EliminarTest('<c:out value="${test.nombre}"/>')">
                  <fmt:message key="formaListadoTests.etiqueta.eliminar" />
                </a></td>
            </tr>
        </c:forEach>
        
      </table>

            <label><b>Total:</b> ${formaListadoTests.contador}</label>
