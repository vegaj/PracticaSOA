# Practica SOA. Ingeniería Web 2018/2019.

## Requisitos

Para realizar el servidor SOA, necesitaremos tener instalados:
* __JDK 8__ para poder realizar el proyecto que usa JavaEE.
* __Glassfish 4.1__, esa versión exactamente.
* __Netbeans 8.2__, versión _Java EE_ (importante) como IDE.

## Instalación del entorno
Tanto Netbeans como el JDK son un .exe, se instala fácil. Comenzamos instalando el JDK 8 y, posteriormente Netbeans.
_NOTA: no usar JDK 9 o superior, pues Netbeans dejará de funcionar._

### Glassfish 4.1

Como Netbeans trae Glassfish 4.1.1, lo primero que tendremos que hacer es instalar Glassfish(__gf__) 4.1 en cualquier carpeta, la vamos a llamar _<gf-inst>_.

A continuación abrimos Netbeans (__nb__) y vamos a la pestaña __servicios__ y añadimos un __nuevo servidor__.
Nos aseguramos de que en la ventana que aparece, tengamos marcado *local_domain* y en _browse_ buscamos el directorio _<gf-inst>_.
Le ponemos el nombre que queramos, en nuestro caso, vamos a llamarlo _GlassFish 4.1. Server_. Al hacer click en __siguiente__, damos a __finalizar__ porque vamos a utilizar la configuración por defecto.

### Base de datos
Vamos a utilizar la que viene por defecto, es decir __Derby__. Para crear una nueva, vamos a _Services_ > _Databases_ y hacemos click derecho en _Java DB_ > _Create database_.

_Importante: la configuración de la base de datos que vamos a usar para el proyecto es la siguiente:_
* __Database Name__: _iweb_
* __User Name__: _iweb_
* __Password__: _iweb_
Damos a siguiente y se nos habrá creado.

## Conectar GlassFish a la base de datos
Iniciamos el servicio de gf. Cuando esté encendido, vamos a la ventana de configuración del administrador (puerto 4848 en localhost, por defecto).

El primer paso será crear la _pool de conexiones_ a la base de datos iweb que hemos creado.

Una vez en la consola, vamos a _Resources_ > _JDBC_ > _JDBC Connection Pools_ > __New...__

Le damos el nombre __iwebPool__ y elegimos __javax.sql.DataSource__, con vendedor __Derby-30__.

A continuación, en _Additional Properties_:
* __User__: _iweb_
* __Password__: _iweb_ 
* __Database Name__: _iweb_
Eliminamos los campos que no hemos rellenado y damos en _save_.

El siguiente paso, será crear un nuevo _JDBC Resource_ en la misma ruta que la Pool. Lo crearemos con el __JNDI Name__: _jdbc/iweb_, con la Pool que creamos antes (__iwebPool__). Click OK.

Reiniciamos el servidor y comprobamos que todo se ha creado correctamente.

## Clonamos el Repositorio.

El siguiente paso será clonar este repositorio en algún lugar en tu máquina.
Vamos a suponer que sabes hacerlo, por ahora.

## Cómo hemos hecho el repositorio.
Si en algún momento, necesitas saber cómo se configuró el repositorio, lee este apartado, sino, clónalo.


###Modelo de datos
1. __Creamos el proyecto__: _NetBeans_ > _New Project_ > _Java EE_ > _EJB Module_. Lo hemos llamado __ServidorSOA__.

2. __Ejecutamos el script__ *build_db.sql* (este script sólo funciona para bases de datos _Derby sql_). Para ello, en la pestaña de _Servicios_ usamos la conexión de Derby __iweb__ que se creó anteriormente y en ella __Ejecutamos comando__, pegamos el script y lo corremos.
_NOTA: es posible que aparezca un error debido a que se hayan intentado eliminar tablas que no existían si es la primera vez que lo ejecutas._

3. __Creamos en Nb el recurso__: Para ello, click derecho en el proyecto, _New_ > _GlassFish_ > _JDBC resource_. Ahora debemos de utilizar el nombre que usamos al crearlo en la consola de administrador, en los pasos anteriores.
    * __Create New JDBC Connection Pool__: Marcado
    * __JNDI Name__: _jdbc/iweb_.

    Lo demás, por defecto. _Siguiente_.
Cuando nos pidan el __JDBC Connection Pool Name__ nos aseguramos de poner _iwebPool_ en concordancia. Lo extraemos de la conexión [derby iweb on IWEB]. En el siguiente paso, comprobaremos que los datos son correctos y finalizamos.

