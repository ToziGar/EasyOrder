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
