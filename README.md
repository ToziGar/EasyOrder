# CAMPUS FP GIJÓN

#### Ciclo Formativo de Grado Superior
#### Desarrollo de Aplicaciones Multiplataforma

# EasyOrder

###### PROYECTO DE DESARROLLO DE APLICACIONES MULTIPLATAFORMA
###### Autor:  Luis García Menéndez
###### Tutor: Luis De Blas Blázquez
###### Junio de 2019

## Tabla de contenido
#### 2	CONTENIDO
###### 2.1	Resumen
###### 2.2	Justificación del Proyecto
###### 2.3	Estudio de Viabilidad
###### 2.3.1	Descripción
###### 2.3.2	DAFO
###### 2.3.3	Estado del Arte
###### 2.4	Desarrollo
###### 2.4.1	Fundamentación teórica
###### 2.4.2	Materiales y métodos
###### 2.4.3	Resultados y análisis
#### 3	Gestión de proyecto
###### 3.1 Gestión del proyecto y temporalización
###### 3.2 Costes
###### 3.3 Marketing y comercialización
###### 3.3.1 Segmentación del mercado
###### 3.3.2 Estrategia de producto
###### 3.3.3 Estrategia de precio
###### 3.3.4 Estrategia de distribución
###### 3.3.5 Estrategias de promoción
#### 4	Conclusiones
###### 4.1	Trabajo realizado
###### 4.2	Valoración personal
#### 5	Líneas de investigación futuras
#### 6	Webgrafía

### 2	CONTENIDO
#### 2.1	Resumen
La Idea De Este Proyecto Es Realizar Una AplicacióN Android En La Cual Se Realiza Un Control De Los Pedidos Y Stock De Un Bar O Restaurante A TravéS Una AplicacióN Movil Para La Comodidad De Nuestros Clientes.
#### 2.2	Justificación del Proyecto
Uno de los mayores problemas actualmente en el sector de los bares/restaurantes es la cantidad de gente que puede llegar a querer realizar un pedido al mismo tiempo de forma que deberá formar una cola de espera para obtener su pedido.
la finalidad de este proyecto es optimizar este proceso de manera que al usuario le resulte más cómodo y efectivo realizar los pedidos que desea, facilitando la mayor simplicidad posible.

para ello el usuario tendrá la posibilidad de obtener una aplicación con una interfaz gráfica en la cual se podrán registrar y acceder a la carta de productos y realizar un pedido rapidamente desde nuestra aplicación.

el camarero no tiene necesidad de perder tiempo en la mesa que usa la aplicación, el pedido llega directamente a la cocina.

también se tendrá un stock controlado de la cantidad de productos que quedan en el restaurante para no sobrepasar la cantidad disponible.

### Objetivos
Para lograr las metas fijadas en el desarrollo del proyecto, se han planteado los siguientes objetivos de trabajo:

### Objetivo general:
Diseño e implementación de la aplicación, a través de ella deseamos prestar un servicio que funcione de forma correcta en el cual se cumplan plenamente las necesidades de nuestros clientes y una descarga de trabajo a los camareros.

### Objetivo específico:
Control de los pedidos para las comandas.

### 2.3	Estudio de Viabilidad
#### 2.3.1	Descripción

Analizando las necesidades que comentamos previamente en la justificación del proyecto, el objetivo es desarrollar una aplicación Android que facilite al usuario la realización de pedidos desde su dispositivo móvil. Para ello, realizaremos una aplicación que en primer lugar tendrá una primera pantalla de registro y login, despues aparecerá la ventana de ayuda par aprender a usar la aplicación. 

En la aplicación tendremos la capacidad desplazarnos por menús que separaran los productos, las opciones del camarero y la administración del propietario

Una vez que el usuario haya elegido los productos deseados deberá elegir la mesa para finalizar el pedido.

Una vez realizado este procedimiento, accederemos a otra de las interfaces de nuestra aplicación en la que se mostrarán tanto los datos del pedido como la facturación del mismo.

El camarero podrá ver todas las ordenes que demandan nuestros clientes con sus productos escogidos y podrá ver y cambiar la cantidad de stock de los productos.

El administrador podrá eliminar y modificar cualquier producto.
#### 2.3.2	DAFO
##### FACTORES INTERNOS	FACTORES EXTERNOS
###### FORTALEZAS
Ser de los primeros en establecerse dentro de locales.
Mejora de la calidad de servicio al cliente.
Ahorro de colas.
Ahorro de personal.	

