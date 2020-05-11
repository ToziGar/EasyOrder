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
	- El sistema modificará los datos del usuario.	Postcondiciones:
	- Se abrira una ventana con la lista de productos a elegir.	Postcondiciones:
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
	- Usuario logueado.	Precondiciones:
	- Usuario logueado.	Precondiciones:
	- Usuario logueado.
###### Postcondiciones:
	-Se abrira una ventana emergente con el total del rpecio de los productos elegidos.	Postcondiciones:
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
	1. Error de conexión. El sistema indicará al usuario que hay un error de conexión con el servidor.
###### C.U.10 Ver los pedidos realizados	C.U.11 Gestionar usuarios	C.U.12  Gestionar productos
###### Precondiciones:
	- Usuario logueado
	-  Tener permisos como Usuario Camarero:
	- Usuario logueado.
	- Tener las credenciales 	
	- Usuario logueado
	-  Tener permisos como Usuario Administrador
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
	-  Tener permisos como Usuario Administrador	Precondiciones:
	- Usuario logueado
	-  Tener permisos como Usuario Camarero
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
