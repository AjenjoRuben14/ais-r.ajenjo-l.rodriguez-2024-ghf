# AIS-Practicas-4y5-2024

Autor(es): Ruben Ajenjo Roig, Lucas Rodríguez Díez

[Repositorio](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf.git)

[Aplicación Azure](http://ais-nitflex2.westeurope.azurecontainer.io:8080/)

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

Nos sale error debido a que los test de sistema implementados por nosotros en las prácticas anteriores fallan, sin embargo tanto el test de sistema que viene predefinido en el repositorio funciona correctamente como se puede apreciar en la siguiente imagen:

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
Dada la compatibilidad de los navegadores con los sitemas operativos se han ejecutado todas las posibles combinaciones de ambas matrices

![image](https://github.com/AjenjoRuben14/ais-r.ajenjo-l.rodriguez-2024-ghf/assets/67601117/0801b9b5-fec7-4f47-a3eb-ee0be7d463e5)


Una vez realizado el workflow realizamos un 


## Desarrollo con GitHubFlow (Práctica 5)

Una vez creados los workflows y funcionando estos, pasamos a crear la nueva funcionalidad utilizando GithubFlow:

Clonamos el repositorio

```
$ git clone ...
....

Ejemplo de un enlace en Markdown: [Workflow 1](https://github.com/URJC-AIS/continuous-deployment-azure/actions/runs/8746724116)