###### OPORTUNIDADES
Adaptación para el uso cotidiano de las personas.
Crecimiento a nivel nacional para ser implementado en más locales.

###### DEBILIDADES
Tiempo de realización del proyecto.
Sin disponibilidad de recursos financieros.
Bajo nivel de idiomas para su traducción.
Poco conocimiento de marketing.
######	AMENAZAS

Posibilidad de las empresas realicen la aplicación.
Probablemente no apta para todos los públicos.
Cantidad de uso dentro del establecimiento.

### 2.3.3 Estado del Arte
Al igual que mi aplicación, existen otras aplicaciones que realizan estos procesos a la hora de solicitar pedidos:


###### Glovo: 
Es una aplicación desde la que puedes solicitar casi cualquier tipo de producto a domicilio ya sea un supermercado, restaurante o incluso que no esté en su selección y le describas al repartidor a donde ir exactamente.

###### Just Eat:
Esta aplicación tiene una gran cantidad de restaurantes desde la que podremos solicitar comida a domicilio pero solo los que permite la aplicación.

###### BugerKing: 
La aplicación contiene varios tipos de productos con descuentos aplicables, los kioskos que existen dentro de estos establecimientos nos permiten realizar escaneos de QR con los que se aplican descuentos y hacer una selección de productos.

###### Deliveroo: 
Entregas de menos de media hora y ciclistas repartidores. Su punto fuerte, además, es la propia aplicación. Sin duda estamos ante la mejor app, muy por encima de las demás por su precioso diseño. En cuanto a opciones, y aunque supera las alternativas, sigue estando por detrás de Just Eat.

###### PedidosYa:
Permite encontrar restaurantes con delivery y realizar pedidos de comida en línea a través de su sitio web y apps para iOS y Android con gran variedad de opciones gastronómicas y facilidad de medios de pago. El servicio de PedidosYa es de uso gratuito y el pedido se realiza de manera fácil, simple y práctica. Cuenta con más de 1 millón de platos disponibles para ordenar y solo está disponible en países sudamericanos.

### 2.4	Desarrollo
#### 2.4.1	Fundamentación teórica
### REQUISITOS FUNCIONALES
###### RF1	
	A la hora de crear una contraseña deberá cumplir unos requisitos mínimos de seguridad.
###### RF2	
	Una vez se realice una conexión de un usuario se le indicara con que cuenta está conectado.
###### RF3
	El sistema tendrá un número ilimitado de veces para introducir la contraseña correcta sin penalización.
###### RF4	
	El programa contará con un menú que aparecerá en la parte lateral izquierdo de laaplicación.
###### RF5	
	Se mostrará una lista que contará con imágenes e información de los productos.
###### RF6	
	Se permitirá la selección de productos para realizar un pedido.
###### RF7	
	El sistema dará mensajes de error que sean informativos y orientados al usuario final.
###### RF8	
	Se permitirá que el usuario edite la información de su cuenta.
###### RF9	
	Se permitirá meter la mesa por escrito.
###### RF10	
	Se permitirá editar y eliminar productos.
###### RF11	
	Se permitira incrementar o decrementar el stock delos productos.
###### RF12	
	Se permitira incrementar o decrementar la cantidad de los productos seleccionados.


### REQUISITOS DE INTERFAZ DE USUARIO
###### RIU1	
	El sistema validara automáticamente el cliente para permitir su acceso.
###### RIU2	
	Tendrá un diseño simple y minimalista.
###### RIU3	
	Toda la aplicación tendrá como colores principales el morado y el azul.
###### RIU4	
	Tendrá una splash activity con el logo y nombre de la aplicación.
###### RIU5	
	La tipografía de las letras sera por defecto.



### REQUISITOS DE SISTEMA
###### RSis1	
	El sistema operativo de la aplicación será Android.
###### RSis2	
	El sistema controlará el acceso y lo permitirá solamente a usuarios autorizados.
###### RSis3	
	El sistema identificará usuarios con permisos y usuarios sin permisos.
###### RSis4	
	El SGBD utilizado será SQlite que es una base de datos en local.
### REQUISITOS DE SEGURIDAD
###### RSeg1
	Los permisos de acceso al sistema podrán ser cambiados solamente por el administrador.