4. En _ServidorSOA_ > _Configuration Files_ > _META-INF_ > _glassfish-resources.xml_ debe de contener algo tal que así:
```xml
<resources>
  <jdbc-resource enabled="true" jndi-name="jdbc/iweb" object-type="user" pool-name="iwebPool">
    <description/>
  </jdbc-resource>
  <jdbc-connection-pool allow-non-component-callers="false" associate-with-thread="false" connection-creation-retry-attempts="0" connection-creation-retry-interval-in-seconds="10" connection-leak-reclaim="false" connection-leak-timeout-in-seconds="0" connection-validation-method="auto-commit" datasource-classname="org.apache.derby.jdbc.ClientDataSource" fail-all-connections="false" idle-timeout-in-seconds="300" is-connection-validation-required="false" is-isolation-level-guaranteed="true" lazy-connection-association="false" lazy-connection-enlistment="false" match-connections="false" max-connection-usage-count="0" max-pool-size="32" max-wait-time-in-millis="60000" name="iwebPool" non-transactional-connections="false" pool-resize-quantity="2" res-type="javax.sql.DataSource" statement-timeout-in-seconds="-1" steady-pool-size="8" validate-atmost-once-period-in-seconds="0" wrap-jdbc-objects="false">
    <property name="URL" value="jdbc:derby://localhost:1527/iweb"/>
    <property name="serverName" value="localhost"/>
    <property name="PortNumber" value="1527"/>
    <property name="DatabaseName" value="iweb"/>
    <property name="User" value="iweb"/>
    <property name="Password" value="iweb"/>
  </jdbc-connection-pool>
</resources>

```

5. Una vez tenemos la base de datos con las tablas con las que vamos a trabajar, vamos al proyecto, botón derecho en _Entity classes from Database_ con las tablas que queramos que tenga el proyecto, en este caso __Vinieta__ y __Serie__. Lo crearemos en el paquete jpa y utilizaremos la conexión que se habrá creado. Nos aseguramos de que se cree una __persistency unit__.
_NOTA: **Entity classes from Database** se encuentra en la carpeta **persistence**_.

6. __Arreglar la Persistency Unit__. En el directorio de configuración, encontraremos __persistence.xml__ que fue creado en el paso anterior, es posible que se genere mal. Para ello, editamos el xml de modo que pase de contener 
  `<jta-data-source>java:app:jdbc/iweb</jta-data-source>` a
  `<jta-data-source>jdbc/iweb</jta-data-source>`

###Configuración del SOA.

1. En el proyecto, _New_ > _Enterprise JavaBeans_ > _Session Beans for Entity Classes_. Añadimos todas las anteriores y creamos el paquete _session_.

2. A continuación, creamos un servicio a partir de los beans anteriores. Por lo tanto, _New_ > _Web Services_ > _Web Service_. Crearemos dos, uno que será de Series y otro de Viñetas. Los llamaremos __SeriesWS__ y __VinietasWS__, ambos en el paquete _ws_. Los crearemos desde los _Session Beans_ anteriores usando el __Facade__ correspondiente.

## Desplegar el proyecto.

Si tuviésemos varias versiones de _gf_, tendríamos que elegir la versión que hemos configurado, para ello, vamos al proyecto, botón derecho: _properties_ > _run_ y en __Server__ elegimos _Glassfish 4.1 Server_.

Finalmente, vamos a comprobar que, a priori, todo funciona como se espera.
Realizamos un __Clean And Build__ en el proyecto y, posteriormente, un __Deploy__. 

Navegamos a _ServidorSOA_ > _Web Services_ > _VinietasWS_, Botón derecho en __Test Web Service__. Ahora, podemos hacer click en el método count y asegurarnos de que responde un número y no una excepción. 

![](https://rlv.zcache.com/works_on_my_machine_classic_round_sticker-r56ce1cc314be46efbe749e9c58c761d5_v9waf_8byvr_540.jpg)

## Errores frecuentes

### El JDBC RESOURCE utiliza una pool inválida.
En estos casos, simplemente hay que modificar la pool que usa por la correcta.
_Services_ > _GlassFish_ > _Resources_ > _JDBC_ > _JDBC Resources_.
Hacemos click derecho en __jdbc/iweb__, propiedades y seleccionamos la pool __iwebPool__.


_Agradecimientos_: 
* A mi familia, por haberme apoyado durante todos estos años.
* A Álvaro, por haber dado con la solución.