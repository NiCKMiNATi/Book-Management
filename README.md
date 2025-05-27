## This is a Task Management Web application built with:

Java Spring Boot Framework
JPA, H2, Lombok dependencies

## Main Folders - 
1. Model - aka Entity
2. Repository - an Interface to interact with DB
3. Service - Business Logic, and here is where we define some of the important methods
4. Controller - Gets request from User and returns back as Response [This is what makes our webapp an API]
5. Templates - HTML files

## Detailed Explanation:
### Model - 
  - also known as Entity
  - Used to store necessary variables
  - Uses @Entity annotation, to let the JPA know that this class will be used as a table, so automatically a table will be created with the variables as fields.
  - Then, uses
      - @Id annotation -> To make ID as the primary key/field.
      - @GeneratedValue(strategy = Generationtype.IDENTITY) -> To let JPA automatically generate IDs
      - @Data annotation -> Lombok annotation to automatically create getter, setter methods
      - @NoArgsConstructor, @ReqArgsConstructor, @AllArgsConstructor -> Used to automatically create necessary constructors

### Repository -
  - An Interface which lets us contact the DB
  - Extends the JpaRepository Interface with the Model class object, and Long variable(primary key, in this case Id) as the arguments
      (ie) for example,
      ```java
      public interface MovieRepository extends JpaRepository<Movie, Long>
      ```
  - By default, creates save(), create(), findById(), findAll(), deleteById(), deleteAll() methods

### Service - 
  - Where Backend starts
  - Uses @Service annotation to let JPA know this class is gonna be a service
  - Create methods like getAllMovies(), getMovieById(), save/createMovie(), deleteMovie()
  - Uses @Autowired annotation to inject Repository into the Service and automatically add dependencies

### Controller - 
  - Uses @Controller annotation to let JPA know this is the controller class
  - Uses @RequestMapping to create base path/URL
  - Receives HTTP request from User/client, and sends back Response to User.
  - Also uses @GetMapping, @PostMapping, @DeleteMapping etc to map to certain paths/URL