###### RSeg2
	El sistema controlará el acceso y lo permitirá solamente a usuarios autorizados. Los usuarios debeningresar al sistema con un email y contraseña.
###### RSeg3
	Solo los usuarios conocidos como administradores tendrán acceso al menu completo.
###### RSeg4
	Los usuarios conocidos como camareros tendrán acceso al apartado de ordenes y la edición de stock.
### Diagrama de casos de uso 
#### Análisis
###### C.U.1. Registrar 	C.U.2. Login 	C.U.3. Cerrar sesión
###### Precondiciones:
	- Precondiciones.
	- Usuario ya registrado.
	- Usuario logueado.
###### Postcondiciones:
	- Guardar el nuevo usuario en la base de datos.	
	- Usuario inicia sesión en la aplicación.
	- Se cierra la sesión del usuario en la aplicación.
###### Acciones:
	 Al arrancar la aplicación el usuario estará en la pantalla de registro.
	 El usuario introducirá sus datos en cada uno de los campos de texto de la pantalla.
	 El usuario pulsará el botón de registro.
	 El sistema comprobará que no existe el usuario en la base de datos.
	 El sistema comprobará que la contraseña cumple el patrón.
	 El sistema comprobará que el correo cumple el patrón.
	 El sistema registrará el usuario en la base datos.
	 El sistema redirigirá al usuario a la pantalla de inicio con la sesión iniciada. 
	 El usuario accederá a la pantalla de Inicio de sesión.
	 El usuario introducirá sus datos de inicio de sesión en cada uno de los campos de texto de la pantalla.
	 El usuario pulsará el botón de login.
	 El sistema comprobará que el usuario existe.
	 El sistema comprobará que la contraseñaintroducida concuerde con la contraseña de dicho usuario.
	 El sistema iniciará la sesión del usuario.
	 El sistema redirigirá al usuario a la pantalla de inicio con la sesión iniciada.
	 El usuario se dirigirá a la pantalla de perfil.
	 El usuario pulsará la opción de cerrar sesión que aparece en la pantalla.
	 Se cerrará sesión.
###### Excepciones:
	 Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.
	 Usuario ya existe en la base de datos. El sistema limpiará los campos de inserción.
	 Contraseña no válida. El sistema limpiará el campo de inserción de contraseña y se indicará al usuario que la contraseña no es válida y que debe contener para que si lo sea.
	 Correo no válido. El sistema limpiará campo de inserción de correo y se indicará al usuario que el correo no es válido.	Excepciones:
	 Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.
	 Usuario incorrecto. El sistema indicará al usuario que los datos introducidos son incorrectos.
	 Contraseña incorrecta. El sistema indicará al usuario que los datos introducidos son incorrectos.
	 Error al cerrar sesión. El sistema indicará al usuario que no se podrá realizar la tarea en ese momento.

###### C.U.4. Modificar perfil C.U.5.  Ver lista de productos C.U.6 Seleccionar mesa del pedido
######  Precondiciones.
	- Usuario logueado.	
	- Usuario logueado.	
	- Usuario logueado.
###### Postcondiciones:
	- El sistema modificará los datos del usuario.
	- Se abrira una ventana con la lista de productos a elegir.
	- Se abrirá una ventana emergente para escribir la mesa en la que estamos sentados.
###### Acciones:
	 El usuario accederá al menú lateral.
	 El usuario pulsará el botón de “Perfil”.
	 El sistema redirigirá al usuario a una nueva ventana de modificación de usuario donde se mostrará su información.
	 El usuario modificará los datos.. El usuario pulsará el botón de guardar.
	 El sistema comprobará que los datos modificados son correctos.
	 El sistema tomará los datos introducidos por el usuario.
	 El sistema comprobará que los nuevos datos son correctos.
	 Se actualiza usuario en la base de datos.
	 El usuario accederá al menú lateral.
	 El usuario pulsará el botón de “Nuevo pedido”
	 El usuario seleccionaralos productos que desea. 
	 El sistema notificará con un fondo verde que escogio ese articulo y la cantidad de veces.
	 El usuario accederá al menú lateral.
	 El usuario pulsará el botón de “Nuevo pedido”
	 El usuario seleccionaralos productos que desea. 
	 El sistema notificará con un fondo verde que escogio ese articulo y la cantidad de veces.
	 El usuario pulsará en el boton flotante para acabar su pedido eligiendo en que mesa está.
