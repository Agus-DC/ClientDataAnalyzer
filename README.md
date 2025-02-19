# ClientDataAnalyzer API
API RESTful para gestionar clientes, calcular estadísticas y realizar operaciones relacionadas con eventos futuros.

# Tecnologías utilizadas
✅ Java 21
✅ Spring Boot 3 (Spring Web, Spring Data JPA, Spring Security)
✅ PostgreSQL (Base de datos)
✅ Docker (Para PostgreSQL local)
✅ Auth0 (Autenticación y autorización)
✅ Mockito y JUnit 5 (Testing)
✅ ModelMapper (Conversión de DTOs)

# Estructura del proyecto
src/main/java/com/challenge/client/
│── config/              # Configuración (seguridad, mappers, etc.)
│── controller/          # Controladores REST (ClientController, etc.)
│── dto/                 # DTOs para transferencia de datos
│── exception/           # Excepciones personalizadas
│── model/               # Entidades JPA (Client, etc.)
│── repository/          # Acceso a la BD (ClientRepository)
│── service/             # Lógica de negocio (ClientCommand, ClientQuery, etc.)
│── queue/               # Productor de mensajes (QueueProducer)
│── ClientApplication.java  # Clase principal con @SpringBootApplication

# Instalacion y configuracion
git clone https://github.com/tu-repositorio.git
cd client-management-api

# Endpoints principales

📝 CRUD de Clientes (/clients)
Método	Endpoint	                        Descripción
POST	/clients/create	                    Crea un nuevo cliente
GET	    /clients/get-all?page=0&size=10 	Obtiene clientes paginados

📊 Estadísticas (/clients/statistics)
Método	Endpoint	            Descripción	
GET	    /clients/statistics 	Retorna promedio y desviación estándar de edad

📅 Eventos (/clients/event)
Método	Endpoint	                    Descripción
GET	    /clients/{id}/life-expectancy	Calcula la esperanza de vida del cliente

📌 Mejoras futuras
- Implementar Swagger para documentación de la API
- Ajuste de Docker compose
