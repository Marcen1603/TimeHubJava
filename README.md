# TimeHubJava

In this project the goal is to create a time tracking tool with some extra features like a ticket system, todo-list,
event-system and export functions. The project has the 'Java' extension in his name, because the first idea was to
create this project with C++. Maybe the C++ version will continued in the feature.

## Version

### 0.1

## Developing

This section is about all important things about the developing process in this project. Things like the formatting are
part of this section and how this should be set up.

### Database

Part of this software are different types of data, for example the tickets which needs a id, description, progress and
so on. These data should be stored at a local save point to keep the data persistent. This is done by a Sqlite database

Part of this software are different types of data, for example it possible to create ticket, todo-entries or save the
invested time for the different tickets. For each of these types different information are available and should be
stored. To handle this, a sqlite database is used which is able to store all of this information in the tables of the
database on the local filesystem. Storing this data is needed to load them after a restart and use them also after a
long time period.

#### Database vs. File

Different options are available to store the data of the software in the local system to keep them persistent. Possible
options are databases like sqlite and postgres or something what is more like a file like a json oder csv
file. <br> <br>

Positive aspects for the files like json or csv are, that these files can be opened on each operating system and see the
saved data. Negative for this option are the structure and complexity of these files, if a large amount of data is
stored in such files, than they need a lot of disc space and or not very easy to view. <br><br>

Compared with the files like json and csv, the databases or not so easy to view, but this should be no criteria in this
use case. A database offers more options to structure how the data is saved, instead of saving all data into the same
file or multiple files, there will be one database with multiple tables. Also, the operations are easier and faster with
a database, instead of parsing a json file and iterate over it, simple sql statements can be used to get the needed data
from the database.

#### Tables

Currently, the statements to create the different table in the database are part of the classes. For a better
documentation the used statements are shown in the following: <br>

Ticket-Table

```sql
CREATE TABLE IF NOT EXISTS tickets (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          title TEXT NOT NULL,
                          description TEXT,
                          status TEXT NOT NULL,
                          progress INTEGER,
                          acceptance_criteria TEXT,
                          history TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    );
```

TimeEntries

```sql
CREATE TABLE IF NOT EXISTS time_entries (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          ticket_id INTEGER NOT NULL,
                          minutes INTEGER NOT NULL,
                          commit_message TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                          worked_at TIMESTAMP NOT NULL,
                          FOREIGN KEY (ticket_id) REFERENCES tickets(id)
);
```

ToDo´s

```sql
CREATE TABLE IF NOT EXISTS to_dos (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          title TEXT,
                          description TEXT,
                          status TEXT NOT NULL
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                          finished_at TIMESTAMP NOT NULL,
);
```

Configuration

```sql
CREATE TABLE IF NOT EXISTS configuration (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          name TEXT,
                          description TEXT,
                          value TEXT,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
### Formatting

There are already good guidelines for some aspects of programming, including formatting in the individual programming
languages. In Java, naming is carried out on the basis of the camel case notation. Other things like where the start and
ending curly bracket of method should be placed (same row as the declaration or in the following row) is not clear
sometimes. To avoid different code styling like this the 'Java Google Style' is used. There are different ways to use
such a styling file in the ide`s. In the official GitHub repo
(https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml) you are able to download it from
there and use it. In some IDEs like IntelliJ (in my case) there are also plugins available to handle this. In the
following will be describe how to set up this for IntelliJ easily. <br>

1. Go to Menu -> Settings -> Plugin -> Marketplace
2. Search for 'google-java-format'
3. Install it and close the window (another restart is required later)
4. Go to Menu -> Help -> Edit Custom VM Options...
5. Add the following to the opened file:

```text
--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
```

6. Restart the IDE
7. Go to Menu -> Settings -> google-java-format Settings
8. Enable the google-java-format and select 'Default Google Java Style' as format