###### Excepciones:
	 Correo no válido. El sistema indicará al usuario que el nuevo correo no es válido.
	 Contraseña no válida. El sistema indicará al usuario que la nueva contraseña no es válida.
	 Error de conexión. El sistema indicará al usuario que en ese momento no se podrá realizar dicha función.
	 Error de conexión. El sistema indicará al usuario que en ese momento no se podrá realizar dicha función.
	 Error de confirmación del pedido. El sistema indicará al usuario que en ese momento no se podrá realizar unpedido.
	 Error. El sistema indicará al usuario que en ese momento no se podrá realizar dicha función.
	 Error. El sistema avisara de que no queda stock suficiente de ese producto.

###### C.U.7 Ver el precio total de los productos	C.U.8Realizar pedido	C.U.9 Ventana de ayuda

###### Precondiciones:
	- Usuario logueado.	
	- Usuario logueado.	
	- Usuario logueado.
###### Postcondiciones:
	- Se abrira una ventana emergente con el total del rpecio de los productos elegidos.	Postcondiciones:
	- Se realizará la comanda.	Postcondiciones:
	- Se abrira una ventana con lainformación del la aplicación y lo que encontraremos dentro dependiendo del tipo de usuario que seamos.
###### Acciones
	El usuario accederá al menú lateral.
	El usuario pulsará el botón de “Nuevo pedido”
	El usuario seleccionaralos productos que desea. 
	El sistema notificará con un fondo verde que escogió ese articulo y la cantidad de veces.
	El usuario le dará al boton de información de arriba a la derecha para ver el precio total del pedido.
	El usuario accederá al menú lateral.
	El usuario pulsará el botón de “Nuevo pedido”
	El usuario seleccionará los productos que desea. 
	El sistema notificará con un fondo verde que escogio ese articulo y la cantidad de veces.
	El usuario pulsara el boton inferior derecho para confirmar su pedido.
	EL usuario escribirá la mesa en la que está posicionado.
	La comanda se realizará con éxito.
	El usuario se encontrara esta ventana cuando acceda por primera vez a la aplicación.
	Podrá entrar siempre que quiera desde el menú lateral.

###### Excepciones:
	 - Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.
###### C.U.10 Ver los pedidos realizados	C.U.11 Gestionar usuarios	C.U.12  Gestionar productos
###### Precondiciones:
	- Usuario logueado
	- Tener permisos como Usuario Camarero:
	- Usuario logueado.
	- Tener las credenciales 	
	- Usuario logueado
	- Tener permisos como Usuario Administrador
###### Postcondiciones:
	- Se abrirá una ventana con la información del pedido que han realizado.	Postcondiciones:
	- Se abrirá una ventana con las listas de los productos.	Postcondiciones:
	- Se abrirá una ventana con la lista de productos.
###### Acciones:
	El usuario  camarero accederá al menú lateral.
	El usuario solo tendrá la elección de un boton del menu lateral llamado “Lista de pedidos”.
	El usuario podrá visualizar la mesa en la que se encuentra el cliente, el precio y la hora.
	Pulsando sobre un pedido desplegara la información de la comanda. 	Acciones:
	El usuario  camarero accederá al menú lateral.
	El usuario solo tendrá la elección de un boton del menu lateral “Gestionar usuarios”.
	Pulsando sobre un usuario nos desplegara una ventana emergente para el tipo de usuario.	
	El administrador accederá al menú lateral.
	El administrador pulsará el botón de “Editar productos”
	El administrador podrá modificar o eliminar productos pulsando sobre ellos.

###### Excepciones:
	Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.	Excepciones:
	Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.	Excepciones:
	Error de conexión. El sistema indicará al administrador que hay un error de conexión con el servidor.

###### C.U.13 Ajustes de la aplicación	C.U.14 Stock de los productos
###### Precondiciones:
	- Usuario logueado
	- Tener permisos como Usuario Administrador	Precondiciones:
	- Usuario logueado
	- Tener permisos como Usuario Camarero
###### Postcondiciones:
	- Se abrirá una ventana con ajustes de la aplicación.	Postcondiciones:
	- Se abrirá una ventana con la información del stock de los productos.
