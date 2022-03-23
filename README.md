# Getting Started

### Compile Code
* ./mvnw.cmd clean compile -e

### Test Code
* ./mvnw.cmd clean test -e

### Jar Code
* ./mvnw.cmd clean package -e

### Run Jar
* Local:      ./mvnw.cmd spring-boot:run 
* Background: nohup bash mvnw.cmd spring-boot:run &

### Consulta Application 10%
* Abrir navegador: http://localhost:8080/rest/msdxc/dxc?sueldo=1000&ahorro=1000

### Consulta Impuesto
* Abrir navegador: http://localhost:8080/rest/msdxc/impuesto?sueldo=1000

### Consulta Saldo
* Abrir navegador: http://localhost:8080/rest/msdxc/saldoahorro?ahorro=1000