
<%@ page import="org.berko.business.Trabajo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trabajo.label', default: 'Trabajo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-trabajo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-trabajo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'trabajo.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="fechaTrabajo" title="${message(code: 'trabajo.fechaTrabajo.label', default: 'Fecha Trabajo')}" />
					
						<g:sortableColumn property="tipo" title="${message(code: 'trabajo.tipo.label', default: 'Tipo')}" />
					
						<th><g:message code="trabajo.vehiculo.label" default="Vehiculo" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trabajoInstanceList}" status="i" var="trabajoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trabajoInstance.id}">${fieldValue(bean: trabajoInstance, field: "descripcion")}</g:link></td>
					
						<td><g:formatDate date="${trabajoInstance.fechaTrabajo}" /></td>
					
						<td>${fieldValue(bean: trabajoInstance, field: "tipo")}</td>
					
						<td>${fieldValue(bean: trabajoInstance, field: "vehiculo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${trabajoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