###### Acciones:
	El administrador accederá al menú lateral.
	El administrador pulsará el botón de “Ajustes”
	El administrador podrácambiar el nombre , el correo y la foto del banner.
	El administrador podrá eliminar todos los productos o pedidos .
	El usuario  camarero accederá al menú lateral.
	El usuario solo tendrá la elección de un boton del menu lateral llamado “Stock de los productos”.
	El camarero  podrá visualizar la cantidad de stock que hay y podrá incrementar o decrementar. 
###### Excepciones:
	Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.	Excepciones:
	Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.
### Esquema de la base de datos.

###### Usuarios: Tabla formada por un identificador único, el email, password y el tipo de usuario.

	ID(Int): Identificador unico por cada usuario, no pueden existir dos iguales.
	Email(string): Correo electrónico del usuario, se utilizará para conectarse.
	Password(string):Contraseña de la cuenta para poder acceder.
	Tipo(string):Identificador para determinar el tipo de usuario.


###### Pedidos: Tabla formada por la fecha y hora, el precio, el numero de mesa y el nombre de los productos.

	Nombre producto(String): El nombre del producto que tengamos.
	Fecha_hora(Date): Registrara la hora y el día a la que se realiza un pedido.
	Número de mesa (Int): Indicará en que mesa está el usuario que realiza un pedido.
	Precio(real): Indicará el coste del producto con decimales.


###### Pedidos: Tabla formada por un identificador único, nombre del producto, precio, imagen, hasimage e imagenuri.

##### ID(Int): Identificador unico por cada usuario, no pueden existir dos iguales.
	Nombre completo(string): Indicara como se llamara el producto.
	Precio(real): Indicará el coste del producto con decimales.
	Imagen(Integer): Se guardara la imagen que irá acorde con el producto.
	Imagen has(Integer): Guardara el código binario de la imagen que irá acorde con el producto.
	imageUri(String): Indicara donde se encuentra esa imagen.

### Implementación de la aplicación:
###### SplashActivity:
Es la actividad que mostrara el logo al inicio de la aplicación.

###### RecyclerItemClickListener: 
Es el que se encargara de detectar cuando pulsamos sobre un elemento en las listas de la aplicación y nos servirá para todos los recyclerview de la aplicación.

###### RegistroActivity: 
Es la actividad que nos permitirá crear una nueva cuenta de usuario para poder utilizar nuestra aplicación.
###### Login Activity:
Es la actividad que nos permitirá entrar en una cuenta de usuario que fuera creada posteriormente.
###### Lista Activity: 
Es una actividad a la que solo podremos acceder con un usuario y clave muy concretos, esta actividad nos mostrara los usuarios que existen para poder cambiarles el rol de usuario.
###### Main Activity: 
Es la actividad principal en la que tendremos el menú de navegación y llamara a distintos fragmentos, también hay que destacar que depende el tipo de usuario que esté conectado se verá de forma distinta.
###### Ayuda Fragment:  
Es el primer fragmento que mostrará la aplicación,  esta ventana enseñará a nuestro usuario a utilizar la aplicación con descripciones muy básicas.
ConfiguraciónActivity: Es la actividad en la que podremos modificar nuestro correo electrónico del usuario.
###### ProductosItemFragment:
Es el fragment desde el que se verá una lista de productos que podremos seleccionar para hacer un pedido.

###### ProductosRecyclerViewAdapter:
Es un adaptador del anterior fragment que se utiliza para obtener la lista de productos, su posición, sus imágenes, nombres, precio, se recogerá de la base de datos.

###### IntroduceCantidadDialog: 
Es una ventana emergente que saldrá al mantener presionado un producto para poder escoger una cantidad concreta a la hora de pedir.

###### MesaDialog:
Es una ventana emergente que saldrá al escoger los productos para introducir número de mesa y confirmar el pedido.

###### CuadroImagenView:  
Es el que se encarga de coger el espacio de la foto en el menú desplegable.

###### PedidosItemFragment:
Es el fragment desde el que se verá una lista de pedidos.

###### PedidosItemRecyclerViewAdapter:  
Es un adaptador del anterior fragment que se utiliza para obtener la lista de pedidos, su posición, y que al ser pulsado se obtiene los productos de ese pedido.

###### EditarStockDialog:
Es la clase que permite el dialog emergente para establecer una cantidad incrementada, decrementada o sin stock.

###### ProductosSotckItemFragment: 
Es la clase que permite visualizar el recycledview y recoge las posiciones para editar el producto correcto.

