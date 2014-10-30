<%@ page import="org.berko.business.Mecanico" %>



<div class="fieldcontain ${hasErrors(bean: mecanicoInstance, field: 'DNI', 'error')} required">
	<label for="DNI">
		<g:message code="mecanico.DNI.label" default="DNI" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="DNI" required="" value="${mecanicoInstance?.DNI}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mecanicoInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="mecanico.apellido.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${mecanicoInstance?.apellido}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mecanicoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="mecanico.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${mecanicoInstance?.nombre}"/>

</div>

