# AIS-Practicas-4y5-2024

Autor(es): Ruben Ajenjo Roig, Lucas Rodríguez Díez

[Repositorio](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf.git)

[Aplicación Azure](http://ais-nitflex2.westeurope.azurecontainer.io:8080/)

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/114026662/ca359eb6-03f1-4ad0-b6af-63b1f6ceb2b7)


## Memoria Practica 4
### Primer Workflow
En primer lugar programamos el workflow que queda de la siguiente manera:

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/41f8bc7b-1d97-4b1c-8de3-04ded4f4254c)


En segundo lugar es necesario crearnos otra rama distinta a la main desde la cual realizaremos commits y deberán ejecutarse las pruebas unitarias y de integración. Esta rama se llamará test-branch.

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/51e6e522-20a7-4be4-b821-25dc63b2a490)

Como se puede apreciar al haber una cambio y hacer commit en la rama test-branch (en este caso en application.java) automaticamente se ejecuta el workflow con todos los tests

Si hacemos click sobre el workflow podemos apreciar como el job Run test se ha ejecutado correctamente

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/d6afff1d-000d-4edb-9a1e-5f2b8d54d94d)

### Segundo Workflow
En este caso el workflow se ejecutará cuando realicemos un pull reques. Nuestro workflow queda de la siguiente forma:

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/2ea0591f-5d19-4678-9978-bb6e4023a0a1)

Ahora realizamos el pull request y se debería de ejecutar el workflow numero 2

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/ba0f009a-75e1-496b-8410-92de424e2809)

Nos sale error debido a que los test de sistema implementados por nosotros en las prácticas anteriores fallan, sin embargo el test de sistema que viene predefinido en el repositorio funciona correctamente como se puede apreciar en la siguiente imagen:

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/d627bf8b-8fa3-45ed-9f65-37d103d6d99e)


### Tercer Workflow
En este caso el workflow queda de la siguiente manera:

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/ab210fae-0d63-4efb-9d26-c78259829389)
![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/024386ba-3f65-4f63-8d1d-7f6c363b7830)

El workflow tiene 3 jobs diferentes. El primer de ellos crea la imagen de Docker, el segundo despliega la aplicación en Azure y el tercero ejecuta el SmokeTest, previamente configurado

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/efd85b27-6fbd-46df-a1c7-3abb94dc3b7e)

Como podemos apreciar los 3 jobs han funcionado correctamente y se ha ejecutado el SmokeTest

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/a514751e-fc4a-4d30-8385-4c8e1b365e19)


### Cuarto Workflow
Dada la compatibilidad de los navegadores con los sitemas operativos se han ejecutado todas las posibles combinaciones de ambas matrices.

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/114026662/b8102fdf-ac77-4199-bdef-2413b7cc9f0c)

El workflow se ejecuta cada noche a las 02:00 UTC, es decir, a las 00:00 hora local.

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/114026662/600ab62d-b5d8-43ad-affa-0ef869d21304)

Se aprecia que se ejecuta FilmUITest correctamente en cada una de las ocasiones.

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/114026662/6be1ab88-82a2-4246-8832-f20c91712643)


