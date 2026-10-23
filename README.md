# Domain Driven Design Example

A console-based online course application written in Java. Students can register
and sign in, browse courses, join courses, and work with course materials,
assignments, and submissions. Teacher-facing flows include course management and
salary/payment examples. The code is organized around domain areas such as
accounts, courses, and payments.

The application uses plain text files as its local data store, so it does not
require a database server. The Eclipse project metadata is included.

## Run

Install a JDK, then compile and launch from the Project directory so the
file-backed repositories resolve their data files correctly:

~~~sh
cd Project
mkdir -p bin
find src -name '*.java' -print0 | xargs -0 javac -d bin
java -cp bin view.LandingPage
~~~

The bundled text records live under Project/database. Back them up before
experimenting with changes to the sample data.
