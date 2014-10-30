
<%@ page import="org.berko.business.Mecanico" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mecanico.label', default: 'Mecanico')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mecanico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mecanico" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="DNI" title="${message(code: 'mecanico.DNI.label', default: 'DNI')}" />
					
						<g:sortableColumn property="apellido" title="${message(code: 'mecanico.apellido.label', default: 'Apellido')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'mecanico.nombre.label', default: 'Nombre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mecanicoInstanceList}" status="i" var="mecanicoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mecanicoInstance.id}">${fieldValue(bean: mecanicoInstance, field: "DNI")}</g:link></td>
					
						<td>${fieldValue(bean: mecanicoInstance, field: "apellido")}</td>
					
						<td>${fieldValue(bean: mecanicoInstance, field: "nombre")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mecanicoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
