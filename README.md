Este es mi repositorio de la aplicación de Spring Boot. He creado la interfaz del servicio de Pokédex y su correspondiente implementación, junto con un controlador que expone dos endpoints: uno para acceder a la Pokédex y obtener resultados paginados (utilizando los parámetros offset y limit), y otro para recuperar el detalle de cada Pokémon por su nombre.

Además, incluyo capturas de pantalla que muestran cómo realicé el despliegue en AWS. Desplegué dos aplicaciones:

Frontend: Una aplicación en React, desplegada con AWS Amplify y conectada directamente al repositorio de GitHub. Cada vez que se realizan cambios en la rama master, se despliega automáticamente.
Backend: La aplicación de Spring Boot, desplegada en una instancia EC2.
Detalle de Pokémon: Permite obtener información de un Pokémon por su nombre.
Resultados paginados: Devuelve una lista de Pokémon según los parámetros offset y limit.
La aplicación se despliega en AWS Elastic Beanstalk y utiliza CaffeineCache para la gestión de caché.
Endpoint para detalle:
http://aplicacion-env.eba-p22dcwvp.us-east-2.elasticbeanstalk.com/pokedex/pokemon/pikachu
Endpoint para paginación:
http://aplicacion-env.eba-p22dcwvp.us-east-2.elasticbeanstalk.com/pokedex?offset=0&limit=10
API Gateway:
Dado que la aplicación carecía de un dominio certificado, se implementó un API Gateway en AWS para mapear los endpoints a URLs con HTTPS, facilitando la comunicación segura entre el frontend y el backend.
Endpoint para detalle:
https://xe40edt7y4.execute-api.us-east-2.amazonaws.com/prod/pokedex/pokemon/pikachu
Endpoint para paginación:
https://xe40edt7y4.execute-api.us-east-2.amazonaws.com/prod/pokedex?offset=0&limit=10
El frontend está desarrollado en React y, en la aplicación de Spring Boot, se utiliza CaffeineCache para el manejo de caché.
Repositorio en GitHub:
https://github.com/diana-herrera-fca/reactPokedex
URL de la aplicación:
https://master.d2y12r4xc83xma.amplifyapp.com/
Deploy de EC2
![Captura de pantalla 2025-03-13 085931](https://github.com/user-attachments/assets/8c2517c5-b237-4243-b0e0-91bce27c5a57)
![Captura de pantalla 2025-03-13 085859](https://github.com/user-attachments/assets/296aae4b-3b61-4f37-aca5-956eee848eac)
![Captura de pantalla 2025-03-13 085754](https://github.com/user-attachments/assets/fb84b11e-ec1a-46a9-83a9-498c3d021c04)
![Captura de pantalla 2025-03-13 085743](https://github.com/user-attachments/assets/fe8c2ad2-c41a-4853-8665-8130590b9883)
![Captura de pantalla 2025-03-13 085213](https://github.com/user-attachments/assets/39a3ace4-6c5e-4780-b298-bf471f27efc6)
![Captura de pantalla 2025-03-13 084815](https://github.com/user-attachments/assets/9ee65575-693c-4392-951e-4901c8780e9c)
![Captura de pantalla 2025-03-13 084745](https://github.com/user-attachments/assets/40325881-1be5-415d-b989-c87b82550592)
![Captura de pantalla 2025-03-13 084718](https://github.com/user-attachments/assets/df090779-73d8-44a8-8071-cb7c83458f8a)
![Captura de pantalla 2025-03-13 084658](https://github.com/user-attachments/assets/a852a98f-4b3c-4189-8719-8eca81b6e22d)
![Captura de pantalla 2025-03-13 084638](https://github.com/user-attachments/assets/2d7798d8-b1c8-4cbe-9f04-ceb91635d425)
![Captura de pantalla 2025-03-13 084612](https://github.com/user-attachments/assets/4bc01095-e7a5-4183-9c76-07f29def371b)

Deploy Amplify 
![Captura de pantalla 2025-03-13 084530](https://github.com/user-attachments/assets/161fb93d-0a7d-4709-bf42-2c7e127d8767)
![Captura de pantalla 2025-03-13 084508](https://github.com/user-attachments/assets/a9565f9c-6d4f-46a9-9005-e2206d5447a7)
![Captura de pantalla 2025-03-13 084429](https://github.com/user-attachments/assets/a773192e-d1ef-44b9-9beb-b54c8d260bb5)