###### ProductosSotckItemRecyclerViewAdapter: 
Es el adaptador que contiene la vista de los productos como imágenes, nombre, cantidad y el escuchador al ser pulsado.

###### CrearProductoDialog: 
Es la clase que permite el dialog emergente para crear un nuevo producto añadiendo su imagen, nombre, precio y cantidad.

###### EditarProductoActivity: 
Es la clase que permite que entremos dentro de un producto concreto y podamos editar su nombre su precio, guardar los cambios o eliminar el producto

###### EditarProductoItemFragment:
Es la clase que permite que visualicemos los productos y tengamos el escuchador al ser pulsado para llevarnos al que queremos.

###### EditarProductoItemRecyclerViewAdapter: 
Es el adaptador que contiene la vista de los productos como imágenes, nombre, cantidad y el escuchador al ser pulsado para llevarnos a la actividad con los datos de ese producto para ser editado.

###### DBManager:  
Es la clase que contiene la base de datos con sus tablas correspondientes y sus clases para insertar, actualizar, eliminar, obtener todo, obtener ordenado por día  , resetear tablas.etc

###### DishesContainer: 
Es la clase que contiene la lista de todos los productos que será llamada cuando sea necesario mostrarlos, también contiene la inserción de los datos, y un método para obtener la lista de productos.

###### OrderContainer: 
Es la clase que contiene la lista de todos los pedidos que será llamada cuando sea necesario mostrarlos, no existe ninguna inserción así que deberemos crear un pedido primero.

###### UsuarioDBHelper: 
Es la clase que contiene la creación de la tabla de usuarios y un método para obtenerlos para la ListaActivity

###### UsuariosContract: 
Es la clase que la base de datos de los usuarios como el tipo de columnas.
### 2.4.2	Materiales y métodos

Para la realización de este proyecto vamos a utilizar Android Studio para programar en la aplicación movil integrando una base de datos SQlite que estará en el local dentro del movil, se ha programado en lenguaje java yse utilizarán librerías externas como por ejemplo: CardView Y RecycledView

###### CardView:
Es una librería que nos permite realizar una especie de tarjeta/carta que se utilizará en varias ocasiones.

###### RecycledView: 
Un RecyclerView es un contenedor de elementos en forma de lista al igual que la clase ListView. Aunque ambos tienen la misma función, este nuevo elemento permite “reciclar” los ítems que ya no son visibles por el usuario debido al scrolling. Por lo que es ideal para proyectos que manejan grandes volúmenes de ítems que se actualizan constantemente, limitando la visibilidad de elementos.


#### 2.4.3	Resultados y análisis
### 3	Gestión de proyecto

#### 3.1 Gestión del proyecto y temporalización

Para medir la temporalización he decidido trabajar desde que han empezado las prácticas, es decir desde el día 8 de abril.

Todos los lunes a jueves de cada semana he trabajado desde las 6 hasta las 9 y de 22:30 a 00:00, que hasta el día 7 de la entrega hacen 36 días que corresponden a un total de 198 horas.

He decidido este horario para organizarme y para tener días de descanso para no saturarme debido a que antes de realizar esas 5 horas y media realizo practicas durante 8 horas.

#### 3.2 Costes

Con 3.000€ crearé la empresa, Sociedad Limitada Unipersonal Nueva Empresa (SLUNE), al estar bajo esta forma jurídica el coste de creación de nuestra empresa es de 250€.

Creación de la empresa 					250€
Creación de cuenta de Google Play como desarrollador	25€ de por vida

Solicitud de marca o nombre comercial de clase 1		125,36 €/ anual

Vodafone One Profesional Fibra 100Mb S			29,75€/Mensual

