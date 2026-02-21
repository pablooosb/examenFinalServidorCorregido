<h1 align="center">REQUISITOS POR BLOQUES</h1>
<h2>Modelo de Datos</h2>
<p>Crea las siguientes entidades JPA con sus atributos correspondientes:</p>
<ul>
  <li><strong>Tripulante</strong>: id, nombre, rango (Capitán, Oficial, Recluta), licencia_estelar</li>
  <li><strong>Nave</strong>: id, nombre_nave, modelo, capacidad_pasajeros</li>
  <li><strong>Mision_Asignada (Tabla intermedia N:M):</strong></li>
  <ul>
    <li>fecha_estelar (Ejemplo: 3024.5, un número decimal cualquiera)</li>
    <li>estado_mision (ACTIVA, COMPLETADA, FALLIDA)</li>
    <li>presupuesto_mision (Double o BigDecimal)</li>
  </ul>
</ul>
<h2>Persistencia</h2>
<p>Crea los repositorios necesarios y añade estos métodos de búsqueda:</p>
<ul>
  <li><strong>Búsqueda 1</strong>: Encontrar tripulantes por su licencia_estelar</li>
  <li><strong>Búsqueda 2</strong>: Encontrar registros de Mision_Asignada según su estado_mision</li>
  <li><strong>BONUS</strong>: Crea una consulta con SQL Nativo (@Query) para calcular el presupuesto total invertido en todas las misiones de un tripulante específico</li>
</ul>

<h2>API de Servicios - REST</h2>
<p>Crea un controlador <code>@RestController</code> que incluya:</p>
<ul>
  <li><strong>CRUD Completo</strong> para la entidad Nave</li>
  <li><strong>Endpoint de Cálculo</strong>: Un método que reciba el ID de un tripulante y devuelva el total de "impuestos galácticos" pagados (calcula el 15% sobre el presupuesto total de sus misiones completadas)</li>
</ul>

<h2>Interfaz de Usuario - MVC y Thymeleaf</h2>
<p>Crea una interfaz web que permita:</p>
<ul>
  <li><strong>Listar</strong>: Mostrar todos los tripulantes en una tabla profesional</li>
  <li><strong>Registrar</strong>: Un formulario para dar de alta nuevas naves en la flota</li>
  <li><strong>El Reto Visual</strong>: Destaca (usando una clase CSS o un badge) la nave que tenga la mayor capacidad de pasajeros registrada</li>
</ul>
