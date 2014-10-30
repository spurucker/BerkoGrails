
<%@ page import="org.berko.business.Trabajo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trabajo.label', default: 'Trabajo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-trabajo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-trabajo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trabajo">
			
				<g:if test="${trabajoInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="trabajo.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${trabajoInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trabajoInstance?.fechaTrabajo}">
				<li class="fieldcontain">
					<span id="fechaTrabajo-label" class="property-label"><g:message code="trabajo.fechaTrabajo.label" default="Fecha Trabajo" /></span>
					
						<span class="property-value" aria-labelledby="fechaTrabajo-label"><g:formatDate date="${trabajoInstance?.fechaTrabajo}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${trabajoInstance?.tipo}">
				<li class="fieldcontain">
					<span id="tipo-label" class="property-label"><g:message code="trabajo.tipo.label" default="Tipo" /></span>
					
						<span class="property-value" aria-labelledby="tipo-label"><g:fieldValue bean="${trabajoInstance}" field="tipo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trabajoInstance?.vehiculo}">
				<li class="fieldcontain">
					<span id="vehiculo-label" class="property-label"><g:message code="trabajo.vehiculo.label" default="Vehiculo" /></span>
					
						<span class="property-value" aria-labelledby="vehiculo-label"><g:link controller="vehiculo" action="show" id="${trabajoInstance?.vehiculo?.id}">${trabajoInstance?.vehiculo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:trabajoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${trabajoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
