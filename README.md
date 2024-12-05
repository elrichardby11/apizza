# Spring-SQLServer
Esta es una aplicación en **Spring Boot** conectada a una base de datos **SQL Server**.

## Pasos para la Instalación

### 1. Abrir SQL Server Management Studio
Abre **SQL Server Management Studio (SSMS)** en tu máquina para gestionar tu base de datos.

### 2. Crear la base de datos y el usuario
Ejecuta el siguiente script SQL para crear la base de datos y el usuario con los permisos correspondientes:

```sql
CREATE DATABASE apizza;
GO

USE apizza;
GO

CREATE LOGIN RICHARD 
WITH PASSWORD = 'CFT.2024';

CREATE USER RICHARD
FOR LOGIN RICHARD;
GO

ALTER SERVER ROLE sysadmin ADD MEMBER RICHARD;
```

Este script crea una base de datos llamada **TIENDITA** y un usuario llamado **RICHARD** con la contraseña `CFT.2024`,
además, se le añade un rol para evitar futuros problemas.

### 3. Configurar la seguridad en SQL Server
Configura el nivel de seguridad en SQL Server para permitir conexiones usando autenticación SQL Server.

- Ve a **Propiedades** y luego a **Seguridad** dentro de **SQL Server Management Studio**.
- Asegúrate de que la opción **SQL Server and Windows Authentication mode** esté habilitada.

![image](https://github.com/user-attachments/assets/0b61b965-0c5a-4562-b8d3-312cc37042d3)

### 4. Abrir SQL Server Configuration Manager
Abre **SQL Server Configuration Manager** para realizar configuraciones adicionales.

- Para abrirlo, ve a **Inicio** y busca **SQL Server Configuration Manager**.
- Aquí podrás gestionar las configuraciones de red y los protocolos para permitir conexiones externas.

### 5. Configurar los puertos en SQL Server
En el **SQL Server Configuration Manager**, realiza los siguientes pasos para habilitar los puertos de conexión:

1. Ve a **SQL Server Network Configuration**.
2. Selecciona **Protocols for MSSQLSERVER**.
3. Asegúrate de que toda la sección esté habilitado.

![image](https://github.com/user-attachments/assets/ad6edb22-7264-4e24-824e-76c9121640cd)

### 6. Reiniciar el servicio de SQL Server
Después de configurar los puertos y la seguridad, debes reiniciar el servicio de SQL Server para que los cambios tengan efecto.

1. Abre **SQL Server Configuration Manager**.
2. Ve a **SQL Server Services**.
3. Haz clic derecho sobre **SQL Server (MSSQLSERVER)** y selecciona **Reiniciar**.

![image](https://github.com/user-attachments/assets/6b94f69c-1004-414a-9c91-832436e23bbb)

¡Listo! Ahora tu entorno está configurado y la aplicación puede interactuar con la base de datos en **SQL Server**.

### Datos de Inicio (recomendable)

```sql
INSERT INTO pizza
           (description
           ,available
           ,name
           ,price
           ,vegan
           ,vegetarian)
     VALUES
           ('queso, tomate, jamon, oregano, aceituna',
           1,
           'La Napolitana',
           8990,
           0,
           0),
		   ('queso, pepperoni',
           1,
           'La Pepperoni',
           7990,
           0,
           0),
		   ('queso vegano, tomate, oregano, aceituna, piña',
           1,
           'La hawai',
           9990,
           1,
           1),
		   ('queso, palta, tomate, palmitos, cebolla',
           1,
           'La primavera',
           10990,
           0,
           1),

		   ('queso, pimenton',
           1,
           'La Pime',
           7990,
           0,
           1)

INSERT INTO customer
           (mail
           ,name
           ,cellphone)
     VALUES
           ('juan@cft.cl',
           'Juan',
           '911111111'),
		   ('maria@cft.cl',
           'Maria',
           '922222222'),
		   ('richy@cft.cl',
           'Richy',
           '933333333')
```