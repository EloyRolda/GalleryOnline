# GalleryOnline

Aplicación web para organizar y almacenar imágenes en galerías personales. Cada usuario puede registrarse, iniciar sesión y gestionar sus propias galerías con imágenes subidas a la nube. Diseño con estética retro inspirada en Windows 98.

## 🚀 Demo

[https://galleryonline-production.up.railway.app](https://galleryonline-production.up.railway.app)

---

## 📸 Screenshots

### Login y Registro
![Login y Registro](1_Home_Login_And_Register.png)

### Mis Galerías
![Mis Galerías](2_Gallery_Home.png)

### Vista de Galería
![Vista de Galería](3_In_gallery.png)

---

## ✨ Funcionalidades

- Registro e inicio de sesión con JWT
- Creación de galerías personales
- Subida de imágenes a Cloudinary
- Visualización de imágenes por galería
- API REST documentada con Swagger

---

## 🛠️ Tecnologías

| Capa | Tecnología |
|------|-----------|
| Backend | Java 21 · Spring Boot 4 |
| Seguridad | Spring Security · JWT (jjwt) |
| Base de datos | MySQL · Spring Data JPA · Hibernate |
| Almacenamiento | Cloudinary |
| Documentación | SpringDoc OpenAPI (Swagger) |
| Deploy | Railway |
| Build | Maven |

---

## 📁 Estructura del proyecto

```
src/
├── main/
│   ├── java/EloyCo/GalleryOnline/
│   │   ├── Config/          # Seguridad, JWT filter, Cloudinary
│   │   ├── Controller/      # AuthController, GalleryController, UserController
│   │   ├── DTO/             # Objetos de transferencia de datos
│   │   ├── Exceptions/      # Manejo global de excepciones
│   │   ├── Model/           # Entidades: User, Gallery, Image
│   │   ├── Repository/      # Interfaces JPA
│   │   └── Service/         # Lógica de negocio
│   └── resources/
│       └── static/          # Frontend (index.html, gallery.html)
└── test/
```

---

## 📡 Endpoints

### Auth
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| POST | `/auth/login` | Iniciar sesión, devuelve JWT | No |

### Usuario
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| POST | `/user/register` | Registrar nuevo usuario | No |

### Galerías
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| GET | `/gallery/mygallery` | Listar galerías del usuario | Sí |
| POST | `/gallery/create` | Crear nueva galería | Sí |
| GET | `/gallery/{id}/images` | Obtener imágenes de una galería | Sí |
| POST | `/gallery/upload` | Subir imagen a una galería | Sí |

Documentación completa: `/swagger-ui/index.html`

---

## ⚙️ Variables de entorno

```env
DATABASE_URL=jdbc:mysql://host:port/database
DATABASE_USERNAME=usuario
DATABASE_PASSWORD=contraseña

CLOUDINARY_CLOUD_NAME=tu_cloud_name
CLOUDINARY_API_KEY=tu_api_key
CLOUDINARY_API_SECRET=tu_api_secret

JWT_SECRET=clave_minimo_32_caracteres
PORT=8080
```

---

## 🏃 Correr localmente

**Requisitos:** Java 21, Maven, MySQL

1. Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/GalleryOnline.git
cd GalleryOnline
```

2. Crear un archivo `.env` con las variables de entorno (ver sección anterior)

3. Ejecutar
```bash
./mvnw spring-boot:run
```

4. Abrir en el navegador
```
http://localhost:8080
```

---

## 📄 Licencia

Ninguna pa