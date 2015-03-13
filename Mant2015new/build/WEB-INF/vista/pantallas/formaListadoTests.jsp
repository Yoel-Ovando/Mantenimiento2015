    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<style>
  .HipervinculoAdmon{
    color:#000000;
	text-decoration:none;
  }
  
  .HipervinculoAdmon:hover{
    color:#006666;
	text-decoration:underline;
  }
</style>
<script language="javascript" type="text/javascript">
<!--
  function EliminarTest(strTestName){
    return confirm("¿Desea eliminar el test '" + strTestName + "'?")
  }
-->
</script>
    <br>
    <font size='5'><fmt:message key="formaListadoTests.titulo" /></font>
    <div class="table" style="width:100%" >
        <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href="solicitarRegistroTest.do" class="HipervinculoAdmon boton">Agregar nuevo test...</a>
            </div>
        </div>
        <div class="tr">
            <div class="td" colspan="4">
               <html:errors />
            </div>
        </div>
        <div class="tr" style="background:#CCCCCC;">
         <div class="td" style="width:20%"><b><fmt:message key="formaListadoTests.etiqueta.nombre" /></b></div>
        
        <c:forEach var="test" items="${formaListadoTests.tests}">
            <div class="tr">
                <div class="td" align="left" style="width:20%"><c:out value="${test.nombre}"/></div>
                <div class="td" align="left" style="width:20%">
                    <a href='solicitarModificarTest.do?id=<c:out value="${test.id}"/>' class="HipervinculoAdmon">
                        <fmt:message key="formaListadoTests.etiqueta.modificar" />
                    </a>
                    <a href='procesarEliminarTest.do?id=<c:out value="${test.id}"/>'
					   onClick="javascript: return EliminarTest('<c:out value="${test.nombre}"/>')"
					   class="HipervinculoAdmon">
                        <fmt:message key="formaListadoTests.etiqueta.eliminar" />
                    </a>
                </div>
            </div>
        </c:forEach>
        <div class="tr">
            <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoTests.contador}</div>
        </div>
    </div>