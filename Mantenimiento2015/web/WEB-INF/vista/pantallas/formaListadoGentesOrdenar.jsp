    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

        <c:forEach var="gente" items="${formaListadoGentesOrdenar.gentes}">
            <div class="tr">
                <div class="td" align="left" style="width:16%"><c:out value="${gente.nombres}"/></div>
                <div class="td" align="left" style="width:16%"><c:out value="${gente.apellidos}"/></div>
                <div class="td" align="left" style="width:16%"><c:out value="${gente.direccion}"/></div>
                <div class="td" align="left" style="width:16%"><c:out value="${gente.telefono}"/></div>
                <div class="td" align="left" style="width:16%">
                  <c:forEach var="ciudad" items="${formaListadoGentesOrdenar.ciudades}">
                    <c:if test="${ciudad.id == gente.idCiudad}">
                      <c:out value="${ciudad.nombre}"/>
                    </c:if>
                  </c:forEach>
                  
                </div>
                <div class="td" align="left" style="width:16%">
                    <a href='solicitarModificarGente.do?id=<c:out value="${gente.id}"/>'
					   class="HipervinculoAdmon">
                        <fmt:message key="formaListadoGentesOrdenar.etiqueta.modificar" />
                    </a>
                    <a href='procesarEliminarGente.do?id=<c:out value="${gente.id}"/>'
					   onClick="javascript: return EliminarGente('<c:out value="${gente.nombres}"/>')"
					   class="HipervinculoAdmon">
                        <fmt:message key="formaListadoGentesOrdenar.etiqueta.eliminar" />
                    </a>
                </div>
            </div>
        </c:forEach>
 
      