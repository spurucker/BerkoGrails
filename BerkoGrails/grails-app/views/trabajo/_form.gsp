<%@ page import="org.berko.business.Trabajo" %>



<div class="fieldcontain ${hasErrors(bean: trabajoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="trabajo.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${trabajoInstance?.descripcion}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trabajoInstance, field: 'fechaTrabajo', 'error')} required">
	<label for="fechaTrabajo">
		<g:message code="trabajo.fechaTrabajo.label" default="Fecha Trabajo" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaTrabajo" precision="day"  value="${trabajoInstance?.fechaTrabajo}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: trabajoInstance, field: 'tipo', 'error')} required">
	<label for="tipo">
		<g:message code="trabajo.tipo.label" default="Tipo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipo" from="${org.berko.enums.TipoTrabajo?.values()}" keys="${org.berko.enums.TipoTrabajo.values()*.name()}" required="" value="${trabajoInstance?.tipo?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: trabajoInstance, field: 'vehiculo', 'error')} required">
	<label for="vehiculo">
		<g:message code="trabajo.vehiculo.label" default="Vehiculo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vehiculo" name="vehiculo.id" from="${org.berko.business.Vehiculo.list()}" optionKey="id" required="" value="${trabajoInstance?.vehiculo?.id}" class="many-to-one"/>

</div>

