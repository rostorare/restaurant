![CI](https://github.com/rostorare/restaurant/actions/workflows/tests.yml/badge.svg)
#readme
- Setup:
  Set enviromentvariables according to your wishes, in windows the DatasourceURl could look like this
  jdbc:h2:file:~\src\h2
  The username and password can be chosen freely
  url: ${DATASOURCE_URL}
  username: ${DATASOURCE_USERNAME}
  password: ${DATASOURCE_PASSWORD}
  The port used is 8080, and the application should be reached on http://localhost:8080/
  

Start application:
    in the Terminal write gradle build
    and after building write gradle bootrun to start the application    
    If this doesnt work, in intellij  build  application via CTRL+F9 and start it with  shit+F10


Demoseite eines Restaurants
- möglichkeit menu als zb. csv. oder einzeln hochzuladen
- einbindung google maps für navigation
- möglichkeit Fotos hochzuladen.
- frontend via heroku
- Reservationen über fronted machen
- Dynamische anzeige der vorhandenen Tische

