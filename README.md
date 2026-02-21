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
  <li><strong>BONUS</strong>: Crea una consulta con SQL Nativo (<code>@Query</code>) para calcular el presupuesto total invertido en todas las misiones de un tripulante específico</li>
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

<h1 align="center">EXPLICACIÓN</h1>
<h2>Modelo de Datos</h2>
<p>Creamos las entidades y los enums correspondientes. Una vez creadas las tres entidades y los dos enums necesarios, creamos las relaciones, las cuales las dos serán <code>@OneToMany</code> (desde las entidades Tripulante y Nave) y <code>@ManyToOne</code> (desde la entidad de MisionAsignada) ya que estamos guardando información en la tabla intermedia. También le asignamos <code>@JsonIgnore</code> ya que da se repite constantemente el primer valor en cuanto hagamos una búsqueda (a mi por lo menos me dio ese fallo).</p>

<h2>Persistencia</h2>
<p>Una vez creadas las entidades con las relaciones correspondientes. Pasamos a crear los Repositories. Crearemos un <code>TripulantesRepo</code> para añadirle el método de encontrar los tripulantes según la licencia estelar. Luego crearemos también <strong>MisionAsignadaRepo</strong> donde crearemos el método de buscar los registros de la misión asignada según su estado. Y por último, también en <strong>MisionAsignadaRepo</strong> crearemos la <code>@Query</code> para calcular el presupuesto total de un tripulante concreto.</p>

<h2>API de Servicios - REST</h2>
<p>A continuación, tendremos que crear los Servicios. Para ello, yo he creado dentro de la carpeta Service otra carpeta llamada interfaces, donde tendré los interfaces, y dentro de la carpeta padre (Services) tendré los implementados. Primero crearemos el interfaz de la entidad Nave para luego crear el implementado. En estos servicios implementaremos lo básico (listar todos, listar según id, añadir, actualizar según id, y eliminar según id), para luego poder implementar el CRUD completo.</p>
<p>Una vez creado el servicio de Nave, pasamos a crear el Controller. Para ello he decidido crear uno general (ya que tenemos que asignarle al mismo Controller los CRUD de la entidad Nave y el Endpoint de MisionAsignada) y lo he llamado <strong>GeneralRestController</strong>. Aquí asignaremos el CRUD completo y añadiremos el Endpoint para calcular los impuestos galácticos según el id del tripulante. Éste lo añadiremos a MisionAsignadaRepo.</p>

<h2>Interfaz de Usuario - MVC y Thymeleaf</h2>
<p>Para acabar, MVC y Thymeleaf. Para ello necesitamos los Controller (no los anteriores, que esos son <code>@RestController</code>). Para ello crearemos una carpeta llamada web y añadiremos dentro los Controller necesarios, en este caso <strong>NaveController</strong> y <strong>TripulanteController</strong>. En el caso de Nave controller, le asignaremos el método para listar todas las naves, uno para añadir una nave y por último el que nos redirige a la lista de naves cuando acabamos de añadir una. Y en el caso de TripulanteController solo añadiremos para listar todos los tripulantes, ya que es lo que viene en los requisitos. Si quisieramos, por ejemplo, poder añadir tripulantes, tendríamos que crear los mismos métodos que en NaveController.</p>
<p>Una vez creados los <code>@Controller</code>, en la carpeta de templates que está dentro de resources, crearemos una carpeta para tripulantes y otra para naves para poder tenerlo más organizado. En la carpeta de naves crearemos un archivo <strong>index.html</strong> donde meteremos una tabla para listar todos las naves para que luego de añadir una salgan las que tenemos almacenadas, y por otro lado crearemos el <strong>form.html</strong> que será el formulario para añadir una nave nueva. Y en la carpeta de tripulantes, crearemos unicamente el <strong>index.html</strong> ya que no tenemos que añadir ningún tripulante. Crearemos la tabla donde los mostraremos y añadiremos un botón para crear una nave nueva. Yo le he añadido a cada index un botón para redirigirse al otro para que podamos acceder más fácilmente a los datos.</p>
