Web application, built with Spring.
Provides a JSON API compatible
with [Church Calendar API][churchcal] v0
(which can thus be consumed with
[calendarium-romanum-remote][calromr]).
Instead of computing the calendar data,
it has them pre-generated in the database.

# Compiling and running

This is a Spring project built using Maven.

`$ mvn spring-boot:run`

to compile and run with a built-in server.
For other building options see Spring documentation.

[churchcal]: https://github.com/igneus/church-calendar-api
[calromr]: https://github.com/igneus/calendarium-romanum-remote