Cowork colectivo (Comunidad, Limpieza, 
Mobiliario, Electricidad, Internet, Impresora Compartida	30€/Mensual	

Plan básico de gestoría para autónomos			29,99€/Mensual

###### COSTE EN EL PRIMER MES:
Costes fijos (Empresa, Logo y Google Play) =            304.75€
Costes mensuales (Vodafone, Cowork, Asesoria) = 149,74€
Costes totales:                                                                454,49€

###### COSTE ANUAL
Coste mensual   149,74€
coste de 12 meses
Coste total de 1.796,88 €
3.3 Marketing y comercialización
3.3.1 Segmentación del mercado

Para que nuestro proyecto sea viable no podemos plantearnos venderle a
todo el mundo todos los productos/servicios, tenemos que especializarnos y
centrarnos en algunos clientes y algunos productos en concreto, bares y restaurantes enfocados a un público joven
#### 3.3.2 Estrategia de producto

Mi proyecto está formado por una aplicación móvil que permite al usuario realizar pedidos instantáneos. Por el momento, únicamente está hecha para un solo restaurante.
Cada restaurante que utilice la aplicación la puede personalizar con su carta y su logo.

Ahora que sabemos las debilidades que tienen las aplicaciones similares que existen, podremos enfrentarnos a ellas consiguiendo así, una mejor accesibilidad y manejo sin importar el rango de edad del público.
#### 3.3.3 Estrategia de precio

###### Estrategias de precios de penetración 

Consiste en fijar un precio inicial bajo para conseguir una penetración de mercado rápida y eficaz, es decir, para atraer rápidamente a un gran número de consumidores. 

Esto permitirá que muchos establecimientos sean invitados a probar a tener nuestra app sin miedo al rechazo, pero a cambio nos llevaremos un porcentaje de pedidos realizados desde la APP.

#### 3.3.4 Estrategia de distribución

Cada vez hay más aplicaciones para dispositivos móviles, lo que provoca que existamás competencia de apps. La app que de momento esta teniendo mas existo dentro de nuestro sector es Glovo y Just Eat. En este apartado, podemos encontrar múltiples soluciones, cada una utiliza una forma para establecer el ranking de aplicaciones como pueden ser la popularidad, cobertura de losmedios de comunicación, opiniones de los usuarios, etc.
Play Store de Google, la cual es la forma tradicional y más común, pero no sólo por ello conseguiremos llegar al público objetivo, combinándola con otras webs populares de descarga de aplicaciones que nos permitiría ser más visibles y aumentar las descargas.
#### 3.3.5 Estrategias de promoción

La aplicación está diseñada y enfocada únicamente para jovenes que quieran realizar pedidos desde su movil en este restaurante. Por lo tanto, una forma de promocionarse sería en redes sociales con el objetivo de ser más visibles a ojos de la población más joven, realizar una publicación comentando nuestro producto, creando cuentas en varias redes sociales como son Instagram, Facebook y Twitter en las que se realizarían publicaciones exponiendo las ventajas de nuestra aplicación y, así, aumentar el alcance de la aplicación.

Por último, para el rango de la población que no utiliza las redes sociales de forma regular añadiremos anuncios de google en paginas web.





### 4	Conclusiones

#### 4.1	Trabajo realizado

El trabajo que he realizado es el proyecto completo ya que no se encuentran más personas en él.

#### 4.2	Valoración personal

Este trabajo a nivel personal me ha hecho aprender a realizar busquedas de nuevos métodos para implementar a mi aplicación y a resolver errores que nunca habia tenido anteriormente, la experiencia de crear una aplicación entera es muy placentera sin embargo conlleva mucho tiempo y preparación para realizarla.

Ha sido muy productivo de cara al futuro ya que nadie estara ahí para nosotros en el futuro y buscarnos la vida apoyandonos de internet será mi día a día y gracias a este proyecto puedo aprender como se realiza un trabajo desde cero.
### 5	Líneas de investigación futuras

Atender a varios establecimientos desde una misma aplicación.
Crear sistema de cupones de descuento.
Crear sistema de comida gratuita al utilizar la aplicacion una cantidad determinada de veces.
### 6	Webgrafía

	Oficina de patentes y marcas (https://bit.ly/2TQumWq) último acceso 1/03/2019
	Tarifa de Vodafone (https://bit.ly/2BFscli) último acceso 11/03/2019
	Gestoría de autónomos (https://bit.ly/2NeDH7Z) último acceso 11/03/2019
	Estrategia de precios (https://bit.ly/2khlCLe) último acceso 11/03/2019
	Estrategia de productos (https://bit.ly/2E42U0R) último acceso 09/03/2019
	Estrategia de distribución (https://bit.ly/2Tbp2zP)último acceso 09/03/2019
	Glovo (https://glovoapp.com/es/faq) último acceso 06/05/2019
	Just Eat (https://es.wikipedia.org/wiki/Just_Eat) último acceso 06/05/2019
	Burger King (https://bit.ly/2ZdkbxA) último acceso 06/05/2019
	PedidosYa (https://es.wikipedia.org/wiki/PedidosYa) último acceso 06/05/2019

