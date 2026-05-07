# 🌌 SkyMap - Full Stack Astronomical Star Viewer

SkyMap is a full-stack web application that displays bright stars visible from different geographic latitudes using real astronomical data from the HYG Star Database.

The application automatically detects the user's location and also allows manual latitude exploration.

---

## 🚀 Features

- 🌍 Automatic geolocation detection
- ⭐ Displays bright visible stars dynamically
- 🔭 Manual latitude exploration
- ⚡ REST API powered by Spring Boot
- 📦 Real astronomical dataset integration
- 🎨 Modern responsive UI
- 🐳 Docker deployment support
- ☁️ Cloud deployment ready

---

## 🛠️ Tech Stack

### Frontend
- HTML
- CSS
- JavaScript

### Backend
- Java
- Spring Boot

### Deployment
- Docker
- Render

### Dataset
- HYG Star Database

---

## 📂 Project Structure

```text
Skymap/
├── Dockerfile
├── pom.xml
├── mvnw
├── src/
│   ├── main/
│   │   ├── java/com/bhavani/skymap/
│   │   │   ├── Star.java
│   │   │   ├── StarController.java
│   │   │   ├── StarService.java
│   │   │   └── SkymapApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── hygdata_v37.csv
│   │       └── static/
│   │           └── index.html
