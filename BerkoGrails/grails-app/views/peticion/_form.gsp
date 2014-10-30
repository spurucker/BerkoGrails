<%@ page import="org.berko.business.Peticion" %>



<div class="fieldcontain ${hasErrors(bean: peticionInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="peticion.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${peticionInstance?.descripcion}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: peticionInstance, field: 'fechaPeticion', 'error')} required">
	<label for="fechaPeticion">
		<g:message code="peticion.fechaPeticion.label" default="Fecha Peticion" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaPeticion" precision="day"  value="${peticionInstance?.fechaPeticion}"  />

</div>

